package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.MantProductoTalla;

@Repository("tallaProductoRepository")
public interface RepositoryTallaProducto extends JpaRepository<MantProductoTalla, Integer>{

}
