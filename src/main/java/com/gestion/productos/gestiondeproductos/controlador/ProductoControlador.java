package com.gestion.productos.gestiondeproductos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.gestion.productos.gestiondeproductos.modelo.Productos;
import com.gestion.productos.gestiondeproductos.servicios.ProductoServicio;

@Controller
public class ProductoControlador {
    @Autowired
    private ProductoServicio servicio;

    @GetMapping(path = "/productos")
    public @ResponseBody List<Productos> listarProductos(){
        return servicio.listarProductos();
    }
    @GetMapping(path = "/productos/{id}")
    public ResponseEntity obtenerProducto(@PathVariable Integer id){
        try{
            Productos productos = servicio.obtenerProducto(id);
            return new ResponseEntity<Productos>(productos,HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(path="/productos")
    public void guardarProducto(@RequestBody Productos productos){
        servicio.guardarProducto(productos);
    }
    @PutMapping(path="/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Productos productos, @PathVariable Integer id){
        try{
            Productos productosExistentes = servicio.obtenerProducto(id);
            productosExistentes.setCantidad(productos.getCantidad());
            productosExistentes.setEmail(productos.getEmail());
            productosExistentes.setNombre(productos.getNombre());
            productosExistentes.setPrecio(productos.getPrecio());
            servicio.guardarProducto(productosExistentes);
            return new ResponseEntity<Productos>(HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(path="/productos/{id}")
    public void eliminarProductos(@PathVariable Integer id){
        servicio.eliminarProducto(id);
    }
}
