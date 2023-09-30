package com.apidelivery.models.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apidelivery.models.model.EnderecoEntregador;

import java.util.List;
import java.util.Optional;

public interface EnderecoEntregadorRepository extends JpaRepository<EnderecoEntregador, Long> {

    // Método para encontrar endereços por bairro
    @Query("SELECT e FROM EnderecoEntregador e WHERE e.bairro = :bairro")
    List<EnderecoEntregador> findByBairro(@Param("bairro") String bairro);

    // Método para encontrar endereços por rua
    @Query("SELECT e FROM EnderecoEntregador e WHERE e.rua = :rua")
    List<EnderecoEntregador> findByRua(@Param("rua") String rua);

    // Método para encontrar endereços por número da casa
    @Query("SELECT e FROM EnderecoEntregador e WHERE e.numero_casa = :numero_casa")
    List<EnderecoEntregador> findByNumero_casa(@Param("numero_casa") String numero_casa);

    // Método para buscar todos os endereços com paginação
    @Query(value = "SELECT e FROM EnderecoEntregador e", countQuery = "SELECT COUNT(e) FROM EnderecoEntregador e")
    Page<EnderecoEntregador> findAllPagination(Pageable page);

    // Método para buscar todos os endereços com uma chave de pesquisa com paginação
    @Query(value = "SELECT e FROM EnderecoEntregador e WHERE e.id LIKE(CONCAT('%',:key,'%')) OR e.bairro LIKE(CONCAT('%',:key,'%')) OR e.rua LIKE(CONCAT('%',:key,'%')) OR e.numero_casa LIKE(CONCAT('%',:key,'%'))", countQuery = "SELECT COUNT(e) FROM EnderecoEntregador e")
    Page<EnderecoEntregador> findAllPaginationWithKey(@Param("key") String key, Pageable page);
}
