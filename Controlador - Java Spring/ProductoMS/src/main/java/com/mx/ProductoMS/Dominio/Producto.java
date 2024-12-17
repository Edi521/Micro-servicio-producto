package com.mx.ProductoMS.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//En esta clase es donde definiremos nuestra entidad producto y hacemos referencia a la tabla producto de nuestra BD

@Entity //Diciendo que nuestra clase es una entidad de BD

@Table(name = "PRODUCTO") //Hacemos referencia a nuestra tabla PRODUCTO


//En esta parte se hace uso de la dependencia loombok esto para no escribir codigo repititivo y poder generar contructor, metodo toString, getter y setter de nuestra clase Producto
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Producto {

	//En esta parte se esta describiendo los atributos de nuestra entidad producto
	
	@Id
	@Column
	private int idProducto;
	
	@Column
	private String nombre;
	
	@Column
	private float precio;
	
	@Column
	private String descripcion;
	
	@Column
	private int stock;
	
	
	
}
