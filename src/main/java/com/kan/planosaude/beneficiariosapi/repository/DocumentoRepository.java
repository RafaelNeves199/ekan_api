package com.kan.planosaude.beneficiariosapi.repository;

import com.kan.planosaude.beneficiariosapi.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query(" select d from Documento d where d.beneficiario.id = :id")
    List<Documento> findDocumentosByBeneficiario(Long id);

    @Query("delete from Documento d where d.beneficiario.id = :id")
    @Modifying
    @Transactional
    void deleteDocumentoByBeneficiarioId(Long id);

}
