package com.cliente_usuario.gestion_teikit.model.Dto;

import com.cliente_usuario.gestion_teikit.model.DetallePedido;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
//@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Get
@Set    
public class PedidosDto {
    private long id;
    private String fechaIngresadoPedido;
    private String fechaRetiraPedido;
    private String horaRetiraPedido;
    private String lugarRetiraPedido;
    private int casillero;
    private int status;
    // 1: EN_PROCESO, 2: PAGADO(pagado), 3: EN_CASILLERO(listo para retiro), 4:ENTREGADO
    private long idUsuario;
    private int estadoCompra;
    private long idCompra;
    private long idCliente;
    List<DetallePedidoDto> dPedido;


}
