package com.footfisi.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.model.TipoDocumentoModel;
import com.footfisi.tienda.repository.RepositoryTipoDocumento;
import com.footfisi.tienda.service.inter.TipoDocumentoServicio;
import com.footfisi.tienda.transform.TipoDocumentoTransform;

@Service("tipoDocumentoService")
public class TipoDocumentoServicioImpl implements TipoDocumentoServicio{
	@Autowired
	@Qualifier("tipoDocumentoRepository")
	private RepositoryTipoDocumento tipoDocumentoRepository;
	@Autowired
	@Qualifier("tipoDocumentoTransform")
	private TipoDocumentoTransform tipoDocumentoTransform;
	
	@Override
	public List<TipoDocumentoModel> listarTipoDocumentos() {
		return tipoDocumentoTransform.transformEM(tipoDocumentoRepository.findAll());
	}

}
