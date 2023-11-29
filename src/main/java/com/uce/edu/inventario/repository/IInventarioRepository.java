package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;

public interface IInventarioRepository {

	public Inventario seleccionar(String codigo);

	public void insertar(Inventario inventario);

	public void actualizar(Inventario inventario);

	public void eliminar(Inventario codigo);
}
