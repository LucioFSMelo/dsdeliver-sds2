package com.devsuper.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuper.dsdeliver.entities.Product;

/*O objeto "repository" é o que faz o acesso ao DB
 *Vamos usar o JpaRepository<T, Id>, ele é uma interface que já vem no
 *Springboot, ela faz parte do subFramWork Spring Data Jpa, ela já algumas 
 *implementações padrão para você "buscar, salvar, deletar e atualizar"
 *dados conforme você precisar, usaremos desta forma
 *JpaRepository<Entidade, Tipo da chave primária>*/
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//Para a nossa requisição buscar os  objetos pelo nome
	List<Product> findAllByOrderByNameAsc();
}
