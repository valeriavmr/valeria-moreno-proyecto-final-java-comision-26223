package com.ejemplo.articulo_api_final.service;
import com.ejemplo.articulo_api_final.model.Articulo;
import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    List<Articulo> getAllArticulos();
    Optional<Articulo> getArticuloById(Long id);
    Articulo createArticulo(Articulo articulo);
    Articulo updateArticulo(Long id, Articulo articulo);
    void deleteArticulo(Long id);
}
