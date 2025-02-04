package com.cliente_usuario.gestion_teikit.repository;

import com.cliente_usuario.gestion_teikit.model.Dto.PedidosDto;
import com.cliente_usuario.gestion_teikit.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositoryCustomer extends JpaRepository<Pedido, Long> {

    @Query(
            value="select p.*  " +
                    "from pedido p where p.id_cliente = :idcliente and p.estado > 1 and p.fecha_retira_pedido =:fecha",
            nativeQuery = true
    )
    List<Pedido> getPedidosYdetalle(int idcliente, String fecha);

}
