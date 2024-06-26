package com.apidelivery.models.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apidelivery.models.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    @Query("SELECT u FROM Cliente u WHERE u.nome = :nome")
    List<Cliente> findByNome(@Param("nome") String nome);

    Optional<Cliente> findByLogin(String login);

    @Query("SELECT u FROM Cliente u WHERE u.email =:email")
    Optional<Cliente> findByEmail(@Param("email") String email);

}
