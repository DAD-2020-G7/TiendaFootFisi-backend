package com.footfisi.tienda.model;

import java.util.List;

public class ProductoModel {
	private int idProducto;

	private int idCategoria;
	private String sMarca;
	private String sGenero;
	private String sTipo;

	private List<TallaModel> lTallas;

	private String sNombre;
	private String sDescripcion;
	private double nPrecioUnitario;
	private int nCantidad;
	private String sFoto;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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

	public List<TallaModel> getlTallas() {
		return lTallas;
	}

	public void setlTallas(List<TallaModel> lTallas) {
		this.lTallas = lTallas;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsDescripcion() {
		return sDescripcion;
	}

	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}

	public double getnPrecioUnitario() {
		return nPrecioUnitario;
	}

	public void setnPrecioUnitario(double nPrecioUnitario) {
		this.nPrecioUnitario = nPrecioUnitario;
	}

	public int getnCantidad() {
		return nCantidad;
	}

	public void setnCantidad(int nCantidad) {
		this.nCantidad = nCantidad;
	}

	public String getsFoto() {
		return sFoto;
	}

	public void setsFoto(String sFoto) {
		this.sFoto = sFoto;
	}

}
