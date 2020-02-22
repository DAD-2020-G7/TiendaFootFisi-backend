package com.footfisi.tienda.model;

import java.util.Date;

public class ComprobanteModel {
	private int nIdComprobante;
	private String sTipoComprobante;
	private Date dfechaComprobante;
	private String sEstadoComprobante;

	public int getnIComprobante() {
		return nIdComprobante;
	}

	public void setnIComprobante(int nIdComprobante) {
		this.nIdComprobante = nIdComprobante;
	}

	public String getsTipoComprobante() {
		return sTipoComprobante;
	}

	public void setsTipoComprobante(String sTipoComprobante) {
		this.sTipoComprobante = sTipoComprobante;
	}

	public Date getDfechaComprobante() {
		return dfechaComprobante;
	}

	public void setDfechaComprobante(Date dfechaComprobante) {
		this.dfechaComprobante = dfechaComprobante;
	}

	public String getsEstadoComprobante() {
		return sEstadoComprobante;
	}

	public void setsEstadoComprobante(String sEstadoComprobante) {
		this.sEstadoComprobante = sEstadoComprobante;
	}

}
