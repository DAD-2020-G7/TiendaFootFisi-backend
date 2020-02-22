package com.footfisi.tienda.service.inter;

import java.util.List;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.ClienteModel;

public interface ClienteServicio {
	public List<ClienteModel> listarCliente();
	public ClienteModel buscarCliente(String sIdTipoDocumento, String sNumeroDocumento);
	public void registrarCliente(UsuarioClienteForm cliente);
}
