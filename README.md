# Spring boot Swagger UI Builder with simple configuration
Build you Swagger files to UI with simple spring boot auto configuration.
Just updating the properties required for spring boot autoconfig to build the swagger ui and render in your local host.

## Swagger UI Auto Configuration

### Define all the swagger ui files format with single format

Configure all the yaml or json with single path and single format if we just drop the file in you classpath under static folder which will render in UI

```
spring.swagger.ui.names= petstore,petstore2
spring.swagger.ui.path=/swagger
spring.swagger.ui.format=yaml
```

### Define all the swagger ui files format with mixed format

Configure multi format or mixed format like json or yaml under below properties which will auto config the application

```
spring.swagger.ui.mixed.multi-format= true
spring.swagger.ui.mixed.name.petstore=yaml
spring.swagger.ui.mixed.name.petstore3=json
```
