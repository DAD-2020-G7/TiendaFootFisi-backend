package com.footfisi.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.model.TallaModel;
import com.footfisi.tienda.repository.RepositoryTalla;
import com.footfisi.tienda.service.inter.TallaServicio;
import com.footfisi.tienda.transform.TallaTransform;

@Service("tallaService")
public class TallaServicioImpl implements TallaServicio{
	@Autowired
	@Qualifier("tallaRepository")
	private RepositoryTalla tallaProductoRepository;
	@Autowired
	@Qualifier("tallaTransform")
	private TallaTransform tallaProductoTransform;
	
	@Override
	public List<TallaModel> listarTallas() {
		return tallaProductoTransform.transformEM(tallaProductoRepository.findAll());
	}

}
