package com.footfisi.tienda.model;

public class PedidoDetalleModel {
	private int nIdProducto;
	private String sNombreProducto;
	private int nCantidadProducto;
	private double nTotalParcial;

	public int getnIdProducto() {
		return nIdProducto;
	}

	public void setnIdProducto(int nIdProducto) {
		this.nIdProducto = nIdProducto;
	}

	public String getsNombreProducto() {
		return sNombreProducto;
	}

	public void setsNombreProducto(String sNombreProducto) {
		this.sNombreProducto = sNombreProducto;
	}

	public int getnCantidadProducto() {
		return nCantidadProducto;
	}

	public void setnCantidadProducto(int nCantidadProducto) {
		this.nCantidadProducto = nCantidadProducto;
	}

	public double getnTotalParcial() {
		return nTotalParcial;
	}

	public void setnTotalParcial(double nTotalParcial) {
		this.nTotalParcial = nTotalParcial;
	}

}
