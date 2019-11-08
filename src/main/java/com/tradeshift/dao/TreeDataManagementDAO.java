package com.tradeshift.dao;

import java.util.List;

import com.tradeshift.model.TreeNode;

public interface TreeDataManagementDAO 
{
	public TreeNode root();
	public Long getDepth(long ancestorId);
	
	public List<TreeNode> descendants(long ancestorId);
	
	public int deleteOudatedAncestorsPaths(long descendantId);
	public int addNewPaths(long descendantId, long newAncestorId);
	Long immediateAncestorId(long ancestorId);
}
