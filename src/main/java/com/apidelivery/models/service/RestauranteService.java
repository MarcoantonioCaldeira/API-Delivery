package com.apidelivery.models.service;

import com.apidelivery.models.data.RestauranteRequest;
import com.apidelivery.models.data.RestauranteResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RestauranteService extends GenericService<RestauranteResponse, RestauranteRequest, Long>{

    List<RestauranteResponse> list();

    Page<RestauranteResponse> listPaged(Integer actualPage, Integer pageSize, String order, String props);

    Page<RestauranteResponse> listPagedByKey(String key, Integer actualPage, Integer pageSize, String order, String props);
}
