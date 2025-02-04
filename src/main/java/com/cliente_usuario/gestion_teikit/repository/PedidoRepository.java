package com.cliente_usuario.gestion_teikit.repository;

import com.cliente_usuario.gestion_teikit.model.Casillero;
import com.cliente_usuario.gestion_teikit.model.Dto.PedidosDto;
import com.cliente_usuario.gestion_teikit.model.Pedido;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(
            value="Select * from pedido where estado LIKE %:status% && id_usuario LIKE %:idCliente%",
            nativeQuery = true
    )
    List<Pedido> findByStatus(int status, int idCliente);

    @Query(
            value="Select * from pedido where estado in (2,3) && id_usuario  =:idCliente",
            nativeQuery = true
    )
    List<Pedido> findByStatus2(int idCliente);

    @Query(
            value="UPDATE pedido SET estado = 2 WHERE estado LIKE %:idUsuario% && id LIKE %:id%  ",
            nativeQuery = true
    )
    List<Pedido> actualizarStatus(int idUsuario, int id);

    @Query(
            value="select  " +
                    "p.id as id, " +
                    "p.fecha_creacion as fechaIngresadoPedido, " +
                    "p.fecha_retira_pedido as fechaRetiraPedido, " +
                    "p.hora_retira_pedido as horaRetiraPedido, " +
                    "p.lugar_retira_pedido as lugarRetiraPedido, " +
                    "p.casillero as casillero, " +
                    "p.estado as status,  " +
                    "p.id_usuario as idUsuario, " +
                    "p.estado_compra as estadoCompra, " +
                    "p.id_compra as idCompra " +
                    "from pedido p "+
                    "where p.estado in (2,3,4) " ,
            nativeQuery = true
    )
    List<PedidosDto> getPedidosYdetalle(int idcliente);

    /*@Query(
            value="Select * from pedido where status = %:status% && id_cliente = %:id%",
            nativeQuery = true
    )
    List<Pedido> findByStatus(int id, int status);*/

}
