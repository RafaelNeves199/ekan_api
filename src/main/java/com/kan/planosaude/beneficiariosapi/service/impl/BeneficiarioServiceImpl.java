package com.kan.planosaude.beneficiariosapi.service.impl;

import com.kan.planosaude.beneficiariosapi.controller.BeneficiarioController;
import com.kan.planosaude.beneficiariosapi.dto.BeneficiarioInclusaoRequestDTO;
import com.kan.planosaude.beneficiariosapi.dto.BeneficiarioRequestDTO;
import com.kan.planosaude.beneficiariosapi.dto.BeneficiarioResponseDTO;
import com.kan.planosaude.beneficiariosapi.dto.DocumentoRequestDTO;
import com.kan.planosaude.beneficiariosapi.exception.ResourceNotFoundException;
import com.kan.planosaude.beneficiariosapi.entity.Beneficiario;
import com.kan.planosaude.beneficiariosapi.entity.Documento;
import com.kan.planosaude.beneficiariosapi.repository.BeneficiarioRepository;
import com.kan.planosaude.beneficiariosapi.service.BeneficiarioService;
import com.kan.planosaude.beneficiariosapi.service.DocumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    private Logger logger = LoggerFactory.getLogger(BeneficiarioServiceImpl.class);

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private DocumentoService documentoService;

    @Override
    public BeneficiarioResponseDTO obterPorId(Long id) {
        return beneficiarioRepository
                .findById(id)
                .map(beneficiario -> {
                    BeneficiarioResponseDTO dto = new BeneficiarioResponseDTO();
                    BeanUtils.copyProperties(beneficiario, dto);
                    return dto;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiario não encontrado id: " + id));
    }

    @Transactional
    @Override
    public BeneficiarioResponseDTO salvar(BeneficiarioInclusaoRequestDTO requestDTO) {
        Beneficiario beneficiario = new Beneficiario();
        BeanUtils.copyProperties(requestDTO, beneficiario);
        beneficiarioRepository.save(beneficiario);

        List<Documento> documentos = documentosConverter(requestDTO.getDocumentos(), beneficiario);
        documentoService.salvar(documentos);

        BeneficiarioResponseDTO responseDTO = new BeneficiarioResponseDTO();
        BeanUtils.copyProperties(beneficiario, responseDTO);
        return responseDTO;
    }

    @Override
    public List<BeneficiarioResponseDTO> obterBeneficiarios() {
        return beneficiarioRepository.findAll()
                .stream()
                .map(beneficiario -> {
                    BeneficiarioResponseDTO responseDTO = new BeneficiarioResponseDTO();
                    BeanUtils.copyProperties(beneficiario, responseDTO);
                    return responseDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public void atualizar(Long id, BeneficiarioRequestDTO requestDTO) {
        beneficiarioRepository.findById(id)
                .map(beneficiario -> {
                    BeanUtils.copyProperties(requestDTO, beneficiario, getNullPropertyNames(requestDTO));
                    beneficiarioRepository.save(beneficiario);
                    return beneficiario;
                }).orElseThrow( () -> new ResourceNotFoundException("Beneficiario não encontrado id: " + id));
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
        if(beneficiario.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível deletar o Beneficiario id: " + id + "  Beneficiario não encontrado");
        }
        documentoService.removerPorBeneficiario(id);
        beneficiarioRepository.delete(beneficiario.get());
    }

    public List<Documento> documentosConverter (List<DocumentoRequestDTO> documentos, Beneficiario beneficiario) {
        return documentos
                .stream()
                .map(requestDoc -> {
                    Documento documento = new Documento();
                    BeanUtils.copyProperties(requestDoc, documento);
                    documento.setBeneficiario(beneficiario);
                    return documento;
                }).collect(Collectors.toList());
    }


    private String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set emptyNames = new HashSet();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }
}
