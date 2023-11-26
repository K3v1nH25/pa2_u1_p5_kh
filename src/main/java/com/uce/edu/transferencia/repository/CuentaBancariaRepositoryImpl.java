package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Repository
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

private static List<CuentaBancaria> base = new ArrayList();
	
	@Override
	public CuentaBancaria seleccionar(String numero) {
		// TODO Auto-generated method stub
		for (CuentaBancaria cuenta : base) {
			if (cuenta.getNumero().equals(numero)) {
				CuentaBancaria cta = new CuentaBancaria();
				cta.setCedulaPropiertrio(cuenta.getCedulaPropiertrio());
				cta.setNumero(cuenta.getNumero());
				cta.setSaldo(cuenta.getSaldo());
				return cta;
			}
		}
 
		return null;
	}
 
	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		base.add(cuentaBancaria);
	}
 
	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.eliminar(cuentaBancaria.getNumero());
		this.insertar(cuentaBancaria);
	}
 
	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		CuentaBancaria cuenta = this.seleccionar(numero);
		base.remove(cuenta);
	}
 
}
