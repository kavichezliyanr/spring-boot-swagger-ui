/**
 * 
 */
package com.black.cats.swagger.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="spring.swagger.ui")
public class SwaggerProperties {
	
	private List<String> names;
	
	private String path;
	
	private String format;
	
	private Mixed mixed;

}
