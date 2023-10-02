package com.apidelivery.web.controllers;

import com.apidelivery.models.data.RestauranteRequest;
import com.apidelivery.models.data.RestauranteResponse;
import com.apidelivery.models.model.Restaurante;
import com.apidelivery.models.service.RestauranteService;
import com.apidelivery.web.response.SystemMessage;
import com.apidelivery.web.swagger.RestauranteRestControllerAPI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestauranteRestController implements RestauranteRestControllerAPI {

    @Autowired
    private RestauranteService restauranteService;

    @Override
    @GetMapping(value = "/listar",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<RestauranteResponse> list(){
        return restauranteService.list();
    }

    @Override
    @GetMapping(value="/pageByKey",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<RestauranteResponse> listPagedByKey(
            @RequestParam(value = "key", defaultValue = "", required = false) String key,
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props) {
        return restauranteService.listPagedByKey(key, actualPage, pageSize, order, props);
    }

    @Override
    @GetMapping(value="/page",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<RestauranteResponse> listPaged(
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props) {
        return restauranteService.listPaged(actualPage, pageSize, order, props);
    }

    @Override
    @GetMapping(value="/get/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> searchRestaurantById(@PathVariable("id") Long id) {
        RestauranteResponse restauranteResponse = restauranteService.read(id);
        SystemMessage<RestauranteResponse> userMessage = new SystemMessage<>(HttpStatus.OK.value(), "Restaurante lido com sucesso.", restauranteResponse);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @PostMapping(value="/save",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> saveRestaurant(@Valid @RequestBody RestauranteRequest restauranteRequest) { //O RequestBody é o comando que lê o que chegou do http
        RestauranteResponse restauranteResponse = restauranteService.save(restauranteRequest);
        SystemMessage<RestauranteResponse> userMessage = new SystemMessage<>(HttpStatus.OK.value(), "Restaurante cadastrado com sucesso.", restauranteResponse);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @PutMapping(value="/update/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestauranteRequest restauranteRequest) {
        RestauranteResponse updatedRestaurant = restauranteService.update(id, restauranteRequest);
        SystemMessage<RestauranteResponse> userMessage = new SystemMessage<RestauranteResponse>(HttpStatus.OK.value(), "Restaurante alterado com sucesso.", updatedRestaurant);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @DeleteMapping(value="/delete/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> deleteRestaurant(@PathVariable("id") Long id) {
        restauranteService.delete(id);
        SystemMessage<Restaurante> userMessage = new SystemMessage<Restaurante>(HttpStatus.OK.value(), "Registro " + id + " excluído com sucesso.", null);

        return ResponseEntity.ok().body(userMessage);
    }

}
