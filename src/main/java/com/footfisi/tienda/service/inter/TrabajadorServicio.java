package com.footfisi.tienda.service.inter;

import java.util.List;

import com.footfisi.tienda.form.UsuarioTrabajadorForm;
import com.footfisi.tienda.model.TrabajadorModel;

public interface TrabajadorServicio {
	public List<TrabajadorModel> listarTrabajador();
	public TrabajadorModel buscarTrabajador(String sIdTipoDocumento, String sNumeroDocumento);
	public void registrarTrabajador(UsuarioTrabajadorForm trabajador);
}
