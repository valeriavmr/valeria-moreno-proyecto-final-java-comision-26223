package com.ejemplo.articulo_api_final.repository;
import com.ejemplo.articulo_api_final.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}
