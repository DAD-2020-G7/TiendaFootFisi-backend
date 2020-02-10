package com.footfisi.tienda.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.footfisi.tienda")
@Import(value = { RepositoryConfiguration.class })
public class ApplicationConfiguration {

}
