package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pacientes;
import com.example.demo.repositories.PacienteRepository;

@RestController
@RequestMapping(value = "/Paciente")
public class PacientesController {

	@Autowired
	PacienteRepository repositorio;

	@GetMapping
	public Collection<Pacientes> getListadoPacientes() {
		Iterable<Pacientes> ListadoPacientes = repositorio.findAll();
		return (Collection<Pacientes>) ListadoPacientes;
	}

	@PutMapping(value = "/{id}")
	public Pacientes editarPaciente(@PathVariable(name = "id") Long id, @RequestBody Pacientes pacientesR) {
		Optional<Pacientes> pacienteM = repositorio.findById(id);
		if (pacienteM.isPresent()) {
			Pacientes actual = pacienteM.get();
			actual.setId(pacientesR.getId());
			actual.setEdad(pacientesR.getEdad());
			actual.setNombres(pacientesR.getNombres());
			Pacientes pacienteModificado = repositorio.save(actual);
			return pacienteModificado;

		}
		return null;
	}

	@GetMapping(value = "/{id}")
	public Pacientes getPacientes(@PathVariable(name = "id") Long id) {
		Optional<Pacientes> pacientesR = repositorio.findById(id);
		Pacientes mostrar = null;
		if (pacientesR.isPresent()) {
			mostrar = pacientesR.get();
		}
		return mostrar;
	}

	@DeleteMapping(value = "/{id}")
	public void borrar(@PathVariable(name = "id") Long id) {
		repositorio.deleteById(id);
	}

}
