package com.black.cats.swagger.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;


/**
 * The Class SwaggerAutoConfiguration.
 */
@Configuration
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {
	
	/**
	 * Swagger.
	 *
	 * @return the docket
	 */
	@Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }
	
	/**
	 * Swagger resources provider.
	 *
	 * @param defaultResourcesProvider the default resources provider
	 * @param swaggerProperties the swagger properties
	 * @return the swagger resources provider
	 */
	@Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(
			InMemorySwaggerResourcesProvider defaultResourcesProvider, SwaggerProperties swaggerProperties) {
		return () -> {
			List<SwaggerResource> swaggerResources = new ArrayList<>();
			swaggerProperties.getNames().forEach(resource -> {
				swaggerResources.add(addResource(resource, swaggerProperties.getFormat(),swaggerProperties.getPath()));
			});
			if (swaggerProperties.getMixed().isMultiFormat()) {
				swaggerProperties.getMixed().getName().entrySet().forEach(
						loader-> swaggerResources.add(addResource(loader.getKey(),loader.getValue(),swaggerProperties.getPath())));
			}
			return swaggerResources;
		};
	}
	
	/**
	 * Adds the resource.
	 *
	 * @param resourceName the resource name
	 * @param format the format
	 * @param path the path
	 * @return the swagger resource
	 */
	private SwaggerResource addResource(String resourceName, String format, String path) {
		 SwaggerResource uiResource = new SwaggerResource();
    	 uiResource.setName(resourceName);
    	 uiResource.setSwaggerVersion("2.0");
    	 uiResource.setLocation(generatePath(resourceName, format,path));
		return uiResource;	
	}
	
	/**
	 * Generate path.
	 *
	 * @param resourceName the resource name
	 * @param format the format
	 * @param path the path
	 * @return the string
	 */
	private String generatePath(String resourceName, String format, String path) {
		return new StringBuilder().append(path)
   			 .append("/").append(resourceName).append(".").append(format).toString();
	}

}

