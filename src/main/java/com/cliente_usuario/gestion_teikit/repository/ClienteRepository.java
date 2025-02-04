package com.cliente_usuario.gestion_teikit.repository;

import com.cliente_usuario.gestion_teikit.model.Cliente;
import com.cliente_usuario.gestion_teikit.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(
            value="Select * from clientes where pass_cliente =:pass && email =:user",
            nativeQuery = true
    )
    List<Cliente> findByPassUser(String user,String pass);
}
