package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.RegTrabajador;
import com.footfisi.tienda.entity.RegTrabajadorId;

@Repository("trabajadorRepository")
public interface RepositoryTrabajador extends JpaRepository<RegTrabajador, RegTrabajadorId>{

}
