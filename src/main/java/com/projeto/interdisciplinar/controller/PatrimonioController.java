package com.projeto.interdisciplinar.controller;

import com.projeto.interdisciplinar.model.Patrimonio;
import com.projeto.interdisciplinar.service.PatrimonioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/patrimonios")
@RequiredArgsConstructor
public class PatrimonioController {

    private final PatrimonioService patrimonioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Patrimonio> insert(@RequestBody Patrimonio obj) {
        obj = patrimonioService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Patrimonio> findById(@PathVariable Long id) {
        Patrimonio obj = patrimonioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Patrimonio>> findAll() {
        List<Patrimonio> list = patrimonioService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
