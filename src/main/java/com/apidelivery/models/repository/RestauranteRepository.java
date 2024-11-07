package com.apidelivery.models.repository;
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


//    @Query("SELECT DISTINCT r FROM Restaurante r LEFT JOIN FETCH r.itemMenuRestaurante")
//    List<Restaurante> findAllWithItems();

    @Query(value = "SELECT c FROM Restaurante c", countQuery = "SELECT COUNT(c) FROM Restaurante c")
    Page<Restaurante> findAllPagination(Pageable page);

    @Query(value = "SELECT u FROM Restaurante u WHERE " +
            "CASE " +
            "  WHEN u.id LIKE(CONCAT('%',:key,'%')) THEN TRUE " +
            "  WHEN u.nome_restaurante LIKE(CONCAT('%',:key,'%')) THEN TRUE " +
            "  WHEN u.email LIKE(CONCAT('%',:key,'%')) THEN TRUE " +
            "  ELSE FALSE " +
            "END = TRUE",
            countQuery = "SELECT COUNT(u) FROM Restaurante u")
    public Page<Restaurante> findAllPaginationWithKey(@Param("key") String key, Pageable page);

}
