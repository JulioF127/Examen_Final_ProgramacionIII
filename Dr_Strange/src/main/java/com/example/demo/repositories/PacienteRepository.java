package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Pacientes;

public interface PacienteRepository extends CrudRepository<Pacientes, Long> {

}
