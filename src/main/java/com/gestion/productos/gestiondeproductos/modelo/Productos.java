package com.gestion.productos.gestiondeproductos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Float precio;
	private String email;
	private Integer cantidad;

	public Productos(Integer id, String nombre, Float precio, String email, Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.email = email;
		this.cantidad = cantidad;
	}
	public Productos(String nombre, Float precio, String email, Integer cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.email = email;
		this.cantidad = cantidad;
	}
	public Productos() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
