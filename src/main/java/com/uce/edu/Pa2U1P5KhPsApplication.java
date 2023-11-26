package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5KhPsApplication implements CommandLineRunner {
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5KhPsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Crear las cuentas
				CuentaBancaria ctaOrigen = new CuentaBancaria();
				ctaOrigen.setCedulaPropiertrio("1724693112");
				ctaOrigen.setNumero("1234");
				ctaOrigen.setSaldo(new BigDecimal(100));
				
				this.iCuentaBancariaService.guardar(ctaOrigen);
				CuentaBancaria ctaDestino = new CuentaBancaria();
				ctaDestino.setCedulaPropiertrio("1724691212");
				ctaDestino.setNumero("5678");
				ctaDestino.setSaldo(new BigDecimal(2));
				
				this.iCuentaBancariaService.guardar(ctaDestino);
				
				this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(20));
				CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
				System.out.println(ctaOrigen1);
				
				CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("5678");
				System.out.println(ctaDestino1);
	}

}
