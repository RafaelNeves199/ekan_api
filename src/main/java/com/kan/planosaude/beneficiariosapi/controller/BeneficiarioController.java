package com.kan.planosaude.beneficiariosapi.controller;

import com.kan.planosaude.beneficiariosapi.dto.*;
import com.kan.planosaude.beneficiariosapi.exception.DocumentoValidationException;
import com.kan.planosaude.beneficiariosapi.service.BeneficiarioService;
import com.kan.planosaude.beneficiariosapi.service.DocumentoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Beneficiario endpoint")
@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    private Logger logger = LoggerFactory.getLogger(BeneficiarioController.class);

    @Autowired
    private BeneficiarioService service;

    @Autowired
    private DocumentoService documentoService;

    @Operation(description = "Cadastrar um beneficiário junto com seus documentos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna um Beneficiário"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar Beneficiário")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeneficiarioResponseDTO salvar(@RequestBody @Valid BeneficiarioInclusaoRequestDTO requestDTO) {
        return service.salvar(requestDTO);
    }

    @Operation(description = "Listar todos os beneficiários cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Retorna todos os Beneficiários")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<BeneficiarioResponseDTO> obterBeneficiarios() {
        return service.obterBeneficiarios();
    }

    @Operation(description = "Listar todos os documentos de um beneficiário a partir de seu id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Retorna todos os documentos de um Beneficiários")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{idBeneficiario}/documentos")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentoResponseDTO> obterDocumentosPorIdBeneficiario(@PathVariable Long idBeneficiario){
        return documentoService.obterPorIdBeneficiario(idBeneficiario);
    }

    @Operation(description = "Atualizar os dados cadastrais de um beneficiário", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Beneficiário atualizado")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody BeneficiarioRequestDTO requestDTO) {
        service.atualizar(id, requestDTO);
    }

    @Operation(description = "Remover um Beneficiário", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Beneficiário removido"),
            @ApiResponse(responseCode = "404", description = "Beneficiário não encontrado")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

}
