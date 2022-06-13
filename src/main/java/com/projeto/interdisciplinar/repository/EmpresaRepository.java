package com.projeto.interdisciplinar.repository;

import com.projeto.interdisciplinar.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findByCnpj(String cnpj);

}
