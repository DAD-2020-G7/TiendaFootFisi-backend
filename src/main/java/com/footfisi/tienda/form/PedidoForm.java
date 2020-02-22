package com.footfisi.tienda.form;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoForm {
	private int tipoComp;
	private String codEstablecimiento;
	private String numeroSerie;
	private String tipoDoc;
	private String numeroDoc;
	private String nombrePer;
	private String direccionPer;
	private List<PedidoDetalleForm> items;
	private boolean igv;
	private double total;
	private int estado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date fechaRegistro;

	public int getTipoComp() {
		return tipoComp;
	}

	public void setTipoComp(int tipoComp) {
		this.tipoComp = tipoComp;
	}

	public String getCodEstablecimiento() {
		return codEstablecimiento;
	}

	public void setCodEstablecimiento(String codEstablecimiento) {
		this.codEstablecimiento = codEstablecimiento;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public String getNombrePer() {
		return nombrePer;
	}

	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}

	public String getDireccionPer() {
		return direccionPer;
	}

	public void setDireccionPer(String direccionPer) {
		this.direccionPer = direccionPer;
	}

	public List<PedidoDetalleForm> getItems() {
		return items;
	}

	public void setItems(List<PedidoDetalleForm> items) {
		this.items = items;
	}

	public boolean isIgv() {
		return igv;
	}

	public void setIgv(boolean igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
