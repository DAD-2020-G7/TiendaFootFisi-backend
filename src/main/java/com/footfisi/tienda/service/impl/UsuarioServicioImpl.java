package com.footfisi.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.form.UsuarioTrabajadorForm;
import com.footfisi.tienda.model.UsuarioModel;
import com.footfisi.tienda.repository.RepositoryUsuario;
import com.footfisi.tienda.service.inter.UsuarioServicio;
import com.footfisi.tienda.transform.ClienteUsuarioTransform;
import com.footfisi.tienda.transform.TrabajadorUsuarioTransform;
import com.footfisi.tienda.transform.UsuarioTransform;

@Service("usuarioService")
public class UsuarioServicioImpl implements UsuarioServicio{
	@Autowired
	@Qualifier("usuarioRepository")
	private RepositoryUsuario usuarioRepository;
	@Autowired
	@Qualifier("clienteUsuarioTransform")
	private ClienteUsuarioTransform clienteUsuarioTransform;
	@Autowired
	@Qualifier("trabajadorUsuarioTransform")
	private TrabajadorUsuarioTransform trabajadorUsuarioTransform;
	@Autowired
	@Qualifier("usuarioTransform")
	private UsuarioTransform usuarioTransform;
	
	@Override
	public List<UsuarioModel> listarUsuarios() {
		return usuarioTransform.transformEM(usuarioRepository.findAll());
	}

	@Override
	public UsuarioModel buscarUsuario(String sIdUsuario) {
		return usuarioTransform.transformEM(usuarioRepository.findByIdUsuario(sIdUsuario));
	}
	
	@Override
	public void registrarUsuarioCliente(UsuarioClienteForm clienteForm) {
		UsuarioModel oModelUsuario = clienteUsuarioTransform.transformFM(clienteForm);
		usuarioRepository.save(usuarioTransform.transformME(oModelUsuario));
	}

	@Override
	public void registrarUsuarioTrabajador(UsuarioTrabajadorForm trabajadorForm) {
		UsuarioModel oModelUsuario = trabajadorUsuarioTransform.transformFM(trabajadorForm);
		usuarioRepository.save(usuarioTransform.transformME(oModelUsuario));
	}

}
