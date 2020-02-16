package com.footfisi.tienda.model;

public class UsuarioModel {
	private String sIdUsuario;
	private String sContrasenia;
	private String sIdTipoDocumento;
	private String sNumeroDocumento;

	public String getsIdUsuario() {
		return sIdUsuario;
	}

	public void setsIdUsuario(String sIdUsuario) {
		this.sIdUsuario = sIdUsuario;
	}

	public String getsContrasenia() {
		return sContrasenia;
	}

	public void setsContrasenia(String sContrasenia) {
		this.sContrasenia = sContrasenia;
	}

	public String getsIdTipoDocumento() {
		return sIdTipoDocumento;
	}

	public void setsIdTipoDocumento(String sIdTipoDocumento) {
		this.sIdTipoDocumento = sIdTipoDocumento;
	}

	public String getsNumeroDocumento() {
		return sNumeroDocumento;
	}

	public void setsNumeroDocumento(String sNumeroDocumento) {
		this.sNumeroDocumento = sNumeroDocumento;
	}

}
