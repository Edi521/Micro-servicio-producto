package com.mx.ProductoMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.ProductoMS.Dao.IProductoDao;
import com.mx.ProductoMS.Dominio.Producto;


//En esta clase estan implementado todas nuestras funciones de IProductoService

@Service //La notacion indica que la clase conforma la capa de servicio

public class ProductoServiceImp implements IProductoService{

	//Esta instruccion nos permite acceder a los metodos crud que se heredan de JpaRepository
	@Autowired
	private IProductoDao dao;

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		dao.save(producto);
	}

	@Override
	public void editar(Producto producto) {
		// TODO Auto-generated method stub
		dao.save(producto);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Producto buscar(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> lista() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idProducto"));  //Estamos usando sort para enlistar nustra informacion de forma ascendente por id
	}
	
	
	//personalizados
	
	public boolean byNombre(String nombre) {
		Producto encontrado = dao.findByNombreIgnoringCaseContaining(nombre);
		if(encontrado != null) {
			return true;
		}else {
			return false;
		}
	}
	

}
