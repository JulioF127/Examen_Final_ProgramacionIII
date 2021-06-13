package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Cita")
public class Citas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "hora")
	private String hora;
	@Column(name = "paciente")
	private String paciente;
	@Column(name = "estado")
	private String estado;
	@Column(name = "observaciones")
	private String observaciones;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
}
