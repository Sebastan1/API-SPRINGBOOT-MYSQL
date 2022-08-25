package com.gestion.productos.gestiondeproductos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.productos.gestiondeproductos.modelo.Productos;
import com.gestion.productos.gestiondeproductos.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio repositorio;

    public List<Productos> listarProductos(){
        return repositorio.findAll();
    }
    public void guardarProducto(Productos producto){
        repositorio.save(producto);
    }
    public Productos obtenerProducto(Integer id){
        return repositorio.findById(id).get();
    }
    public void eliminarProducto(Integer id){
        repositorio.deleteById(id);
    }
}
