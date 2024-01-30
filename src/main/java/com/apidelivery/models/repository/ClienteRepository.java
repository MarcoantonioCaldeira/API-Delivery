package com.apidelivery.models.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apidelivery.models.model.Cliente;

//Os metodos a baixo encapsulam operações CRUD relacionadas a entidade Cliente
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	// Método para encontrar clientes por nome
    @Query("SELECT u FROM Cliente u WHERE u.nome = :nome")
    List<Cliente> findByNome(@Param("nome") String nome);

    // Método para encontrar clientes por email
    @Query("SELECT u FROM Cliente u WHERE u.email =:email")
    Optional<Cliente> findByEmail(@Param("email") String email);

    // Método para buscar todos os clientes com paginação
//    @Query(value = "SELECT c FROM Cliente c", countQuery = "SELECT COUNT(c) FROM Cliente c")
//    Page<Cliente> findAllPagination(Pageable page);
//
//    // Método para buscar todos os clientes com uma chave de pesquisa com paginação
//    @Query(value = "SELECT u FROM Cliente u WHERE u.id LIKE(CONCAT('%',:key,'%')) OR u.nome LIKE(CONCAT('%',:key,'%')) OR u.email LIKE(CONCAT('%',:key,'%')) ", countQuery = "SELECT COUNT(u) FROM Cliente u")
//    public Page<Cliente> findAllPaginationWithKey(@Param("key") String key, Pageable page);
}
