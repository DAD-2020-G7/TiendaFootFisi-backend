package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.RegPersona;
import com.footfisi.tienda.entity.RegPersonaId;

@Repository("personaRepository")
public interface RepositoryPersona extends JpaRepository<RegPersona, RegPersonaId>{

}
