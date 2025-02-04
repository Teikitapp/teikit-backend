package com.cliente_usuario.gestion_teikit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido implements Serializable {

  /*@EmbeddedId
  private PedidoDetallePK id;*/


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int cantidad;

    @Column(name = "precio_unidad")
    private long unitPrice;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "id_usuario")
    private long idUsuario;

     @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "estado_detalle_pedido")
    private int estadoDetallePedido;
    //0: PENDIENTE, 1: EN_PROCESO, 2: COMPLETADO, 3: CANCELADO

    @Column(name = " id_pedido")
    private long idPedido;



    /*@ManyToOne
    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    @MapsId("pedidoId")*/
    //private Pedido pedido;


    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public int getEstadoDetallePedido() {
        return estadoDetallePedido;
    }

    public void setEstadoDetallePedido(int estadoDetallePedido) {
        this.estadoDetallePedido = estadoDetallePedido;
    }
}
