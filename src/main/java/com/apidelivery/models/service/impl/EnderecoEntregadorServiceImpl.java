package com.apidelivery.models.service.impl;

import com.apidelivery.models.data.EnderecoEntregadorRequest;
import com.apidelivery.models.data.EnderecoEntregadorResponse;
import com.apidelivery.models.service.mapper.EntityConversor;
import com.apidelivery.models.model.EnderecoEntregador;
import com.apidelivery.models.repository.EnderecoEntregadorRepository;
import com.apidelivery.models.service.EnderecoEntregadorService;
import com.apidelivery.models.service.exception.EntityNotFoundException;
import com.apidelivery.models.service.pagination.PageRequestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnderecoEntregadorServiceImpl{

//    @Autowired //O spring instancia automaticamente
//    private EnderecoEntregadorRepository enderecoEntregadorRepository;
//
//    @Autowired
//    private EntityConversor entityConversor;
//
//
//    @Override
//    public EnderecoEntregadorResponse save(EnderecoEntregadorRequest entity) {
//        EnderecoEntregador enderecoEntregador = entityConversor.parseObject(entity, EnderecoEntregador.class);
//
//        enderecoEntregador = enderecoEntregadorRepository.save(enderecoEntregador);
//        EnderecoEntregadorResponse enderecoEntregadorResponse = entityConversor.parseObject(enderecoEntregador, EnderecoEntregadorResponse.class);
//
//        return enderecoEntregadorResponse;
//    }
//
//    @Override
//    public EnderecoEntregadorResponse update(Long id, EnderecoEntregadorRequest entity) {
//        EnderecoEntregador enderecoEntregador = enderecoEntregadorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
//        EnderecoEntregador userConv = entityConversor.parseObject(entity, EnderecoEntregador.class);
//
//
//        enderecoEntregador = enderecoEntregadorRepository.saveAndFlush(enderecoEntregador); //Força o salvamento sem ficar em memória intermediária
//        EnderecoEntregadorResponse enderecoEntregadorResponse = entityConversor.parseObject(userConv, EnderecoEntregadorResponse.class);
//
//        return enderecoEntregadorResponse;
//    }
//
//    @Override
//    public void delete(Long id) {
//        enderecoEntregadorRepository.deleteById(id);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public EnderecoEntregadorResponse read(Long id) {
//        EnderecoEntregador enderecoEntregador = enderecoEntregadorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
//
//        return entityConversor.parseObject(enderecoEntregador, EnderecoEntregadorResponse.class);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<EnderecoEntregadorResponse> list() {
//        return entityConversor.parseListObjects(enderecoEntregadorRepository.findAll(), EnderecoEntregadorResponse.class);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<EnderecoEntregadorResponse> list(String num_casa) {
//        return entityConversor.parseListObjects(enderecoEntregadorRepository.findByNumero_casa(num_casa), EnderecoEntregadorResponse.class);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Page<EnderecoEntregadorResponse> listPaged(Integer actualPage, Integer pageSize, String order, String props) {
//        Pageable page = PageRequestConfig.generatePage(actualPage, pageSize, order, props);
//
//        Page<EnderecoEntregador> enderecoEntregadorList = enderecoEntregadorRepository.findAllPagination(page);
//        List<EnderecoEntregadorResponse> enderecoEntregadorListResponse = entityConversor.parseListObjects(enderecoEntregadorList.getContent(), EnderecoEntregadorResponse.class);
//        Page<EnderecoEntregadorResponse> pageUserResponse = new PageImpl<>(enderecoEntregadorListResponse, enderecoEntregadorList.getPageable(), enderecoEntregadorList.getTotalElements());
//
//        return pageUserResponse;
//    }
//
//   // @Override
//    public Page<EnderecoEntregadorResponse> listPagedByKey(String key, Integer actualPage, Integer pageSize, String order, String props) {
//        Pageable page = PageRequestConfig.generatePage(actualPage, pageSize, order, props);
//
//        Page<EnderecoEntregador> enderecoEntregadorList = enderecoEntregadorRepository.findAllPaginationWithKey(key, page);
//        List<EnderecoEntregadorResponse> enderecoEntregadorListResponse = entityConversor.parseListObjects(enderecoEntregadorList .getContent(), EnderecoEntregadorResponse.class);
//        Page<EnderecoEntregadorResponse> pageEnderecoEntregadorResponse = new PageImpl<>(enderecoEntregadorListResponse, enderecoEntregadorList .getPageable(), enderecoEntregadorList .getTotalElements());
//
//        return pageEnderecoEntregadorResponse;
//    }
}
