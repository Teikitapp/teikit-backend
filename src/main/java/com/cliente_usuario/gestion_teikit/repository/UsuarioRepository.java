package com.cliente_usuario.gestion_teikit.repository;


import com.cliente_usuario.gestion_teikit.model.Cliente;
import com.cliente_usuario.gestion_teikit.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(
            value="Select * from usuarios where pass_usuario = :pass && email = :user",
            nativeQuery = true
    )
    List<Usuario> findByPassUser(String user, String pass);
}
