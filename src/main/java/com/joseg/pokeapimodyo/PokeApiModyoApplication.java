package com.joseg.pokeapimodyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PokeApiModyoApplication {

  public static void main(String[] args) {
    SpringApplication.run(PokeApiModyoApplication.class, args);
  }
}
