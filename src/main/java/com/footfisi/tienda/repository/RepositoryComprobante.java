package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.RegComprobante;

@Repository("comprobanteRepository")
public interface RepositoryComprobante extends JpaRepository<RegComprobante, Integer> {

}
