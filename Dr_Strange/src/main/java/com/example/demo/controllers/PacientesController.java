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
	PacienteRepository repository;

	@GetMapping
	public Collection<Pacientes> getListPacientes() {
		Iterable<Pacientes> ListPacientes = repository.findAll();
		return (Collection<Pacientes>) ListPacientes;
	}

	@PutMapping(value = "/{id}")
	public Pacientes editPaciente(@PathVariable(name = "id") Long id, @RequestBody Pacientes pacientesR) {
		Optional<Pacientes> pacienteM = repository.findById(id);
		if (pacienteM.isPresent()) {
			Pacientes actual = pacienteM.get();
			actual.setId(pacientesR.getId());
			actual.setEdad(pacientesR.getEdad());
			actual.setNombre(pacientesR.getNombre());
			Pacientes newPaciente = repository.save(actual);
			return newPaciente;

		}
		return null;
	}

	@GetMapping(value = "/{id}")
	public Pacientes getPaciente(@PathVariable(name = "id") Long id) {
		Optional<Pacientes> pacientesR = repository.findById(id);
		Pacientes obtenerP = null;
		if (pacientesR.isPresent()) {
			obtenerP = pacientesR.get();
		}
		return obtenerP;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}

}
