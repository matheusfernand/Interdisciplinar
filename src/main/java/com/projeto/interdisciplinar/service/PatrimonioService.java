package com.projeto.interdisciplinar.service;

import com.projeto.interdisciplinar.model.Patrimonio;
import com.projeto.interdisciplinar.repository.PatrimonioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PatrimonioService {

    private final PatrimonioRepository patrimonioRepository;

    public Patrimonio insert(Patrimonio obj) {
        obj.setDataRegistro(new Date());
        return patrimonioRepository.save(obj);
    }

    public List<Patrimonio> findAll() {
            return patrimonioRepository.findAll();
    }

    public Patrimonio findById(Long id) {
        Optional<Patrimonio> obj = patrimonioRepository.findById(id);
        return obj.get();
    }
}