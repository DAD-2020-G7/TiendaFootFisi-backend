package com.footfisi.tienda.service.inter;

import java.util.List;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.UsuarioModel;

public interface UsuarioServicio {
	public List<UsuarioModel> listarUsuarios();
	public UsuarioModel buscarUsuario(String sIdUsuario);
	public void registrarUsuarioCliente(UsuarioClienteForm clienteForm);
}
