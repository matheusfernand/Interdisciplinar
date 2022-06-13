package com.projeto.interdisciplinar.service;

import com.projeto.interdisciplinar.exceptions.DataBaseException;
import com.projeto.interdisciplinar.exceptions.ResourceNotFoundException;
import com.projeto.interdisciplinar.model.Usuario;
import com.projeto.interdisciplinar.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario insert(Usuario obj) {
        return usuarioRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario obj) {
        try {
            Usuario entity = usuarioRepository.getById(id);
            updateData(entity, obj);
            return usuarioRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Usuario> findByName(String name) {
        List<Usuario> obj = usuarioRepository.findByName(name);
        return obj;
    }

}
