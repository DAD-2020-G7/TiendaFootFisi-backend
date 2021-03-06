package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.MantTipoDocumento;

@Repository("tipoDocumentoRepository")
public interface RepositoryTipoDocumento extends JpaRepository<MantTipoDocumento, String>{

}
