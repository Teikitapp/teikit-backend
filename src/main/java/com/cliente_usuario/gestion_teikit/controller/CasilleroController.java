package com.cliente_usuario.gestion_teikit.controller;

import com.cliente_usuario.gestion_teikit.exception.ResourceNotFoundException;
import com.cliente_usuario.gestion_teikit.model.Casillero;
import com.cliente_usuario.gestion_teikit.repository.CasilleroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "${cors.allowed.origins}")
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
    public ResponseEntity<Casillero> actualizarestadoCasillero(@PathVariable long idCasillero, @PathVariable int nuevoEstado) {
        Casillero casillero = casilleroRepository.findById(idCasillero)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese ID no existe " + idCasillero));

        
        Casillero c = new Casillero();
        casillero.setEstadoCasillero(nuevoEstado);
        c = casilleroRepository.save(casillero);

        /*System.out.println("ANTES DEL IF PARA ENVIAR MENSAJE");
        System.out.println("ID id CASILLERO:" + idCasillero );
        System.out.println("ID ESTADO CASILLERO:" + nuevoEstado );
        if (nuevoEstado == 4) {
            try {
                URL object = new URL("https://nicely-valued-chimp.ngrok-free.app/locker/opening");

                HttpURLConnection con = (HttpURLConnection) object.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");
                con.setRequestProperty("Authorization", "Bearer 3nD9$KvzL9pYm2tQw#J6o@MxpG4R8");

                // Datos que deseas enviar en formato JSON
                 String data = "{\"casillero\":"+idCasillero+"}";

                // Obtenemos el OutputStream para agregar el json de la petición.
               try(OutputStream os = con.getOutputStream()) {
                    byte[] input = data.toString().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }catch (Exception e) {
                   e.printStackTrace();
               }

                System.out.println("ANTES DE LA CONEXION A URL");
                // Obtener la respuesta
                try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                    StringBuilder respuesta = new StringBuilder();
                    String acumuladorRespuesta = null;
                    while ((acumuladorRespuesta = br.readLine()) != null) {
                        respuesta.append(acumuladorRespuesta.trim());
                    }
                    System.out.println(respuesta.toString());
                    System.out.println("DENTRO DEL TRY");
                    System.out.println("Casillero "+idCasillero+" abierto");

                }
                casillero.setEstadoCasillero(4);
                c = casilleroRepository.save(casillero);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
        casillero.setEstadoCasillero(nuevoEstado);
        c = casilleroRepository.save(casillero);
        }*/

        

        return ResponseEntity.ok(c);
    }
}
