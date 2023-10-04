package com.apidelivery.web.swagger;


import com.apidelivery.models.data.RestauranteRequest;
import com.apidelivery.models.data.RestauranteResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RestauranteRestControllerAPI {
    @GetMapping(value = "/listar",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    List<RestauranteResponse> list();

    @GetMapping(value="/pageByKey",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    Page<RestauranteResponse> listPagedByKey(
            @RequestParam(value = "key", defaultValue = "", required = false) String key,
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props);

    @GetMapping(value="/page",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    Page<RestauranteResponse> listPaged(
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props);

    @GetMapping(value="/get/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> searchRestaurantById(@PathVariable("id") Long id);

    @PostMapping(value="/save",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> saveRestaurant(@Valid @RequestBody RestauranteRequest restauranteRequest);

    @PutMapping(value="/update/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestauranteRequest restauranteRequest);

    @DeleteMapping(value="/delete/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> deleteRestaurant(@PathVariable("id") Long id);
}
