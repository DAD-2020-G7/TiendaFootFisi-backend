package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.MantProducto;

@Repository("productoRepository")
public interface RepositoryProducto extends JpaRepository<MantProducto, Integer>{
	public MantProducto findByIdProducto(int idProducto);
}
