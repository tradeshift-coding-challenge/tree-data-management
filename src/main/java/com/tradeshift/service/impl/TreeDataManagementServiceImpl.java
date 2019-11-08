package com.tradeshift.service.impl;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tradeshift.dao.TreeDataManagementDAO;
import com.tradeshift.exception.NoDescendantsFoundException;
import com.tradeshift.exception.RequestDataValidationException;
import com.tradeshift.model.ChangeAncestorRequest;
import com.tradeshift.model.TreeNode;
import com.tradeshift.service.TreeDataManagementService;

@Service
public class TreeDataManagementServiceImpl implements TreeDataManagementService {

	static TreeNode root;

	@Autowired
	private TreeDataManagementDAO treeDataManagementDAO;

	@Override
	public List<TreeNode> descendants(String ancestorId) {

		// Check 'Ancestor Id' is digit number
		if (!NumberUtils.isDigits(ancestorId)) {
			throw new RequestDataValidationException(" In valid Ancestor Id.");
		}

		long id = NumberUtils.toLong(ancestorId);
		List<TreeNode> descendants = this.treeDataManagementDAO.descendants(id);

		// Check if Ancestor node is present in the tree
		if (descendants != null && descendants.isEmpty()) {
			throw new NoDescendantsFoundException(" No Descendants Found for given ancestor Id :  " + ancestorId);
		}

		// Get Root Node
		if (root == null) {
			root = this.treeDataManagementDAO.root();
			root.setAncestorId(0);
			root.setHeight(0);
		}

		// Get the depth of the Ancestor in the tree
		Long currentAncestorsDepth = this.treeDataManagementDAO.getDepth(id);

		descendants.forEach(node -> {
			node.setHeight(node.getHeight() + currentAncestorsDepth);
			node.setRootId(root.getId());
		});

		return descendants;
	}

	@Override
	public void changeAncestor(ChangeAncestorRequest changeAncestorRequest) {

		long descendantId = NumberUtils.toLong(changeAncestorRequest.getDescendantId());
		long newAncestorId = NumberUtils.toLong(changeAncestorRequest.getNewAncestorId());

		this.treeDataManagementDAO.deleteOudatedAncestorsPaths(descendantId);
		this.treeDataManagementDAO.addNewPaths(descendantId, newAncestorId);
	}

}
