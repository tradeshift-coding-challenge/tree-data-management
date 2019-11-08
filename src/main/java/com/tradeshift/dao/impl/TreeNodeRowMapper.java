package com.tradeshift.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tradeshift.model.TreeNode;

public class TreeNodeRowMapper implements RowMapper<TreeNode> {
    
	
	@Override
    public TreeNode mapRow(ResultSet rs, int rowNum) throws SQLException {
    	TreeNode node = new TreeNode();
    	node.setId(rs.getLong("ID"));
    	node.setRole(rs.getString("ROLE"));
        node.setHeight(rs.getLong("DEPTH"));   	
        node.setAncestorId(rs.getLong("ANCESTOR_ID"));
        return node;
    }
}