package com.footfisi.tienda.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoModel {
	private String sIdTipoDocumento;
	private String sNumeroDocumento;

	private ComprobanteModel oComprobanteModel;
	private String sEstado;

	private double nPrecioTotal;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date dFechaCompra;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date dFechaPago;
	private List<PedidoDetalleModel> lDetallePedido;

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

	public ComprobanteModel getoComprobanteModel() {
		return oComprobanteModel;
	}

	public void setoComprobanteModel(ComprobanteModel oComprobanteModel) {
		this.oComprobanteModel = oComprobanteModel;
	}

	public String getsEstado() {
		return sEstado;
	}

	public void setsEstado(String sEstado) {
		this.sEstado = sEstado;
	}

	public double getnPrecioTotal() {
		return nPrecioTotal;
	}

	public void setnPrecioTotal(double nPrecioTotal) {
		this.nPrecioTotal = nPrecioTotal;
	}

	public Date getdFechaCompra() {
		return dFechaCompra;
	}

	public void setdFechaCompra(Date dFechaCompra) {
		this.dFechaCompra = dFechaCompra;
	}

	public Date getdFechaPago() {
		return dFechaPago;
	}

	public void setdFechaPago(Date dFechaPago) {
		this.dFechaPago = dFechaPago;
	}

	public List<PedidoDetalleModel> getlDetallePedido() {
		return lDetallePedido;
	}

	public void setlDetallePedido(List<PedidoDetalleModel> lDetallePedido) {
		this.lDetallePedido = lDetallePedido;
	}

}
