package com.apidelivery.web.controllers;

import com.apidelivery.models.data.ClienteRequest;
import com.apidelivery.models.data.ClienteResponse;
import com.apidelivery.models.data.RestauranteResponse;
import com.apidelivery.models.model.Cliente;

import com.apidelivery.models.service.ClienteService;
import com.apidelivery.web.response.SystemMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/rest/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping(value="/save",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> saveUser(@Valid @RequestBody ClienteRequest clienteRequest) { //O RequestBody é o comando que lê o que chegou do http
        ClienteResponse clienteResponse = clienteService.save(clienteRequest);
        SystemMessage<ClienteResponse> userMessage = new SystemMessage<ClienteResponse>(HttpStatus.OK.value(), "Usuário cadastrado com sucesso.", clienteResponse);
        return ResponseEntity.ok().body(userMessage);
    }


    @GetMapping(value="/get/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> searchClienteById(@PathVariable("id") Long id) {
        ClienteResponse clienteResponse = clienteService.read(id);
        SystemMessage<ClienteResponse> userMessage =  new SystemMessage<ClienteResponse>(HttpStatus.OK.value(), "Cliente lido com sucesso.", clienteResponse);

        return ResponseEntity.ok().body(userMessage);
    }


    @PutMapping(value="/update/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse updatedUser = clienteService.update(id, clienteRequest);
        SystemMessage<ClienteResponse> userMessage = new SystemMessage<ClienteResponse>(HttpStatus.OK.value(), "Usuário alterado com sucesso.", updatedUser);
        return ResponseEntity.ok().body(userMessage);
    }


    @DeleteMapping(value="/delete/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        clienteService.delete(id);
        SystemMessage<Cliente> userMessage = new SystemMessage<Cliente>(HttpStatus.OK.value(), "Registro " + id + " excluído com sucesso.", null);
        return ResponseEntity.ok().body(userMessage);
    }
}
