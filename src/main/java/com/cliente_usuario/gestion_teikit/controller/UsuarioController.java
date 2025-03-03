package com.cliente_usuario.gestion_teikit.controller;


import com.cliente_usuario.gestion_teikit.model.Cliente;
import com.cliente_usuario.gestion_teikit.model.Usuario;
import com.cliente_usuario.gestion_teikit.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "${frontend.api.url}")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @PostMapping("/guardarUsuarios")
    public String guardarUsuarios(@RequestBody Usuario usuario) {
        List<Usuario> u = usuarioRepository.findByUser(usuario.getEmail());
        String resp = null;
        try {
            if(u.size() > 0){
                resp = "Usuario ya existe";
            }else {
             Usuario l =   usuarioRepository.save(usuario);
                resp = "Usuario ingresado con éxito";
            }
        }catch (Exception e){
            System.out.println(e);
            resp = e.getMessage();
        }
        return resp;
    }

    @PostMapping("/buscarUsuarioUserPass")
    public List<Usuario> buscarUsuarioUserPass(@RequestBody Usuario usuario){

        String Npass = usuario.getPassUsuario();
        String Nemail = usuario.getEmail();
        List<Usuario> c = new ArrayList<>();

        //int resp = 0;

        c = usuarioRepository.findByPassUser(Nemail, Npass);

        /*if(c.size() > 0){
            resp = 1;
        }else {resp = 0;}*/

        return c;


    }

}
