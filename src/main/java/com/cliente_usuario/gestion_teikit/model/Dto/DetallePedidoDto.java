package com.cliente_usuario.gestion_teikit.model.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetallePedidoDto {
     long id;
     int cantidad;
     long unitPrice;
     String nombreProducto;
     long idUsuario;
     long idCliente;
     int estadoDetallePedido;
     long idPedido;
}
