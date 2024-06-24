package com.example.win;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WinApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinApplication.class, args);
	}

}
