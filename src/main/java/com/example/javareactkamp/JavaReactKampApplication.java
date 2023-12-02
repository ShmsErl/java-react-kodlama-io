package com.example.javareactkamp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class JavaReactKampApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaReactKampApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();

    }
}
