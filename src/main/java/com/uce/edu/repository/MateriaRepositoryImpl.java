package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;

@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {
	
	private static List<Materia> base = new ArrayList<Materia>();

	@Override
	public Materia seleccionar(String codigo) {
		// TODO Auto-generated method stub
		System.out.println("seleccionanos el codigo "+codigo);
		
		for(Materia ma: base) {
			if(ma.getCodigo().equals(codigo)) 
				return ma;
			
				return null;
			
		}
	
		return new Materia();
	}

	@Override
	public void insetar(Materia materia) {
		// TODO Auto-generated method stub
		base.add(materia);
		System.out.println("Se inserto "+materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.borrar(materia.getCodigo());
		this.insetar(materia);
		System.out.println("Se actualiza: "+materia);
	}

	@Override
	public void borrar(String codigo) {
		// TODO Auto-generated method stub
		Materia mate = this.seleccionar(codigo);
		base.remove(mate);
		System.out.println("Se borra: "+codigo);
	}

	@Override
	public List<Materia> seleccionarTodos() {
		// TODO Auto-generated method stub
		return base;
	}


}
