package com.tradeshift.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tradeshift.dao.TreeDataManagementDAO;
import com.tradeshift.model.ChangeAncestorRequest;
import com.tradeshift.model.TreeNode;

@Repository
public class TreeDataManagementDAOImpl implements TreeDataManagementDAO 
{
    @Autowired
    private Environment environment;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TreeNode> descendants(long ancestorId) {
		String query = environment.getProperty("QUERY_GET-DESCENDANTS");
		List<TreeNode> descendants = this.jdbcTemplate.query(query,new Object[] { ancestorId}, new TreeNodeRowMapper());
		return descendants;
	}

	@Override
	public TreeNode root() 
	{
		String query = environment.getProperty("QUERY_FIND_ROOT_NODE");
		TreeNode root = this.jdbcTemplate.queryForObject(query, new TreeNodeRowMapper());
		return root;
	}

	@Override
	public Long getDepth(long ancestorId) {
		String query = environment.getProperty("QUERY_FIND_CURRENT_ANCESTOR_DEPTH"); 
		Long depth = jdbcTemplate.queryForObject(query, new Object[] { ancestorId },Long.class); 
		return depth;
	}

	@Override
	public Long immediateAncestorId(long ancestorId) {
		String query = environment.getProperty("QUERY_FIND_IMMEDIATE_ANCESTOR_ID"); 
		Long immediateAncestorId = jdbcTemplate.queryForObject(query, new Object[] { ancestorId },Long.class); 
		return immediateAncestorId;
	}

	
	
	
	@Override
	public int deleteOudatedAncestorsPaths(long descendantId) {
		String query = environment.getProperty("QUERY_DELETE_OUTDATED_CLOUSER_PATHS"); 
		int noOfPathDeleted = jdbcTemplate.update(query, new Object[] { descendantId }); 
		return noOfPathDeleted;
	}

	@Override
	public int addNewPaths(long descendantId, long newAncestorId) {
		String query = environment.getProperty("QUERY_ADD_NEW_PATHS"); 
		int noOfPathAdded = jdbcTemplate.update(query, new Object[] { descendantId,newAncestorId }); 
		return noOfPathAdded;
	}
}
