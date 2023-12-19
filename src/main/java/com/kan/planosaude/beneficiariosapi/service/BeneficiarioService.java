package com.kan.planosaude.beneficiariosapi.service;

import com.kan.planosaude.beneficiariosapi.dto.BeneficiarioInclusaoRequestDTO;
import com.kan.planosaude.beneficiariosapi.dto.BeneficiarioRequestDTO;
import com.kan.planosaude.beneficiariosapi.dto.BeneficiarioResponseDTO;

import java.util.List;

public interface BeneficiarioService {

    BeneficiarioResponseDTO obterPorId(Long id);

    BeneficiarioResponseDTO salvar(BeneficiarioInclusaoRequestDTO requestDTO);
    List<BeneficiarioResponseDTO> obterBeneficiarios();

    void atualizar(Long id, BeneficiarioRequestDTO requestDTO);

    void remover(Long id);

}
