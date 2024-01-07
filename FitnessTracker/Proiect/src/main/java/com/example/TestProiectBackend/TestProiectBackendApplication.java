package com.example.TestProiectBackend;

import com.example.TestProiectBackend.Controller.*;
import com.example.TestProiectBackend.Model.*;
import com.example.TestProiectBackend.Repository.*;
import com.example.TestProiectBackend.Service.*;
import com.example.TestProiectBackend.Service.Implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class TestProiectBackendApplication {

	//private final AlimentRepository alimentRepository;
	public static void main(String[] args) {
		SpringApplication.run(TestProiectBackendApplication.class, args);
	}
}
