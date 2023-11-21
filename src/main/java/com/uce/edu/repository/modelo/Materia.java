package com.uce.edu.repository.modelo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Materia {
	private String nombre;
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", codigo=" + codigo + ", numeroCreditos=" + numeroCreditos + "]";
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNumeroCreditos() {
		return numeroCreditos;
	}
	public void setNumeroCreditos(String numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	private String  codigo;
	private String numeroCreditos;
}
