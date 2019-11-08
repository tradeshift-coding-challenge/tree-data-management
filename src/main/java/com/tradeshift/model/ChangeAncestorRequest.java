package com.tradeshift.model;

import lombok.Data;

@Data
public class ChangeAncestorRequest 
{
	private String descendantId;
	private String newAncestorId;
}
