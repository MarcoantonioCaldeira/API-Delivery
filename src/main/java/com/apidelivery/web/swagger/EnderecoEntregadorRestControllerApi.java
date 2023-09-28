package com.apidelivery.web.swagger;

import com.apidelivery.models.data.EnderecoEntregadorRequest;
import com.apidelivery.models.data.EnderecoEntregadorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface EnderecoEntregadorRestControllerApi {

    @Operation(
            summary = "Busca do Endereco de Entregador por ID",
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
    ResponseEntity<?> searchAdressDeliverymanById(@PathVariable("id") Long id);


    @Operation(
            summary = "Salvar endereço de Entregadores",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Permite salvar os dados dos endereços dos entregadores",
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
    ResponseEntity<?> saveDeliveryman(@Valid @RequestBody EnderecoEntregadorRequest enderecoentregadorRequest);

    @Operation(
            summary = "Atualização de enderço dos entregadores",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Permite atualizar o endereço dos entregadores por ID",
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
    ResponseEntity<?> updateAdressDeliveryman(@PathVariable("id") Long id, @RequestBody EnderecoEntregadorRequest enderecoentregadorRequest);

    @Operation(
            summary = "Deletar Endereço do Entregador",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de endereços de entregadores",
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
    ResponseEntity<?> deleteAdressDeliveryman(@PathVariable("id") Long id);
}
