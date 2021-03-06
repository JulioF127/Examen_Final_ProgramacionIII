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

import com.example.demo.entities.Citas;
import com.example.demo.repositories.CitasRepository;

@RestController
@RequestMapping("/Cita")
public class CitasController {

	@Autowired
	CitasRepository repositorio;

	@GetMapping
	public Collection<Citas> getListCitas() {
		Iterable<Citas> ListCitas = repositorio.findAll();
		return (Collection<Citas>) ListCitas;
	}
	@PutMapping(value = "/{id}")
	public Citas editCita(@PathVariable(name = "id") Long id, @RequestBody Citas citaR) {
		Optional<Citas> citaM = repositorio.findById(id);
		if (citaM.isPresent()) {
			Citas act = citaM.get();
			act.setFecha(citaR.getFecha());
			act.setHora(citaR.getHora());
			act.setPaciente(citaR.getPaciente());
			act.setEstado(citaR.getEstado());
			act.setObservaciones(citaR.getObservaciones());
			act.setId(citaR.getId());
			Citas nuevaCita = repositorio.save(act);
			return nuevaCita;

		}
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public void deleteCita(@PathVariable(name = "id") Long id) {
		repositorio.deleteById(id);

	}

	@GetMapping(value = "/{id}")
	public Citas getCita(@PathVariable(name = "id") Long id) {
		Optional<Citas> cita = repositorio.findById(id);
		Citas obtenerC = null;
		if (cita.isPresent()) {
			obtenerC = cita.get();

		}
		return obtenerC;

	}
}
