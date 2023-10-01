package com.apidelivery.web.controllers;

import com.apidelivery.models.data.EntregadorResponse;
import com.apidelivery.models.model.Entregador;
import com.apidelivery.models.service.EntregadorService;
import com.apidelivery.models.data.EntregadorRequest;
import com.apidelivery.web.swagger.EntregadorControllerApi;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.apidelivery.web.response.SystemMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/entregador")
public class EntregadorController implements EntregadorControllerApi {

    @Autowired
    private EntregadorService entregadorService;

    @Override
    @GetMapping(value = "/listar",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<EntregadorResponse> list(){
        return entregadorService.list();
    }

    @Override
    @GetMapping(value="/pageByKey",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<EntregadorResponse> listPagedByKey(
            @RequestParam(value = "key", defaultValue = "", required = false) String key,
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props) {
        return entregadorService.listPagedByKey(key, actualPage, pageSize, order, props);
    }

    @Override
    @GetMapping(value="/page",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<EntregadorResponse> listPaged(
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props) {
        return entregadorService.listPaged(actualPage, pageSize, order, props);
    }

    @Override
    @GetMapping(value="/get/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> searchDeliveryById(@PathVariable("id") Long id) {
        EntregadorResponse entregadorResponse = entregadorService.read(id);
        SystemMessage<EntregadorResponse> userMessage = new SystemMessage<EntregadorResponse>(HttpStatus.OK.value(), "Usuário lido com sucesso.", entregadorResponse);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @PostMapping(value="/save",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> saveDelivery(@Valid @RequestBody EntregadorRequest entregadorRequest) { //O RequestBody é o comando que lê o que chegou do http
        EntregadorResponse entregadorResponse = entregadorService.save(entregadorRequest);
        SystemMessage<EntregadorResponse> userMessage = new SystemMessage<>(HttpStatus.OK.value(), "Entregador cadastrado com sucesso.", entregadorResponse);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @PutMapping(value="/update/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> updateDelivery(@PathVariable("id") Long id, @RequestBody EntregadorRequest entregadorRequest) {
        EntregadorResponse updateDeliveryAdress = entregadorService.update(id, entregadorRequest);
        SystemMessage<EntregadorResponse> userMessage = new SystemMessage<>(HttpStatus.OK.value(), "Usuário alterado com sucesso.", updateDeliveryAdress);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @DeleteMapping(value="/delete/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> deleteDelivery(@PathVariable("id") Long id) {
        entregadorService.delete(id);
        SystemMessage<Entregador> userMessage = new SystemMessage<>(HttpStatus.OK.value(), "Registro " + id + " excluído com sucesso.", null);

        return ResponseEntity.ok().body(userMessage);
    }

}
