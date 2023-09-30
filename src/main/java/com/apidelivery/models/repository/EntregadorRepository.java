package com.apidelivery.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apidelivery.models.model.Entregador;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    @Query("SELECT e FROM Entregador e WHERE e.nome = :nome")
    List<Entregador> findByNome(@Param("nome") String nome);
    
    // Método para encontrar entregadores pelo CNH
    @Query("SELECT e FROM Entregador e WHERE e.cnh = :cnh")
    List<Entregador> findByCnh(@Param("cnh") String cnh);

    @Query("SELECT e FROM Entregador e WHERE e.email = :email")
    Optional<Entregador> findByEmail(@Param("email") String email);
    
    // Método para buscar todos os entregadoroes com paginação
    @Query(value = "SELECT e FROM Entregador e", countQuery = "SELECT COUNT(e) FROM Entregador e")
    Page<Entregador> findAllPagination(Pageable page);

    // Método para buscar todos os entregadores com uma chave de pesquisa com paginação
    @Query(value = "SELECT e FROM Entregador e WHERE e.id LIKE CONCAT('%', :key, '%') OR e.nome LIKE CONCAT('%', :key, '%')", countQuery = "SELECT COUNT(e) FROM Entregador e WHERE e.id LIKE CONCAT('%', :key, '%') OR e.nome LIKE CONCAT('%', :key, '%')")
    Page<Entregador> findAllPaginationWithKey(@Param("key") String key, Pageable page);
}
