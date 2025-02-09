package com.cliente_usuario.gestion_teikit.controller;


import com.cliente_usuario.gestion_teikit.exception.ResourceNotFoundException;
import com.cliente_usuario.gestion_teikit.model.Cliente;
import com.cliente_usuario.gestion_teikit.model.Producto;
import com.cliente_usuario.gestion_teikit.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://teikit-frontend.up.railway.app")
@RestController
@RequestMapping("/api/data")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    @PostMapping("/guardarClientes")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> listarClientePorId (@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese ID no existe " + id));

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCliente (@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese ID no existe " + id));

        clienteRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/buscarClienteUserPass")
    public List<Cliente> buscarClienteUserPass(@RequestBody Cliente cliente){

        String Npass = cliente.getPassCliente();
        String Nemail = cliente.getEmail();
        List<Cliente> c = new ArrayList<>();

        List<Cliente> lista= new ArrayList<>();


        lista = clienteRepository.findByPassUser(Nemail, Npass);


        return lista;


    }
}
