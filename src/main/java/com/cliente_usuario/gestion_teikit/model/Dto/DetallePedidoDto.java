package com.cliente_usuario.gestion_teikit.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetallePedidoDto {
    private long id;
    private int cantidad;
    private long unitPrice;
    private String nombreProducto;
    private long idUsuario;
    private long idCliente;
    private int estadoDetallePedido;
    private long idPedido;
}
