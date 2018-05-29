package me.annaisakova.mappers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MappersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappersApplication.class, args);
	}
}
