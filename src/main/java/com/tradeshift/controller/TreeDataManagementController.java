package com.tradeshift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tradeshift.model.ChangeAncestorRequest;
import com.tradeshift.model.TreeNode;
import com.tradeshift.service.TreeDataManagementService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TreeDataManagementController 
{
	
	@Autowired
	private TreeDataManagementService treeDataManagementService;
	
	@ApiOperation(value = "View a list of descendants of a node", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 400, message = " No Descendants Found for given ancestor Id"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/nodes/{ancestor_id}")
    public ResponseEntity<List<TreeNode>> descendants(@PathVariable(name = "ancestor_id") String ancestorId)
	{
		List<TreeNode> response = this.treeDataManagementService.descendants(ancestorId); 
		return new ResponseEntity<List<TreeNode>>(response,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Change the ancestor of a node.", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = ""),
	    @ApiResponse(code = 500, message = "Internal Server Error. Please try again.")
	})
	@PutMapping("/nodes/changeAncestor")
    public ResponseEntity<Object> changeAncestor(@RequestBody ChangeAncestorRequest changeAncestorRequest)
	{
		this.treeDataManagementService.changeAncestor(changeAncestorRequest); 
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

}
