package com.apidelivery.web.controllers;

import org.springframework.http.HttpStatus;
import com.apidelivery.models.data.EnderecoEntregadorResponse;
import com.apidelivery.models.data.EnderecoEntregadorRequest;
import com.apidelivery.models.service.EnderecoEntregadorService;
import com.apidelivery.web.swagger.EnderecoEntregadorRestControllerApi;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.apidelivery.web.response.SystemMessage;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RestController
//@RequestMapping(value = "/rest/entregador/endereco")
public class EnderecoEntregadorRestController {
//
//    @Autowired
//    private EnderecoEntregadorService enderecoEntregadorService;
//
//    @GetMapping(value = "/list",
//            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public List<EnderecoEntregadorResponse> list(){
//        return enderecoEntregadorService.list();
//    }
//
//    @GetMapping(value="/pageByKey",
//            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public Page<EnderecoEntregadorResponse> listPagedByKey(
//            @RequestParam(value="key", defaultValue="", required=false) String key,
//            @RequestParam(value="offset", defaultValue="0", required=false) Integer actualPage,
//            @RequestParam(value="limit", defaultValue="10", required=false) Integer pageSize,
//            @RequestParam(value="order", defaultValue="ASC", required=false) String order,
//            @RequestParam(value="props", defaultValue="id", required=false) String props) {
//        return enderecoEntregadorService.listPagedByKey(key, actualPage, pageSize, order, props);
//    }
//
//    @GetMapping(value="/page",
//            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public Page<EnderecoEntregadorResponse> listPaged(
//            @RequestParam(value="offset", defaultValue="0", required=false) Integer actualPage,
//            @RequestParam(value="limit", defaultValue="10", required=false) Integer pageSize,
//            @RequestParam(value="order", defaultValue="ASC", required=false) String order,
//            @RequestParam(value="props", defaultValue="id", required=false) String props) {
//        return enderecoEntregadorService.listPaged(actualPage, pageSize, order, props);
//    }
//
//    @Override
//    @GetMapping(value="/get/{id}",
//            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public ResponseEntity<?> searchAdressDeliverymanById(@PathVariable("id") Long id) {
//        EnderecoEntregadorResponse enderecoentregadorResponse = enderecoEntregadorService.read(id);
//        SystemMessage<EnderecoEntregadorResponse> userMessage = new SystemMessage<EnderecoEntregadorResponse>(HttpStatus.OK.value(), "Usuário lido com sucesso.", enderecoentregadorResponse);
//
//        return ResponseEntity.ok().body(userMessage);
//    }
//
//
//    @Override
//    @PostMapping(value="/save",
//            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
//            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public ResponseEntity<?> saveDeliveryman(@Valid @RequestBody EnderecoEntregadorRequest enderecoentregadorRequest) { //O RequestBody é o comando que lê o que chegou do http
//        EnderecoEntregadorResponse enderecoentregadorResponse = enderecoEntregadorService.save(enderecoentregadorRequest);
//        SystemMessage<EnderecoEntregadorResponse> userMessage = new SystemMessage<>(HttpStatus.OK.value(), "Usuário cadastrado com sucesso.", enderecoentregadorResponse);
//
//        return ResponseEntity.ok().body(userMessage);
//    }
//
//    @Override
//    @PutMapping(value="/update/{id}",
//            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
//            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public ResponseEntity<?> updateAdressDeliveryman(@PathVariable("id") Long id, @RequestBody EnderecoEntregadorRequest enderecoentregadorRequest) {
//        EnderecoEntregadorResponse updatedAdressDeliveryman = enderecoEntregadorService.update(id, enderecoentregadorRequest);
//        SystemMessage<EnderecoEntregadorResponse> AdressDeliverymanMessage = new SystemMessage<>(HttpStatus.OK.value(), "Usuário alterado com sucesso.", updatedAdressDeliveryman);
//
//        return ResponseEntity.ok().body(AdressDeliverymanMessage);
//    }
//
//    @Override
//    @DeleteMapping(value="/delete/{id}",
//            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
//            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public ResponseEntity<?> deleteAdressDeliveryman(@PathVariable("id") Long id) {
//        enderecoEntregadorService.delete(id);
//        SystemMessage<EnderecoEntregadorResponse> AdressDeliverymanMessage = new SystemMessage<>(HttpStatus.OK.value(), "Registro " + id + " excluído com sucesso.", null);
//
//        return ResponseEntity.ok().body(AdressDeliverymanMessage);
//    }

}
