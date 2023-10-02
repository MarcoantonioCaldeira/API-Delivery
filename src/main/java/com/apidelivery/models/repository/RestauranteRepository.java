package com.apidelivery.models.repository;

import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.model.Restaurante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {


    @Query("SELECT u FROM Restaurante u WHERE u.nome_restaurante = :nome")
    List<Restaurante> findByNome(@Param("nome") String nome);


    @Query("SELECT u FROM Restaurante u WHERE u.email =:email")
    Optional<Restaurante> findByEmail(@Param("email") String email);


    @Query(value = "SELECT c FROM Restaurante c", countQuery = "SELECT COUNT(c) FROM Restaurante c")
    Page<Restaurante> findAllPagination(Pageable page);


    @Query(value = "SELECT u FROM Restaurante u WHERE u.id LIKE(CONCAT('%',:key,'%')) OR u.nome LIKE(CONCAT('%',:key,'%')) OR u.email LIKE(CONCAT('%',:key,'%')) ", countQuery = "SELECT COUNT(u) FROM Restaurante u")
    public Page<Restaurante> findAllPaginationWithKey(@Param("key") String key, Pageable page);
}
