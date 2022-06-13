package com.projeto.interdisciplinar.repository;

import com.projeto.interdisciplinar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCpf(String cpf);

    List<Usuario> findByName(String name);
}
