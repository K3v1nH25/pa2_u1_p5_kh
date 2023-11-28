package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	private static Integer acumularTransferencias = 0;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
 
	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}
 
	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);
	}
 
	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}
 
	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);
	}
 
	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
				//1. Buscar cuenta origen
				CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.seleccionar(numeroOrigen);
				//2. Consultar saldo
				BigDecimal saldoOrigen = ctaOrigen.getSaldo();
				//3. validar saldo
				if(saldoOrigen.compareTo(monto)>=0) {
				//4. restar monto	
					BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
				//5. Actualizar cuenta origen
					ctaOrigen.setSaldo(nuevoSaldoOrigen);
					this.iCuentaBancariaRepository.actualizar(ctaOrigen);
				//6. Buscar cuenta destino
					CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.seleccionar(numeroDestino);
				//7. Consultar  saldo
					BigDecimal saldoDestino = ctaDestino.getSaldo();
				//8. Sumar monto
					BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
				//9. actualizar cuenta destino
					ctaDestino.setSaldo(nuevoSaldoDestino);
					this.iCuentaBancariaRepository.actualizar(ctaDestino);
				//10. crear transferencia
					Transferencia transferencia = new Transferencia();
					transferencia.setCuentaOrigen(ctaOrigen);
					transferencia.setCuentaDestino(ctaDestino);
					transferencia.setFecha(LocalDateTime.now());
					transferencia.setMonto(monto);
					transferencia.setNumero("121212121");
					this.iTransferenciaRepository.insertar(transferencia);
					System.out.println("Transferencia realizada con exito");
					acumularTransferencias++;
					
				}else{
					System.out.println("Saldo no disponible");
				}
	}

	@Override
	public List<Transferencia> mostrarTodas() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionarTodo();
	}

	@Override
	public Integer numeroTransferencias() {
		// TODO Auto-generated method stub
		return acumularTransferencias;
	}




 
}