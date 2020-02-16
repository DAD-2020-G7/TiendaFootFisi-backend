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
import com.footfisi.tienda.util.UtilList;

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
		List<CategoriaProductoModel> listaCategoriaProductoModel = categoriaProductoTransform.transformEM(categoriaProductoRepository.findAll());
		listaCategoriaProductoModel = listaCategoriaProductoModel.stream().filter( UtilList.distinctByKey(p -> p.getsMarca())).collect( Collectors.toList() );
		
		return listaCategoriaProductoModel;
	}

	@Override
	public List<CategoriaProductoModel> listarPorGenero(String sMarca) {
		List<MantProductoCategoria> lEntityCategoriaProducto = categoriaProductoRepository.findAll();
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter(s -> s.getVmarca().equals(sMarca))
				.collect(Collectors.toList());
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter( UtilList.distinctByKey(s -> s.getVgenero()) )
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
