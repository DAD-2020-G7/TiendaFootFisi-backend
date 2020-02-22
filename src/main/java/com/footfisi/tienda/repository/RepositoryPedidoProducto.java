package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.RegPedidoProducto;
import com.footfisi.tienda.entity.RegPedidoProductoId;

@Repository("pedidoProductoRepository")
public interface RepositoryPedidoProducto extends JpaRepository<RegPedidoProducto, RegPedidoProductoId> {

}
