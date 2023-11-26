package com.uce.edu.transferencia.repository.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CuentaBancaria {
	private String numero;
	private String cedulaPropiertrio;
	private BigDecimal saldo;
	
	//Getters and setters 
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCedulaPropiertrio() {
		return cedulaPropiertrio;
	}
	public void setCedulaPropiertrio(String cedulaPropiertrio) {
		this.cedulaPropiertrio = cedulaPropiertrio;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	//toString
	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", cedulaPropiertrio=" + cedulaPropiertrio + ", saldo=" + saldo
				+ "]";
	}


}
