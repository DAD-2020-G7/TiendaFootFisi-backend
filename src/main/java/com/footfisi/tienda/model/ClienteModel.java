package com.footfisi.tienda.model;

public class ClienteModel extends PersonaModel{
	private String sDireccion;
	private String sCelular;
	private String sCorreoElectronico;

	public String getsDireccion() {
		return sDireccion;
	}

	public void setsDireccion(String sDireccion) {
		this.sDireccion = sDireccion;
	}

	public String getsCelular() {
		return sCelular;
	}

	public void setsCelular(String sCelular) {
		this.sCelular = sCelular;
	}

	public String getsCorreoElectronico() {
		return sCorreoElectronico;
	}

	public void setsCorreoElectronico(String sCorreoElectronico) {
		this.sCorreoElectronico = sCorreoElectronico;
	}

}
