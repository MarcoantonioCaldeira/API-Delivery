package com.apidelivery.models.service.impl;

import com.apidelivery.models.data.RestauranteRequest;
import com.apidelivery.models.data.RestauranteResponse;
import com.apidelivery.models.model.Restaurante;
import com.apidelivery.models.repository.RestauranteRepository;
import com.apidelivery.models.service.RestauranteService;
import com.apidelivery.models.service.exception.EmailAlreadyExistsException;
import com.apidelivery.models.service.exception.EntityNotFoundException;
import com.apidelivery.models.service.exception.PasswordConfirmationException;
import com.apidelivery.models.service.mapper.EntityConversor;
import com.apidelivery.models.service.pagination.PageRequestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired //O spring instancia automaticamente
    private RestauranteRepository restauranteRepository; //Não tem como instanciar normalmente pois é uma interface

    @Autowired
    private EntityConversor entityConversor;

    @Override
    public RestauranteResponse save(RestauranteRequest entity) {
        Restaurante restaurante = entityConversor.parseObject(entity, Restaurante.class);

        Optional<Restaurante> restauranteSaved = restauranteRepository.findByEmail(restaurante.getEmail());
        if(restauranteSaved.isPresent() && restauranteSaved.get().equals(restaurante)) {
            throw new EmailAlreadyExistsException("O email informado já está cadastrado");
        }
        if(!entity.getSenha().equals(entity.getConfirmarSenha())) {
            throw new PasswordConfirmationException("A senha de confirmação e a senha não conferem");
        }

        restaurante = restauranteRepository.save(restaurante);
        RestauranteResponse restauranteResponse = entityConversor.parseObject(restaurante, RestauranteResponse.class);

        return restauranteResponse;
    }

    @Override
    public RestauranteResponse update(Long id, RestauranteRequest entity) {

        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        Restaurante entreConv = entityConversor.parseObject(entity, Restaurante.class);

        if(!entity.getSenha().equals(entity.getConfirmarSenha())) {
            throw new PasswordConfirmationException("A senha de confirmação e a senha não conferem");
        }

        restaurante.setConfirmarSenha(entity.getConfirmarSenha());
        restaurante.setEmail(entity.getEmail());
        restaurante.setSenha(entity.getSenha());
        restaurante.setNome_restaurante(entity.getNome_restaurante());

        restaurante = restauranteRepository.saveAndFlush(restaurante); //Força o salvamento sem ficar em memória intermediária
        RestauranteResponse restauranteResponse = entityConversor.parseObject(entreConv, RestauranteResponse.class);

        return restauranteResponse;
    }

    @Override
    public void delete(Long id) {
        restauranteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public RestauranteResponse read(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        return entityConversor.parseObject(restaurante, RestauranteResponse.class);
    }

    @Override
    public List<RestauranteResponse> list() {
        return entityConversor.parseListObjects(restauranteRepository.findAll(), RestauranteResponse.class);
    }

    @Override
    public List<RestauranteResponse> list(String key) {
        return entityConversor.parseListObjects(restauranteRepository.findByNome(key), RestauranteResponse.class);
    }

    @Override
    public Page<RestauranteResponse> listPaged(Integer actualPage, Integer pageSize, String order, String props) {
        Pageable page = PageRequestConfig.generatePage(actualPage, pageSize, order, props);

        Page<Restaurante> userList = restauranteRepository.findAllPagination(page);
        List<RestauranteResponse> restauranteListResponse = entityConversor.parseListObjects(userList.getContent(), RestauranteResponse.class);
        Page<RestauranteResponse> pageRestauranteResponse = new PageImpl<>(restauranteListResponse, userList.getPageable(), userList.getTotalElements());

        return pageRestauranteResponse;
    }

    @Override
    public Page<RestauranteResponse> listPagedByKey(String key, Integer actualPage, Integer pageSize, String order, String props) {
        Pageable page = PageRequestConfig.generatePage(actualPage, pageSize, order, props);

        Page<Restaurante> entregadorList = restauranteRepository.findAllPaginationWithKey(key, page);
        List<RestauranteResponse> restauranteListResponse = entityConversor.parseListObjects(entregadorList.getContent(), RestauranteResponse.class);
        Page<RestauranteResponse> pageEntregadorResponse = new PageImpl<>(restauranteListResponse, entregadorList.getPageable(), entregadorList.getTotalElements());

        return pageEntregadorResponse;
    }
}
