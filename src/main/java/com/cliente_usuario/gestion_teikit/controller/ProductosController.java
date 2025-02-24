package com.cliente_usuario.gestion_teikit.controller;

import com.cliente_usuario.gestion_teikit.exception.ResourceNotFoundException;
import com.cliente_usuario.gestion_teikit.model.Producto;
import com.cliente_usuario.gestion_teikit.model.Usuario;
import com.cliente_usuario.gestion_teikit.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "${frontend.api.url}")
@RestController
@RequestMapping("/api/producto")
public class ProductosController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/listarProductos")
    public List<Producto> listarProductos(){
       return productoRepository.findAll();
    }

    @PostMapping("/guardarProducto")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarProducto (@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese ID no existe " + id));

        productoRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/actualizarProducto/{id}")
    public ResponseEntity<Producto>  actualizarCliente (@PathVariable Long id, @RequestBody Producto productoRequest){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con ese ID no existe " + id));

        producto.setNombre(productoRequest.getNombre());
        producto.setPrecioUnidad(productoRequest.getPrecioUnidad());
        producto.setCategoria(productoRequest.getCategoria());
        producto.setIdCliente(productoRequest.getIdCliente());

        Producto productoActualizado = productoRepository.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }
}
