package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.MantCategoria;

@Repository("categoriaRepository")
public interface RepositoryCategoria extends JpaRepository<MantCategoria, Integer>{

}
