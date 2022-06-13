package com.projeto.interdisciplinar.controller;

import com.projeto.interdisciplinar.model.Usuario;
import com.projeto.interdisciplinar.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<Usuario>> findByName(@PathVariable String name) {
        List<Usuario> obj = usuarioService.findByName(name);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Usuario> insert(@RequestBody Usuario obj) {
        obj = usuarioService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) {
        obj = usuarioService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
