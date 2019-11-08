package com.tradeshift.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@XmlRootElement(name = "error")
@AllArgsConstructor
public class ErrorResponse 
{
	private String message;
}