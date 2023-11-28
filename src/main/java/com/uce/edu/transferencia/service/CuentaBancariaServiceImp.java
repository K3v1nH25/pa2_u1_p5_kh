package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImp implements ICuentaBancariaService {
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);

	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);

	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(numero);

	}

	@Override
	public void depositar(String numero, BigDecimal deposito) {
		// TODO Auto-generated method stub
		CuentaBancaria cta = this.bancariaRepository.seleccionar(numero);
		BigDecimal saldoOrigen = cta.getSaldo();
		cta.setSaldo(saldoOrigen.add(deposito.multiply(new BigDecimal(0.9f))));
		this.bancariaRepository.actualizar(cta);
		System.out.println("Deposito realizado con exito!");
		
	
		
	}

}
