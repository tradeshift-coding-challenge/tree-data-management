package com.tradeshift.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder(value = {"id","role","ancestorId","actualTreeDepth","currentSubTreeDepth"})
public class TreeNode 
{
	private long id;
	private String role;
	private long ancestorId;
	private long rootId;
	private long height;
}
