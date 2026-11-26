package com.ejemplo.articulo_api_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.ejemplo.articulo_api_final.service.ArticuloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.ejemplo.articulo_api_final.model.Articulo;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }
    
    @GetMapping
    public List<Articulo> listar() {
        return articuloService.getAllArticulos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtener(@PathVariable Long id) {
        return articuloService.getArticuloById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Articulo> crear(@RequestBody Articulo articulo) {
        Articulo nuevoArticulo = articuloService.createArticulo(articulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoArticulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo entity) {
        if(articuloService.getArticuloById(id).isPresent()) {
            Articulo updatedArticulo = articuloService.updateArticulo(id, entity);
            return ResponseEntity.ok(updatedArticulo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if(articuloService.getArticuloById(id).isPresent()) {
            articuloService.deleteArticulo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
