package com.apidelivery.web.swagger;

import com.apidelivery.models.data.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EntregadorControllerApi {

    @Operation(
            summary = "Listar todos os Entregadores",
            responses = {
                    @ApiResponse(
                            responseCode="200",
                            content = {@Content(mediaType="application/json", array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class)))}
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            })
    @GetMapping(value = "/listar",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    List<EntregadorResponse> list();


    @Operation(
            summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de entrgadores",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EnderecoEntregadorResponse.class))
                            )
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            }
    )
    @GetMapping(value="/pageByKey",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    Page<EntregadorResponse> listPagedByKey(
            @RequestParam(value = "key", defaultValue = "", required = false) String key,
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props);


    @Operation(
            summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de endereços de clientes",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EnderecoEntregadorResponse.class))
                            )
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            }
    )
    @GetMapping(value="/page",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    Page<EntregadorResponse> listPaged(
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer actualPage,
            @RequestParam(value = "limit", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) String order,
            @RequestParam(value = "props", defaultValue = "id", required = false) String props);


    @Operation(
            summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de endereços de clientes",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EnderecoEntregadorResponse.class))
                            )
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            }
    )
    @GetMapping(value="/get/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> searchDeliveryById(@PathVariable("id") Long id);


    @Operation(
            summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de endereços de clientes",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EnderecoEntregadorResponse.class))
                            )
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            }
    )
    @PostMapping(value="/save",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> saveDelivery(@Valid @RequestBody EntregadorRequest entregadorRequest);



    @Operation(
            summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de endereços de clientes",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EnderecoEntregadorResponse.class))
                            )
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            }
    )
    @PutMapping(value="/update/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> updateDelivery(@PathVariable("id") Long id, @RequestBody EntregadorRequest entregadorRequest);


    @Operation(
            summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de endereços de clientes",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EnderecoEntregadorResponse.class))
                            )
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            }
    )
    @DeleteMapping(value="/delete/{id}",
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> deleteDelivery(@PathVariable("id") Long id);
}
