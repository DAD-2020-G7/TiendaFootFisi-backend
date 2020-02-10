package com.footfisi.tienda.model;

public class CategoriaProductoModel {
	private int nIdCategoria;
	private String sMarca;
	private String sGenero;
	private String sTipo;

	public int getnIdCategoria() {
		return nIdCategoria;
	}

	public void setnIdCategoria(int nIdCategoria) {
		this.nIdCategoria = nIdCategoria;
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
