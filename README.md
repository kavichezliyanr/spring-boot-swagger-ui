# Spring boot Swagger UI Builder with simple configuration
Build you Swagger files to UI with simple spring boot auto configuration.
Just updating the properties required for spring boot autoconfig to build the swagger ui and render in your local host.

## Swagger UI Auto Configuration

### Define all the swagger ui files format with single format
```spring.swagger.ui.names= petstore,petstore2
spring.swagger.ui.path=/swagger
spring.swagger.ui.format=yaml
```

### Define all the swagger ui files format with mixed format
```
spring.swagger.ui.mixed.multi-format= true
spring.swagger.ui.mixed.name.petstore=yaml
spring.swagger.ui.mixed.name.petstore3=json
```
