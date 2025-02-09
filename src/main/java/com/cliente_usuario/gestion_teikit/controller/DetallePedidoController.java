package com.cliente_usuario.gestion_teikit.controller;

import com.cliente_usuario.gestion_teikit.exception.ResourceNotFoundException;
import com.cliente_usuario.gestion_teikit.model.Casillero;
import com.cliente_usuario.gestion_teikit.model.DetallePedido;
import com.cliente_usuario.gestion_teikit.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://teikit-frontend.up.railway.app")
@RestController
@RequestMapping("/api/detallePedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @PostMapping("/ingresarDetallePedido")
    public DetallePedido ingresarDetallePedido (@RequestBody DetallePedido detallePedido){
        return detallePedidoRepository.save(detallePedido);
    }

    @GetMapping("/obtenerDetallesPedidos")
    public List<DetallePedido> listarDetallePedido (){
        return detallePedidoRepository.findAll();
    }

    /*@PutMapping("/actualizarDetallePedido/{idDetalleP}-{idUsuario}--{nuevoEstado}")
    public ResponseEntity<DetallePedido> actualizarestadoCasillero(@PathVariable long idDetalleP, @PathVariable long idUsuario, @PathVariable int nuevoEstado){
        DetallePedido detallePedido = detallePedidoRepository.findById(idDetalleP)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese ID no existe " + idDetalleP));

        detallePedido.setEstadoDetallePedido(nuevoEstado);
        DetallePedido d = detallePedidoRepository.save(detallePedido);

        return ResponseEntity.ok(d);
    }*/


}
