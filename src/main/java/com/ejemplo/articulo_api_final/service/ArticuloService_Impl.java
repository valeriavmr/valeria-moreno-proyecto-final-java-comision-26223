package com.ejemplo.articulo_api_final.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejemplo.articulo_api_final.repository.ArticuloRepository;
import com.ejemplo.articulo_api_final.model.Articulo;
import java.util.List;
import java.util.Optional;

@Service 
public class ArticuloService_Impl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    // Implementación de los métodos de la interfaz ArticuloService
    @Autowired 
    public ArticuloService_Impl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override 
    public List<Articulo> getAllArticulos() {
        return articuloRepository.findAll();
    }

    @Override 
    public Optional<Articulo> getArticuloById(Long id) {
        return articuloRepository.findById(id);
    }

    @Override 
    public Articulo createArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public Articulo updateArticulo(Long id, Articulo articulo) {
        Optional<Articulo> existingArticulo = articuloRepository.findById(id);
        if (existingArticulo.isPresent()) {
            Articulo updatedArticulo = existingArticulo.get();
            updatedArticulo.setNombre(articulo.getNombre());
            updatedArticulo.setPrecio(articulo.getPrecio());
            updatedArticulo.setCantidadEnStock(articulo.getCantidadEnStock());
            return articuloRepository.save(updatedArticulo);
        } else {
            throw new RuntimeException("Artículo no encontrado con id: " + id);
        }
    }

    @Override 
    public void deleteArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
    
}
