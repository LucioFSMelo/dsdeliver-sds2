package com.devsuper.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuper.dsdeliver.entities.Order;

/*O objeto "repository" é o que faz o acesso ao DB (Camada de acesso aos dados)
 *Vamos usar o JpaRepository<T, Id>, ele é uma interface que já vem no
 *Springboot, ela faz parte do subFramWork Spring Data Jpa, ela já algumas 
 *implementações padrão para você "buscar, salvar, deletar e atualizar"
 *dados conforme você precisar, usaremos desta forma
 *JpaRepository<Entidade, Tipo da chave primária>*/
public interface OrderRepository extends JpaRepository<Order, Long> {

}
