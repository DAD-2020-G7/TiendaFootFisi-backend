package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.MantTalla;

@Repository("tallaRepository")
public interface RepositoryTalla extends JpaRepository<MantTalla, Integer>{

}
