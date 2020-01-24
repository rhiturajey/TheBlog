package com.BlogPost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheBlogApplication.class, args);
	}

}
/*
 * I had a similar problem with lazy loading via the hibernate proxy object. Got around it by annotating the class having lazy loaded private properties with:

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
I assume you can add the properties on your proxy object that breaks the JSON serialization to that annotation.

The problem is that entities are loaded lazily and serialization happens before they get loaded fully.

Hibernate.initialize(<your getter method>);
 */