package com.apidelivery.models.service.impl;

import java.util.List;
import java.util.Optional;

import com.apidelivery.models.model.Cliente;
import com.apidelivery.models.model.Entregador;
import com.apidelivery.models.service.exception.EntityNotFoundException;
import com.apidelivery.models.service.mapper.EntityConversor;
import com.apidelivery.models.repository.EntregadorRepository;
import com.apidelivery.models.data.EntregadorRequest;
import com.apidelivery.models.data.EntregadorResponse;
import com.apidelivery.models.service.EntregadorService;
import com.apidelivery.models.service.exception.EmailAlreadyExistsException;
import com.apidelivery.models.service.exception.PasswordConfirmationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.apidelivery.models.service.pagination.PageRequestConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class EntregadorServiceImpl implements EntregadorService {

    @Autowired //O spring instancia automaticamente
    private EntregadorRepository entregadorRepository; //Não tem como instanciar normalmente pois é uma interface

    @Autowired
    private EntityConversor entityConversor;

    @Override
    public EntregadorResponse save(EntregadorRequest entity) {
        Entregador entregador = entityConversor.parseObject(entity, Entregador.class);

        Optional<Entregador> entregadorSaved = entregadorRepository.findByEmail(entregador.getEmail());
        if(entregadorSaved.isPresent() && entregadorSaved.get().equals(entregador)) {
            throw new EmailAlreadyExistsException("O email informado já está cadastrado");
        }
        if(!entity.getSenha().equals(entity.getConfirmarSenha())) {
            throw new PasswordConfirmationException("A senha de confirmação e a senha não conferem");
        }

        entregador = entregadorRepository.save(entregador);
        EntregadorResponse entregadorResponse = entityConversor.parseObject(entregador, EntregadorResponse.class);

        return entregadorResponse;
    }

    @Override
    public EntregadorResponse update(Long id, EntregadorRequest entity) {

        Entregador entregador = entregadorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        Entregador entreConv = entityConversor.parseObject(entity, Entregador.class);

        if(!entity.getSenha().equals(entity.getConfirmarSenha())) {
            throw new PasswordConfirmationException("A senha de confirmação e a senha não conferem");
        }

        entregador.setConfirmarSenha(entity.getConfirmarSenha());
        entregador.setEmail(entity.getEmail());
        entregador.setSenha(entity.getSenha());
        entregador.setNome(entity.getNome());

        entregador = entregadorRepository.saveAndFlush(entregador); //Força o salvamento sem ficar em memória intermediária
        EntregadorResponse entregadorResponse = entityConversor.parseObject(entreConv, EntregadorResponse.class);

        return entregadorResponse;
    }

    @Override
    public void delete(Long id) {
        entregadorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public EntregadorResponse read(Long id) {
        Entregador entregador = entregadorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        return entityConversor.parseObject(entregador, EntregadorResponse.class);
    }

    @Override
    public List<EntregadorResponse> list() {
        return entityConversor.parseListObjects(entregadorRepository.findAll(), EntregadorResponse.class);
    }

    @Override
    public List<EntregadorResponse> list(String key) {
        return entityConversor.parseListObjects(entregadorRepository.findByNome(key), EntregadorResponse.class);
    }

    @Override
    public Page<EntregadorResponse> listPaged(Integer actualPage, Integer pageSize, String order, String props) {

        Pageable page = PageRequestConfig.generatePage(actualPage, pageSize, order, props);

        Page<Entregador> userList = entregadorRepository.findAllPagination(page);
        List<EntregadorResponse> entregadorListResponse = entityConversor.parseListObjects(userList.getContent(), EntregadorResponse.class);
        Page<EntregadorResponse> pageEntregadorResponse = new PageImpl<>(entregadorListResponse, userList.getPageable(), userList.getTotalElements());

        return pageEntregadorResponse;
    }

    @Override
    public Page<EntregadorResponse> listPagedByKey(String key, Integer actualPage, Integer pageSize, String order, String props) {
        Pageable page = PageRequestConfig.generatePage(actualPage, pageSize, order, props);

        Page<Entregador> entregadorList = entregadorRepository.findAllPaginationWithKey(key, page);
        List<EntregadorResponse> entregadorListResponse = entityConversor.parseListObjects(entregadorList.getContent(), EntregadorResponse.class);
        Page<EntregadorResponse> pageEntregadorResponse = new PageImpl<>(entregadorListResponse, entregadorList.getPageable(), entregadorList.getTotalElements());

        return pageEntregadorResponse;
    }
}
