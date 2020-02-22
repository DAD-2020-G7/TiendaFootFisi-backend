package com.footfisi.tienda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.entity.MantCategoria;
import com.footfisi.tienda.model.CategoriaModel;
import com.footfisi.tienda.repository.RepositoryCategoria;
import com.footfisi.tienda.service.inter.CategoriaServicio;
import com.footfisi.tienda.transform.CategoriaTransform;
import com.footfisi.tienda.util.UtilList;

@Service("categoriaService")
public class CategoriaServicioImpl implements CategoriaServicio {
	@Autowired
	@Qualifier("categoriaRepository")
	private RepositoryCategoria categoriaProductoRepository;
	@Autowired
	@Qualifier("categoriaTransform")
	private CategoriaTransform categoriaProductoTransform;

	@Override
	public List<CategoriaModel> listarPorMarca() {
		List<CategoriaModel> listaCategoriaProductoModel = categoriaProductoTransform.transformEM(categoriaProductoRepository.findAll());
		listaCategoriaProductoModel = listaCategoriaProductoModel.stream().filter( UtilList.distinctByKey(p -> p.getsMarca())).collect( Collectors.toList() );
		
		return listaCategoriaProductoModel;
	}

	@Override
	public List<CategoriaModel> listarPorGenero(String sMarca) {
		List<MantCategoria> lEntityCategoriaProducto = categoriaProductoRepository.findAll();
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter(s -> s.getVmarca().equals(sMarca))
				.collect(Collectors.toList());
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter( UtilList.distinctByKey(s -> s.getVgenero()) )
				.collect(Collectors.toList());
		return categoriaProductoTransform.transformEM(lEntityCategoriaProducto);
	}

	@Override
	public List<CategoriaModel> listarPorTipo(String sMarca, String sGenero) {
		List<MantCategoria> lEntityCategoriaProducto = categoriaProductoRepository.findAll();
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter(s -> s.getVmarca().equals(sMarca))
				.collect(Collectors.toList());
		lEntityCategoriaProducto = lEntityCategoriaProducto.stream().filter(s -> s.getVgenero().equals(sGenero))
				.collect(Collectors.toList());
		return categoriaProductoTransform.transformEM(lEntityCategoriaProducto);
	}

}
