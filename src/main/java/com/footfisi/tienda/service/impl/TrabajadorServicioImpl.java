package com.footfisi.tienda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.form.UsuarioTrabajadorForm;
import com.footfisi.tienda.model.TrabajadorModel;
import com.footfisi.tienda.repository.RepositoryTrabajador;
import com.footfisi.tienda.service.inter.TrabajadorServicio;
import com.footfisi.tienda.transform.TrabajadorTransform;

@Service("trabajadorService")
public class TrabajadorServicioImpl implements TrabajadorServicio{
	@Autowired
	@Qualifier("trabajadorRepository")
	private RepositoryTrabajador trabajadorRepository;
	@Autowired
	@Qualifier("trabajadorTransform")
	private TrabajadorTransform trabajadorTransform;
	
	@Override
	public List<TrabajadorModel> listarTrabajador() {
		return trabajadorTransform.transformEM(trabajadorRepository.findAll());
	}

	@Override
	public TrabajadorModel buscarTrabajador(String sIdTipoDocumento, String sNumeroDocumento) {
		List<TrabajadorModel> lModelTrabajador = trabajadorTransform.transformEM(trabajadorRepository.findAll());
		
		if(!lModelTrabajador.isEmpty()) {
			lModelTrabajador = lModelTrabajador.stream().filter(s -> s.getsIdTipoDocumento().equals(sIdTipoDocumento) && s.getsNumeroDocumento().equals(sNumeroDocumento)).collect(Collectors.toList());
			
			return lModelTrabajador.isEmpty() ? null : lModelTrabajador.get(0);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void registrarTrabajador(UsuarioTrabajadorForm trabajador) {
		TrabajadorModel oModel = trabajadorTransform.transformFM(trabajador);
		trabajadorRepository.save(trabajadorTransform.transformME(oModel));
	}

}
