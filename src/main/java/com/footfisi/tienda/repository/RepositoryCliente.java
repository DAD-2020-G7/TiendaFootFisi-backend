package com.footfisi.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footfisi.tienda.entity.RegCliente;
import com.footfisi.tienda.entity.RegClienteId;

@Repository("clienteRepository")
public interface RepositoryCliente extends JpaRepository<RegCliente, RegClienteId>{

}
