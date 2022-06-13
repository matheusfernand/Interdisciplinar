package com.projeto.interdisciplinar.controller;

import com.projeto.interdisciplinar.model.Empresa;
import com.projeto.interdisciplinar.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> list = empresaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        Empresa obj = empresaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<Empresa> findByCnpj(@PathVariable String cnpj) {
        Empresa obj = empresaService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Empresa> insert(@RequestBody Empresa obj) {
        obj = empresaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
