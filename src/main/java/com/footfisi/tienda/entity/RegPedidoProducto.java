package com.footfisi.tienda.entity;
// Generated 09-feb-2020 20:45:28 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RegPedidoProducto generated by hbm2java
 */
@Entity
@Table(name = "reg_pedido_producto", schema = "public")
public class RegPedidoProducto implements java.io.Serializable {

	private RegPedidoProductoId id;
	private MantProducto mantProducto;
	private RegPedido regPedido;
	private Integer ncantidad;
	private BigDecimal nsubTotal;

	public RegPedidoProducto() {
	}

	public RegPedidoProducto(RegPedidoProductoId id, MantProducto mantProducto, RegPedido regPedido) {
		this.id = id;
		this.mantProducto = mantProducto;
		this.regPedido = regPedido;
	}

	public RegPedidoProducto(RegPedidoProductoId id, MantProducto mantProducto, RegPedido regPedido, Integer ncantidad,
			BigDecimal nsubTotal) {
		this.id = id;
		this.mantProducto = mantProducto;
		this.regPedido = regPedido;
		this.ncantidad = ncantidad;
		this.nsubTotal = nsubTotal;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idPedido", column = @Column(name = "\"id_Pedido\"", nullable = false)),
			@AttributeOverride(name = "idProducto", column = @Column(name = "\"id_Producto\"", nullable = false)) })
	public RegPedidoProductoId getId() {
		return this.id;
	}

	public void setId(RegPedidoProductoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"id_Producto\"", nullable = false, insertable = false, updatable = false)
	public MantProducto getMantProducto() {
		return this.mantProducto;
	}

	public void setMantProducto(MantProducto mantProducto) {
		this.mantProducto = mantProducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"id_Pedido\"", nullable = false, insertable = false, updatable = false)
	public RegPedido getRegPedido() {
		return this.regPedido;
	}

	public void setRegPedido(RegPedido regPedido) {
		this.regPedido = regPedido;
	}

	@Column(name = "\"nCantidad\"")
	public Integer getNcantidad() {
		return this.ncantidad;
	}

	public void setNcantidad(Integer ncantidad) {
		this.ncantidad = ncantidad;
	}

	@Column(name = "\"nSubTotal\"", precision = 131089, scale = 0)
	public BigDecimal getNsubTotal() {
		return this.nsubTotal;
	}

	public void setNsubTotal(BigDecimal nsubTotal) {
		this.nsubTotal = nsubTotal;
	}

}
