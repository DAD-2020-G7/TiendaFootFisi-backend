package com.footfisi.tienda.entity;
// Generated 09-feb-2020 20:45:28 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MantProductoTalla generated by hbm2java
 */
@Entity
@Table(name = "mant_producto_talla", schema = "public")
public class MantProductoTalla implements java.io.Serializable {

	private int idTalla;
	private String vdescripcion;
	private Set<MantProducto> mantProductos = new HashSet<MantProducto>(0);

	public MantProductoTalla() {
	}

	public MantProductoTalla(int idTalla) {
		this.idTalla = idTalla;
	}

	public MantProductoTalla(int idTalla, String vdescripcion, Set<MantProducto> mantProductos) {
		this.idTalla = idTalla;
		this.vdescripcion = vdescripcion;
		this.mantProductos = mantProductos;
	}

	@Id

	@Column(name = "id_talla", unique = true, nullable = false)
	public int getIdTalla() {
		return this.idTalla;
	}

	public void setIdTalla(int idTalla) {
		this.idTalla = idTalla;
	}

	@Column(name = "\"vDescripcion\"")
	public String getVdescripcion() {
		return this.vdescripcion;
	}

	public void setVdescripcion(String vdescripcion) {
		this.vdescripcion = vdescripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mantProductoTalla")
	public Set<MantProducto> getMantProductos() {
		return this.mantProductos;
	}

	public void setMantProductos(Set<MantProducto> mantProductos) {
		this.mantProductos = mantProductos;
	}

}
