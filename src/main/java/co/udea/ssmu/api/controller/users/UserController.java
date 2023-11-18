package co.udea.ssmu.api.controller.users;

import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.dto.users.UserDTO;
import co.udea.ssmu.api.services.users.facade.UserFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.utils.exception.DataBaseException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Users", description = "Gestión de usuarios")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserFacade userFacade;
    private final Messages messages;

    public UserController(UserFacade userFacade, Messages messages) {
        this.userFacade = userFacade;
        this.messages = messages;
    }

    @PostMapping("/save")
    @Operation(summary = "Permite guardar un usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = UserDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El usuario fue guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UserDTO>> save(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("user.save.successful"),
                userFacade.save(user)));
    }

    @GetMapping("/get-all")
    @Operation(summary = "Permite consultar todos los usuarios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = List.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "Los usuarios fueron consultados exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "404", description = "No se encuentra el recurso") })
    public ResponseEntity<StandardResponse<List<UserDTO>>> findAll() {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("user.get.all.successful"),
                userFacade.findByAll()));
    }

    @GetMapping("/get/{cedula}")
    @Operation(summary = "Permite consultar un usuario especifico por cedula")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "El usuario fue eliminada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UserDTO>> findByCedula(@PathVariable String cedula) {
        try {
            return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("user.find.nrodoc.successful"),
                    userFacade.findByCedula(cedula)));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("user.find.nrodoc.error"));
        }
    }

    @GetMapping("/get-all/filter")
    @Operation(summary = "Consultar los usuarios paginado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Los usuarios fueron consultados exitosamente",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Page.class)))),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")
    })
    public ResponseEntity<StandardResponse<Page<UserDTO>>> getWithPage(
            @Parameter(description = "Página para la cual se desean recibir los resultados (0..N)")
            @RequestParam(defaultValue = "0") Integer page,
            @Parameter(description = "Número de registros por página.")
            @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "Criterio de ordenamiento en el formato: campo(,asc|desc). "
                    + "por defecto el ordenamiento es asc. "
                    + "Se permite múltiple criterio de ordenamiento.")
            @RequestParam(defaultValue = "id,asc") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc(sort.split(",")[0])));

        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("user.get.all.filter.successful"),
                userFacade.getWithPage(pageable)));
    }

    @PutMapping("/update")
    @Operation(summary = "Permite actualizar un usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = UserDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "El usuario se acuatlizo exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UserDTO>> update(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("user.update.successful"),
                userFacade.update(user)));
    }

    @DeleteMapping("/delete/{cedula}")
    @Operation(summary = "Permite eliminar un usuario por cedula")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "El usuario fue eliminada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<Void>> delete(@PathVariable String cedula) {
        try {
            userFacade.delete(cedula);
            return ResponseEntity.ok(new StandardResponse<>(messages.get("user.delete.successful"), StandardResponse.StatusStandardResponse.OK));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(messages.get("user.delete.error"));
        }
    }

}
