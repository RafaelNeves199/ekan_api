package com.kan.planosaude.beneficiariosapi.service.impl;

import com.kan.planosaude.beneficiariosapi.dto.DocumentoResponseDTO;
import com.kan.planosaude.beneficiariosapi.exception.ResourceNotFoundException;
import com.kan.planosaude.beneficiariosapi.entity.Documento;
import com.kan.planosaude.beneficiariosapi.repository.DocumentoRepository;
import com.kan.planosaude.beneficiariosapi.service.DocumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    private Logger logger = LoggerFactory.getLogger(DocumentoServiceImpl.class);

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public List<DocumentoResponseDTO> obterPorIdBeneficiario(Long idBeneficiario) {
        return documentoRepository.findDocumentosByBeneficiario(idBeneficiario)
                .stream()
                .map(documento -> {
                    DocumentoResponseDTO responseDTO = new DocumentoResponseDTO();
                    BeanUtils.copyProperties(documento, responseDTO, "beneficiario_id");
                    responseDTO.setBeneficiario_id(idBeneficiario);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public void salvar(List<Documento> documentos) {
        documentoRepository.saveAll(documentos);
    }

    @Override
    public void remover(Long id) {
        Optional<Documento> documento = documentoRepository.findById(id);
        if(documento.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível deletar o Documento id: " + id + "  Documento não encontrado");
        }
        documentoRepository.delete(documento.get());
    }

    @Override
    public void removerPorBeneficiario(Long idBeneficiario) {
        documentoRepository.deleteDocumentoByBeneficiarioId(idBeneficiario);
    }
}
