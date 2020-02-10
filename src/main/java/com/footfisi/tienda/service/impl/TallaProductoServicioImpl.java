package com.footfisi.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.model.TallaProductoModel;
import com.footfisi.tienda.repository.RepositoryTallaProducto;
import com.footfisi.tienda.service.inter.TallaProductoServicio;
import com.footfisi.tienda.transform.TallaProductoTransform;

@Service("tallaProductoService")
public class TallaProductoServicioImpl implements TallaProductoServicio{
	@Autowired
	@Qualifier("tallaProductoRepository")
	private RepositoryTallaProducto tallaProductoRepository;
	@Autowired
	@Qualifier("tallaProductoTransform")
	private TallaProductoTransform tallaProductoTransform;
	
	@Override
	public List<TallaProductoModel> listarTallas() {
		return tallaProductoTransform.transformEM(tallaProductoRepository.findAll());
	}

}
