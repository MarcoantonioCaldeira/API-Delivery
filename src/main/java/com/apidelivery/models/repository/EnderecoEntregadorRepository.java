package com.apidelivery.models.repository;

import com.apidelivery.models.model.EnderecoEntregador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnderecoEntregadorRepository  extends JpaRepository<EnderecoEntregador, Long> {

    //List<EnderecoEntregador> findByEntregador_Nome(@Param("nome") String nome); //Teste para pegar o endereço referente ao nome do Entregador


    // Método para encontrar endereços por bairro
    List<EnderecoEntregador> findByBairro(@Param("bairro") String bairro);


    // Método para encontrar endereços por rua
    List<EnderecoEntregador> findByRua(@Param("rua") String rua);


    // Método para encontrar endereços por número da casa
    List<EnderecoEntregador> findByNumCasa(@Param("numero_casa") String num_casa);


    // Método para buscar todos os endereços com paginação
    @Query(value = "SELECT e FROM EnderecoEntregador e",
            countQuery = "SELECT COUNT(e) FROM EnderecoEntregador e")
    Page<EnderecoEntregador> findAllPagination(Pageable page);


    // Método para buscar todos os endereços com uma chave de pesquisa com paginação
    @Query(value = "SELECT e FROM EnderecoEntregador e WHERE e.id LIKE CONCAT('%', :key, '%') OR e.bairro LIKE CONCAT('%', :key, '%') OR e.rua LIKE CONCAT('%', :key, '%') OR e.numero_casa LIKE CONCAT('%', :key, '%')",
            countQuery = "SELECT COUNT(e) FROM EnderecoEntregador e WHERE e.id LIKE CONCAT('%', :key, '%') OR e.bairro LIKE CONCAT('%', :key, '%') OR e.rua LIKE CONCAT('%', :key, '%') OR e.numero_casa LIKE CONCAT('%', :key, '%')")
    Page<EnderecoEntregador> findAllPaginationWithKey(@Param("key") String key, Pageable page);
}
