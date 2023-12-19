package com.kan.planosaude.beneficiariosapi.service;

import com.kan.planosaude.beneficiariosapi.dto.DocumentoResponseDTO;
import com.kan.planosaude.beneficiariosapi.entity.Documento;

import java.util.List;

public interface DocumentoService {
    List<DocumentoResponseDTO> obterPorIdBeneficiario(Long idBeneficiario);

    void salvar(List<Documento> documentos);

    void remover(Long id);

    void removerPorBeneficiario(Long idBeneficiario);

}

