package com.cliente_usuario.gestion_teikit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class PedidoDetallePK {

    @Column(name = "pedido_id")
    private long pedidoId;

    @Column(name = "producto_id")
    private long productoId;

}
