package com.mx.ProductoMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ProductoMS.Dominio.Producto;
import com.mx.ProductoMS.Service.ProductoServiceImp;

//@CrossOrigin  //Esta notacion  nos permite que nuestro web service reciva peticiones HTTP, se comento ya que se conecto con nuestra ApiGateway

@RestController //La notacion hace referncia que nuestra api es de tipo REST

@RequestMapping(path = "/api/products") //Asignando direccion para acceder a nuestra api



public class ProductoWS {
	
	//Nos permite acceder a todas nuestras funcionalidades de nuestra capa de servicios
	@Autowired
	private ProductoServiceImp service;
	
	//URL------------------------------------>  http://localhost:8005/api/products               Esta sera la url para acceder a nuestro Web Service
	
	
	//Se utiliza ResponseEntity para el manejo de errores
	
	
	//Peticion para listar-----------------------------------> http://localhost:8005/api/products
	@GetMapping()
	public ResponseEntity<?> listar(){
		List<Producto> productos = service.lista();
		if(productos.isEmpty()) {//-------------------------------> verificando el estado de nuestra lista (vacio o contiene algo)
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.ok(productos);
		}
	}
	
	
	//Peticon para crear producto------------------------------------> http://localhost:8005/api/products
	@PostMapping()
	public ResponseEntity<?> crear(@RequestBody Producto producto){
		Producto encontrado = service.buscar(producto.getIdProducto());
		
		if(encontrado != null) {//--------------------------------------------------------------------------------------------------------> verificamos si el id existe
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"Ya existe el id "+producto.getIdProducto()+"\"}");
		}else {
			if(service.byNombre(producto.getNombre())==true) {//-------------------------------------------------------------------------------> verificamos que si el nombre existe
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El producto "+producto.getNombre()+" ya existe\"}");
			}else {
				if(producto.getPrecio() > 0) {//-------------------------------------------------------------------------------------------> verificamos que nuestro precio sea mayor a cero
					service.guardar(producto);
					return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Se guardo el producto "+producto.getNombre()+"\"}");
				}else {
					return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El precio debe ser  mayor a cero\"}");
				}
				
			}
		}
	}
	
	
	//Peticion para buscar ------------------------------------------> http://localhost:8005/api/products/{idProducto}
	@GetMapping(value = "{idProducto}")
	public ResponseEntity<?> buscar(@PathVariable("idProducto") int idProducto){
		Producto encontrado = service.buscar(idProducto);
		if(encontrado == null) {//----------------------------------------------------> verificamos que exista nuestro producto
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	
	//Peticion para eliminra-------------------------------------------------> http://localhost:8005/api/products/{idProducto}
	@DeleteMapping(value = "{idProducto}")
	public ResponseEntity<?> eliminar(@PathVariable int idProducto){
		Producto encontrado = service.buscar(idProducto);
		if(encontrado == null) {//-------------------------------------------> verificamos que nuestro producto exista
			return ResponseEntity.notFound().build();
		}else {
			service.eliminar(idProducto);
			return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Se elimo el producto "+encontrado.getNombre()+"\"}");
		}
	}
	
	
	//Peticion para editar--------------------------------------------------------------> http://localhost:8005/api/products/editar
	@PutMapping(value = "/editar")
	public ResponseEntity<?> actualizar(@RequestBody Producto producto){
		Producto encontrado = service.buscar(producto.getIdProducto());
		if(encontrado == null) {//------------------------------------------------------------> verificamos que le id exista
			return ResponseEntity.notFound().build();
		}else {
			if(producto.getPrecio() > 0) {//-------------------------------------------------> verificamos que el precio sea mayor a cero
				service.editar(producto);
				return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Se edito el id " + producto.getIdProducto() +"\"}");
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El precio debe ser mayor a cero\"}");
			}
			
		}
	}
	

}
