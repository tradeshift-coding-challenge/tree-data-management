package com.tradeshift.service;

import java.util.List;

import com.tradeshift.model.ChangeAncestorRequest;
import com.tradeshift.model.TreeNode;

public interface TreeDataManagementService 
{
	//Get all descendants for an ancestor.
	public List<TreeNode> descendants(String ancestorId);
    
	//Change Parent
	public void changeAncestor(ChangeAncestorRequest changeAncestorRequest);
}
