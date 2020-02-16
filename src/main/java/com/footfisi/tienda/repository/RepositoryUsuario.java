package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.SegUsuario;

@Repository("usuarioRepository")
public interface RepositoryUsuario  extends JpaRepository<SegUsuario, String>{

}
