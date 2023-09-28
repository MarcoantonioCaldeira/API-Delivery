package com.apidelivery.web.controllers;

import com.apidelivery.models.data.ClienteRequest;
import com.apidelivery.models.data.ClienteResponse;
import com.apidelivery.models.model.Cliente;

import com.apidelivery.models.service.ClienteService;
import com.apidelivery.web.response.SystemMessage;
import com.apidelivery.web.swagger.ClienteRestControllerApi;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/rest/cliente")
public class ClienteRestController implements ClienteRestControllerApi {

    @Autowired
    private ClienteService clienteService;

    @Override
    @GetMapping(value = "/listar",
        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<ClienteResponse> list(){
        return clienteService.list();
    }

    @Override
    @GetMapping(value="/pageByKey",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<ClienteResponse> listPagedByKey(
            @RequestParam(value="key", defaultValue="", required=false) String key,
            @RequestParam(value="offset", defaultValue="0", required=false) Integer actualPage,
            @RequestParam(value="limit", defaultValue="10", required=false) Integer pageSize,
            @RequestParam(value="order", defaultValue="ASC", required=false) String order,
            @RequestParam(value="props", defaultValue="id", required=false) String props) {
        return clienteService.listPagedByKey(key, actualPage, pageSize, order, props);
    }

    @Override
    @GetMapping(value="/page",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<ClienteResponse> listPaged(
            @RequestParam(value="offset", defaultValue="0", required=false) Integer actualPage,
            @RequestParam(value="limit", defaultValue="10", required=false) Integer pageSize,
            @RequestParam(value="order", defaultValue="ASC", required=false) String order,
            @RequestParam(value="props", defaultValue="id", required=false) String props) {
        return clienteService.listPaged(actualPage, pageSize, order, props);
    }

    @Override
    @GetMapping(value="/get/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> searchUserById(@PathVariable("id") Long id) {
        ClienteResponse clienteResponse = clienteService.read(id);
        SystemMessage<ClienteResponse> userMessage = new SystemMessage<ClienteResponse>(HttpStatus.OK.value(), "Usuário lido com sucesso.", clienteResponse);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @PostMapping(value="/save",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> saveUser(@Valid @RequestBody ClienteRequest clienteRequest) { //O RequestBody é o comando que lê o que chegou do http
        ClienteResponse clienteResponse = clienteService.save(clienteRequest);
        SystemMessage<ClienteResponse> userMessage = new SystemMessage<ClienteResponse>(HttpStatus.OK.value(), "Usuário cadastrado com sucesso.", clienteResponse);

        return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @PutMapping(value="/update/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse updatedUser = clienteService.update(id, clienteRequest);
        SystemMessage<ClienteResponse> userMessage = new SystemMessage<ClienteResponse>(HttpStatus.OK.value(), "Usuário alterado com sucesso.", updatedUser);

       return ResponseEntity.ok().body(userMessage);
    }

    @Override
    @DeleteMapping(value="/delete/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        clienteService.delete(id);
        SystemMessage<Cliente> userMessage = new SystemMessage<Cliente>(HttpStatus.OK.value(), "Registro " + id + " excluído com sucesso.", null);

        return ResponseEntity.ok().body(userMessage);
    }
}
