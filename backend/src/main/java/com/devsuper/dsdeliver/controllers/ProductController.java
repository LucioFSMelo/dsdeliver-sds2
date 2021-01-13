package com.devsuper.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuper.dsdeliver.dto.ProductDTO;
import com.devsuper.dsdeliver.services.ProductService;

//Colocamos o "@RestController" para fazer um controlador Rest no Spring Boot
@RestController
@RequestMapping(value = "/products") //Aqui definimos o caminho para nosso recurso
public class ProductController {
	
	//Estamos fazendo agora um "EndPoint" para responder pelo caminho que criamos
	@Autowired
	private ProductService service;
	
	//Esse aqui é o "EndPoint"
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> list = service.findAll(); //retorna uma lista de objetos
		return ResponseEntity.ok().body(list);
	}

}
