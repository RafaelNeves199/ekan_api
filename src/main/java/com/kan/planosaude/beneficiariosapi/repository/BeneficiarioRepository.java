package com.kan.planosaude.beneficiariosapi.repository;

import com.kan.planosaude.beneficiariosapi.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
