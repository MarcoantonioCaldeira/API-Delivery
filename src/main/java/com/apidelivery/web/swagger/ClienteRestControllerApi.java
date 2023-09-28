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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name="Cliente", description="Endpoints para o gerenciamento dos dados da entidade Cliente")
public interface ClienteRestControllerApi {

    @Operation(
            summary = "Listar todos os clientes",
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
    public List<ClienteResponse> list();

    @Operation(
            summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação",
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
    public Page<ClienteResponse> listPaged(
            @Parameter(description = "Posição do registro inicial",
                    example = "0",
                    required = true)
            Integer actualPage,
            @Parameter(description = "Quantidade máxima de registros retornados",
                    example = "10",
                    required = true)
            Integer pageSize,
            @Parameter(description = "Ordem da ordenação",
                    example = "ASC",
                    required = true)
            String order,
            @Parameter(description = "Parâmetro que será utilizado para fazer a ordenação",
                    example = "id",
                    required = true)
            String props);

    @Operation(summary = "Lista paginada que permite definir o início e o fim dos registros que serão retornados, além da ordem e o parâmetro de ordenação")
    public Page<ClienteResponse> listPagedByKey(
            @Parameter(description = "Chave que será usada para fazer a pesquisa, procura no ID, email, userName e outros.",
                    example = "João, 0, maria@gmail.com",
                    required = true)
            String key,
            @Parameter(description = "Posição do registro inicial",
                    example = "0",
                    required = true)
            Integer actualPage,
            @Parameter(description = "Quantidade máxima de registros retornados",
                    example = "10",
                    required = true)
            Integer pageSize,
            @Parameter(description = "Ordem da ordenação",
                    example = "ASC",
                    required = true)
            String order,
            @Parameter(description = "Parâmetro que será utilizado para fazer a ordenação",
                    example = "id",
                    required = true)
            String props);

    @Operation(
            summary = "Encontrar Cliente por ID",
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
                    @ApiResponse(description="No Content", responseCode="204", content=@Content),
                    @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                    @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                    @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                    @ApiResponse(description="Internal Server Error", responseCode="500", content=@Content)
            })
    public ResponseEntity<?> searchUserById(
            @Parameter(description = "ID de um usuário",
                    example = "1",
                    required = true)
            Long id); //A ? indica que é um genérico

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
