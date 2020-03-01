package com.footfisi.tienda.service.inter;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.form.UsuarioTrabajadorForm;

public interface PersonaServicio {
	public void registrarPersonaCliente(UsuarioClienteForm cliente);
	public void registrarPersonaTrabajador(UsuarioTrabajadorForm trabajador);
}
