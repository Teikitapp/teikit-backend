package com.cliente_usuario.gestion_teikit.repository;

import com.cliente_usuario.gestion_teikit.model.Casillero;
import com.cliente_usuario.gestion_teikit.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasilleroRepository extends JpaRepository<Casillero, Long>  {

    @Modifying(clearAutomatically = true)
    @Query(
            value="UPDATE casillero SET estado_casillero = 2 WHERE numero =:numeroCasillero",
            nativeQuery = true
    )
    List<Casillero> findByNumeroCasillero(int numeroCasillero);

    List<Casillero> findById(int numeroCasillero);
}
