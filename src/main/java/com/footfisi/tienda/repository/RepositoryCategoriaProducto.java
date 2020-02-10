package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.MantProductoCategoria;

@Repository("categoriaProductoRepository")
public interface RepositoryCategoriaProducto extends JpaRepository<MantProductoCategoria, Integer>{

}
