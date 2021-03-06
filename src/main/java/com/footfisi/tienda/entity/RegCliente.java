package com.footfisi.tienda.entity;
// Generated 09-feb-2020 20:45:28 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * RegCliente generated by hbm2java
 */
@Entity
@Table(name = "reg_cliente", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_tipo_documento", "\"vNumeroDocumento\"" }))
public class RegCliente implements java.io.Serializable {

	private RegClienteId id;
	private String vapellidoPaterno;
	private String vapellidoMaterno;
	private String vnombres;
	private String vdireccion;
	private String vcelular;
	private String vcorreoElectronico;
	private Set<RegPedido> regPedidos = new HashSet<RegPedido>(0);

	public RegCliente() {
	}

	public RegCliente(RegClienteId id) {
		this.id = id;
	}

	public RegCliente(RegClienteId id, Set<RegPedido> regPedidos) {
		this.id = id;
		this.regPedidos = regPedidos;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idTipoDocumento", column = @Column(name = "id_tipo_documento", nullable = false)),
			@AttributeOverride(name = "vnumeroDocumento", column = @Column(name = "\"vNumeroDocumento\"", nullable = false)) 
			})
	public RegClienteId getId() {
		return this.id;
	}

	public void setId(RegClienteId id) {
		this.id = id;
	}

	@Column(name = "\"vApellidoPaterno\"")
	public String getVapellidoPaterno() {
		return this.vapellidoPaterno;
	}

	public void setVapellidoPaterno(String vapellidoPaterno) {
		this.vapellidoPaterno = vapellidoPaterno;
	}

	@Column(name = "\"vApellidoMaterno\"")
	public String getVapellidoMaterno() {
		return this.vapellidoMaterno;
	}

	public void setVapellidoMaterno(String vapellidoMaterno) {
		this.vapellidoMaterno = vapellidoMaterno;
	}

	@Column(name = "\"vNombres\"")
	public String getVnombres() {
		return this.vnombres;
	}

	public void setVnombres(String vnombres) {
		this.vnombres = vnombres;
	}

	@Column(name = "\"vDireccion\"")
	public String getVdireccion() {
		return this.vdireccion;
	}

	public void setVdireccion(String vdireccion) {
		this.vdireccion = vdireccion;
	}

	@Column(name = "\"vCelular\"")
	public String getVcelular() {
		return this.vcelular;
	}

	public void setVcelular(String vcelular) {
		this.vcelular = vcelular;
	}

	@Column(name = "\"vCorreoElectronico\"")
	public String getVcorreoElectronico() {
		return this.vcorreoElectronico;
	}

	public void setVcorreoElectronico(String vcorreoElectronico) {
		this.vcorreoElectronico = vcorreoElectronico;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "regCliente")
	public Set<RegPedido> getRegPedidos() {
		return this.regPedidos;
	}

	public void setRegPedidos(Set<RegPedido> regPedidos) {
		this.regPedidos = regPedidos;
	}

}
