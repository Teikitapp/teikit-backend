package com.cliente_usuario.gestion_teikit.controller;

import com.cliente_usuario.gestion_teikit.exception.ResourceNotFoundException;
import com.cliente_usuario.gestion_teikit.model.Casillero;
import com.cliente_usuario.gestion_teikit.model.Cliente;
import com.cliente_usuario.gestion_teikit.model.Pedido;
import com.cliente_usuario.gestion_teikit.repository.CasilleroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "https://teikit-frontend.up.railway.app")
@RestController
@RequestMapping("/api/casillero")
public class CasilleroController {

    @Autowired
    CasilleroRepository casilleroRepository;

    @GetMapping("/listarCasilleros")
    public List<Casillero> listarCasilleros(){
        return casilleroRepository.findAll();
    }
    @GetMapping("/buscarCasilleroDisponible")
    public int buscarCasilleroDisponible(){
        List<Casillero> lista = new ArrayList<>();
         lista = casilleroRepository.findAll();
         int r = 0;

         for (int i = 0; i <= lista.size(); i++){
             if (lista.get(i).getEstadoCasillero() == 1) {
                 r = lista.get(i).getNumero();
                 break;
             }
         }
       return r;
    }

    @PostMapping("/guardarCasillero")
    public Casillero guardarCasilleros(@RequestBody Casillero casillero){
        return casilleroRepository.save(casillero);
    }

    @PutMapping("/actualizarEstadoCasillero/{idCasillero}-{nuevoEstado}")
    public ResponseEntity<Casillero> actualizarestadoCasillero(@PathVariable long idCasillero, @PathVariable int nuevoEstado){
        Casillero casillero = casilleroRepository.findById(idCasillero)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese ID no existe " + idCasillero));

       casillero.setEstadoCasillero(nuevoEstado);
       Casillero c = casilleroRepository.save(casillero);


       if (nuevoEstado==4) {

           String url = "http://localhost:8080/MiProyecto/actualizar?casillero="+nuevoEstado;

           try {
               URLConnection conn = new URL(url).openConnection();
               try (InputStream stream = conn.getInputStream();
                    Scanner sc = new Scanner(stream, "UTF-8")) {
                   sc.useDelimiter("\\A");
                   if (sc.hasNext()) {
                       System.out.printf("Respuesta: %s", sc.next());
                   }
               }
           } catch (MalformedURLException e) {
               Logger.getAnonymousLogger().log(Level.SEVERE, "URL error", e);
           } catch (IOException e) {
               Logger.getAnonymousLogger().log(Level.SEVERE, "IO error", e);
           }
       }

       return ResponseEntity.ok(c);
    }




}
