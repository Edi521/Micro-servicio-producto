package com.mx.ProductoMS.Service;

import java.util.List;

import com.mx.ProductoMS.Dominio.Producto;


//En esta interfaz se esta haciendo la plantilla de cuales son nuestras funciones que se deben implementar si o si

public interface IProductoService {

	public void guardar(Producto producto);
	
	public void editar(Producto producto);
	
	public void eliminar(int id);
	
	public Producto buscar(int id);
	
	public List<Producto> lista();
	
	
}
