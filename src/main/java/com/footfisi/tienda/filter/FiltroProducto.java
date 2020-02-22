package com.footfisi.tienda.filter;

public class FiltroProducto {
	private String sNombre;

	private int idCategoria;
	private String sMarca;
	private String sGenero;
	private String sTipo;

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getsMarca() {
		return sMarca;
	}

	public void setsMarca(String sMarca) {
		this.sMarca = sMarca;
	}

	public String getsGenero() {
		return sGenero;
	}

	public void setsGenero(String sGenero) {
		this.sGenero = sGenero;
	}

	public String getsTipo() {
		return sTipo;
	}

	public void setsTipo(String sTipo) {
		this.sTipo = sTipo;
	}

}
