package com.devsuper.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuper.dsdeliver.dto.ProductDTO;
import com.devsuper.dsdeliver.entities.Product;
import com.devsuper.dsdeliver.repositories.ProductRepository;


/*Para fazer a injeção de dependencias, temos que registrar o componente
 *no sistema do Spring Boot
 *O ProductService é um componente, logo ele depende de outro componente que é o 
 *ProductRepository*/
@Service
public class ProductService {
	
	//Aqui queremos que retorne uma lista de product DTO
	//temos que fazer uma implementação para buscar todos os produtos do banco de dados
	//Logo, vamos usar o product Repository
	
	@Autowired //Essa anotation já faz a resolução de dependendia de forma transparente
	private ProductRepository repository;
	
	/*Agorta vamos buscar os produtos do DB
	 *e se quisermos garantir transação e que realmente facha conecção com o DB,
	 *devoms colocar o "@Transactional"*/
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		/*List<Product> list = repository.findAll(); Este foi comentado porque no
		 *"Repository" tivemos que usar o "OrderBy" do Spring Boot para fazer 
		 *a busca dos objetos por nome*/
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		//Aqui em cima, transformamos uma lista de product em uma lista de product DTO
	}

}
