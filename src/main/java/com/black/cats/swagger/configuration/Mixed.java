package com.black.cats.swagger.configuration;

import java.util.Map;

import lombok.Data;

@Data
public class Mixed {
	
	/** The multi format supported*/
	private boolean multiFormat;
	
	/** The key-value pair for name and format */
	private Map<String, String> name;

}
