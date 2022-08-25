package com.gestion.productos.gestiondeproductos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.productos.gestiondeproductos.modelo.Productos;

public interface ProductoRepositorio extends JpaRepository<Productos,Integer>{

}