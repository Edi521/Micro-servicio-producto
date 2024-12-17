package com.mx.ProductoMS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProductoMS.Dominio.Producto;

//Esta intefez nos permite hacer nuestras operaciones CRUD y realizar peticiones SQL personalizadas

public interface IProductoDao extends JpaRepository<Producto, Integer>{

	
	//Perticion SQL Personalizada, para buscar por nombre
	public Producto findByNombreIgnoringCaseContaining(String nombre);
	
}
