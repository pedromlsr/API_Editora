package com.residencia.firstapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.firstapi.entity.Autor;
import com.residencia.firstapi.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        return ResponseEntity.ok().body(autorService.findAll());
    }

    @GetMapping("/{id}")
    public Autor findById(@PathVariable(value = "id") Integer id){
        return autorService.findById(id);
    }
    
    @GetMapping("/nome/{autorNome}")
    public Autor findByAutorNomeIgnoreCase(@PathVariable(value = "autorNome") String autorNome) {
    	return autorService.findByAutorNomeIgnoreCase(autorNome);
    }

    @PostMapping
    public Autor save(@RequestBody Autor autor){
        return autorService.save(autor);
    }

    @PutMapping("/{id}")
    public Autor update(@PathVariable Integer id, @RequestBody Autor autor) {
        return autorService.update(autor, id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        autorService.delete(id);
    }
}