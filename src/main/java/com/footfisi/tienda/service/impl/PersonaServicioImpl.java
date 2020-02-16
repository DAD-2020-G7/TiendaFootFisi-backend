package com.footfisi.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.PersonaModel;
import com.footfisi.tienda.repository.RepositoryPersona;
import com.footfisi.tienda.service.inter.PersonaServicio;
import com.footfisi.tienda.transform.PersonaTransform;
import com.footfisi.tienda.transform.PersonaUsuarioTransform;

@Service("personaService")
public class PersonaServicioImpl implements PersonaServicio{
	@Autowired
	@Qualifier("personaRepository")
	private RepositoryPersona personaRepository;
	@Autowired
	@Qualifier("personaTransform")
	private PersonaTransform personaTransform;
	@Autowired
	@Qualifier("personaUsuarioTransform")
	private PersonaUsuarioTransform personaUsuarioTransform;
	
	@Override
	public void registrarPersonaCliente(UsuarioClienteForm cliente) {
		PersonaModel oModelPersona = personaUsuarioTransform.transformFM(cliente);
		personaRepository.save(personaTransform.transformME(oModelPersona));
	}

}
