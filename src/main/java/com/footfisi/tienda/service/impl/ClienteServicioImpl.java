package com.footfisi.tienda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<ClienteModel> listarCliente() {
		return clienteTransform.transformEM(clienteRepository.findAll());
	}

	@Override
	public ClienteModel buscarCliente(String sIdTipoDocumento, String sNumeroDocumento) {
		List<ClienteModel> lModelCliente= clienteTransform.transformEM(clienteRepository.findAll());
		if(!lModelCliente.isEmpty()) {
			lModelCliente = lModelCliente.stream().filter(s -> s.getsIdTipoDocumento().equals(sIdTipoDocumento) && s.getsNumeroDocumento().equals(sNumeroDocumento)).collect(Collectors.toList());
			return lModelCliente.get(0);
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public void registrarCliente(UsuarioClienteForm cliente) {
		ClienteModel oModel = clienteTransform.transformFM(cliente);
		clienteRepository.save(clienteTransform.transformME(oModel));
	}

}
