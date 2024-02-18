package com.apidelivery.web.swagger;
import com.apidelivery.models.data.ClienteRequest;
import com.apidelivery.models.data.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name="Cliente", description="Endpoints para o gerenciamento dos dados da entidade Cliente")
public interface ClienteRestControllerApi {



    @Operation(
            summary = "Salvar um usuário",
            description="userName, password e email devem estar preenchidos. O email deve ser válido.",
            responses = {
                    @ApiResponse(
                            responseCode="200",
                            content = {
                                    @Content(
                                            mediaType="application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            })
    public ResponseEntity<?> saveUser(
            @RequestBody(description = "Representação de um usuário",
                    required = true)
            ClienteRequest userRequest);

    @GetMapping(value="/get/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<?> searchClienteById(@PathVariable("id") Long id);

    @Operation(
            summary = "Atualiza um usuário por meio do ID",
            description="userName, password e email devem estar preenchidos. O email deve ser válido.",
            responses = {
                    @ApiResponse(
                            responseCode="200",
                            content = {
                                    @Content(
                                            mediaType="application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            })
    public ResponseEntity<?> updateUser(
            @Parameter(description = "ID de um usuário",
                    example = "1",
                    required = true)
            Long id,
            @RequestBody(description = "Representação de um usuário",
                    required = true)
            ClienteRequest userRequest);

    @Operation(
            summary = "Deleta um usuário por meio do ID",
            responses = {
                    @ApiResponse(
                            responseCode="200",
                            content = {
                                    @Content(
                                            mediaType="application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            })
    public ResponseEntity<?> deleteUser(
            @Parameter(description = "ID de um usuário",
                    example = "1",
                    required = true)
            Long id);

}
