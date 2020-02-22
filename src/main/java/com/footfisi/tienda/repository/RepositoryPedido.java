package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.RegPedido;

@Repository("pedidoRepository")
public interface RepositoryPedido extends JpaRepository<RegPedido, Integer>{

}
