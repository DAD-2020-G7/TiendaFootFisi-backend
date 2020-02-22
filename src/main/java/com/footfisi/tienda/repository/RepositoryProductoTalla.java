package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.MantProductoTalla;
import com.footfisi.tienda.entity.MantProductoTallaId;

@Repository("productoTallaRepository")
public interface RepositoryProductoTalla extends JpaRepository<MantProductoTalla, MantProductoTallaId>{

}
