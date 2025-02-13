package com.cliente_usuario.gestion_teikit.controller;


import com.cliente_usuario.gestion_teikit.model.Cliente;
import com.cliente_usuario.gestion_teikit.model.Usuario;
import com.cliente_usuario.gestion_teikit.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://www.teikit.cl")
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
    public Usuario guardarUsuarios(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
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
