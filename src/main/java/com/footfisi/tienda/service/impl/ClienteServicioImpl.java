package com.footfisi.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.ClienteModel;
import com.footfisi.tienda.repository.RepositoryCliente;
import com.footfisi.tienda.service.inter.ClienteServicio;
import com.footfisi.tienda.transform.ClienteTransform;

@Service("clienteService")
public class ClienteServicioImpl implements ClienteServicio{
	@Autowired
	@Qualifier("clienteRepository")
	private RepositoryCliente clienteRepository;
	@Autowired
	@Qualifier("clienteTransform")
	private ClienteTransform clienteTransform;
	
	@Override
	public void registrarCliente(UsuarioClienteForm cliente) {
		ClienteModel oModel = clienteTransform.transformFM(cliente);
		clienteRepository.save(clienteTransform.transformME(oModel));
	}

}
