package com.footfisi.tienda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.entity.MantProductoCategoria;
import com.footfisi.tienda.model.CategoriaProductoModel;
import com.footfisi.tienda.repository.RepositoryCategoriaProducto;
import com.footfisi.tienda.service.inter.CategoriaProductoServicio;
import com.footfisi.tienda.transform.CategoriaProductoTransform;

@Service("categoriaProductoService")
public class CategoriaProductoServicioImpl implements CategoriaProductoServicio {
	@Autowired
	@Qualifier("categoriaProductoRepository")
	private RepositoryCategoriaProducto categoriaProductoRepository;
	@Autowired
	@Qualifier("categoriaProductoTransform")
	private CategoriaProductoTransform categoriaProductoTransform;

	@Override
	public List<CategoriaProductoModel> listarPorMarca() {
		return categoriaProductoTransform.transformEM(categoriaProductoRepository.findAll());
	}

	@Override
	public List<CategoriaProductoModel> listarPorGenero(String sMarca) {
		List<MantProductoCategoria> lEntityCategoriaProducto = categoriaProductoRepository.findAll();
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter(s -> s.getVmarca().equals(sMarca))
				.collect(Collectors.toList());
		return categoriaProductoTransform.transformEM(lEntityCategoriaProducto);
	}

	@Override
	public List<CategoriaProductoModel> listarPorTipo(String sMarca, String sGenero) {
		List<MantProductoCategoria> lEntityCategoriaProducto = categoriaProductoRepository.findAll();
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter(s -> s.getVmarca().equals(sMarca))
				.collect(Collectors.toList());
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter(s -> s.getVgenero().equals(sGenero))
				.collect(Collectors.toList());
		return categoriaProductoTransform.transformEM(lEntityCategoriaProducto);
	}

}
