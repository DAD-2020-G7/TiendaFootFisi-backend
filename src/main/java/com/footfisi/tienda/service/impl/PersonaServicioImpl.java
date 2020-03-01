package com.footfisi.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.form.UsuarioTrabajadorForm;
import com.footfisi.tienda.model.PersonaModel;
import com.footfisi.tienda.repository.RepositoryPersona;
import com.footfisi.tienda.service.inter.PersonaServicio;
import com.footfisi.tienda.transform.PersonaTransform;
import com.footfisi.tienda.transform.PersonaUsuarioClienteTransform;
import com.footfisi.tienda.transform.PersonaUsuarioTrabajadorTransform;

@Service("personaService")
public class PersonaServicioImpl implements PersonaServicio{
	@Autowired
	@Qualifier("personaRepository")
	private RepositoryPersona personaRepository;
	@Autowired
	@Qualifier("personaTransform")
	private PersonaTransform personaTransform;
	@Autowired
	@Qualifier("personaUsuarioClienteTransform")
	private PersonaUsuarioClienteTransform personaUsuarioClienteTransform;
	@Autowired
	@Qualifier("personaUsuarioTrabajadorTransform")
	private PersonaUsuarioTrabajadorTransform personaUsuarioTrabajadorTransform;
	
	@Override
	public void registrarPersonaCliente(UsuarioClienteForm cliente) {
		PersonaModel oModelPersona = personaUsuarioClienteTransform.transformFM(cliente);
		personaRepository.save(personaTransform.transformME(oModelPersona));
	}

	@Override
	public void registrarPersonaTrabajador(UsuarioTrabajadorForm trabajador) {
		PersonaModel oModelPersona = personaUsuarioTrabajadorTransform.transformFM(trabajador);
		personaRepository.save(personaTransform.transformME(oModelPersona));
	}

}
