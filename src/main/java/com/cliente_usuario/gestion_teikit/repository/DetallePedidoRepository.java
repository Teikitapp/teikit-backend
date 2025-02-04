package com.cliente_usuario.gestion_teikit.repository;

import com.cliente_usuario.gestion_teikit.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    @Query(
            value="UPDATE detalle_pedido SET estado_detalle_pedido = 2 WHERE  id_pedido LIKE %:idPedido% && id_usuario LIKE %:idUsuario%",
            nativeQuery = true
    )
    List<DetallePedido> findByStatus(long idPedido, long idUsuario);

    @Query(
            value="select * from detalle_pedido  WHERE  id_pedido = :idPedido && id_usuario = :idUsuario",
            nativeQuery = true
    )
    List<DetallePedido> findByPedidoUsuario(long idPedido, long idUsuario);
}
