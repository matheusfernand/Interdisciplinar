package com.projeto.interdisciplinar.service;

import com.projeto.interdisciplinar.exceptions.DataBaseException;
import com.projeto.interdisciplinar.exceptions.ResourceNotFoundException;
import com.projeto.interdisciplinar.model.Empresa;
import com.projeto.interdisciplinar.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(Long id) {
        Optional<Empresa> obj = empresaRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Empresa findByCnpj(String cnpj) {
        Optional<Empresa> obj = empresaRepository.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ResourceNotFoundException(cnpj));
    }

    public Empresa insert(Empresa obj) {
        return empresaRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            empresaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
