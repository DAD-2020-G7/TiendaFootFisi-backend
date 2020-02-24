package com.footfisi.tienda.form;

public class PedidoDetalleForm {
	private String codItem;
	private String descripcionItem;
	private int tallaItem;
	private int cantidadItem;
	private double precioItem;

	public String getCodItem() {
		return codItem;
	}

	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}

	public String getDescripcionItem() {
		return descripcionItem;
	}

	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}

	public int getCantidadItem() {
		return cantidadItem;
	}

	public void setCantidadItem(int cantidadItem) {
		this.cantidadItem = cantidadItem;
	}

	public double getPrecioItem() {
		return precioItem;
	}

	public void setPrecioItem(double precioItem) {
		this.precioItem = precioItem;
	}

	public int getTallaItem() {
		return tallaItem;
	}

	public void setTallaItem(int tallaItem) {
		this.tallaItem = tallaItem;
	}

}
