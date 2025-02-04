package com.cliente_usuario.gestion_teikit.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /* @Column(name = "fecha_creacion", insertable = true, updatable = false)
    @CreationTimestamp
    @Enumerated(EnumType.STRING)
    private LocalDateTime creationDate; */

    /*@Column(name = "fecha_creacion", insertable = true, updatable = false)
    @CreationTimestamp*/
    @Column(name = "fecha_creacion" , nullable=false, length = 12)
    private String fechaIngresadoPedido;

    @Column(name = "fecha_retira_pedido" , nullable=false, length = 12)
    private String fechaRetiraPedido;

    @Column(name = "hora_retira_pedido" , nullable=false, length = 12)
    private String horaRetiraPedido;

    @Column(name = "lugar_retira_pedido" , nullable=false, length = 200)
    private String lugarRetiraPedido;

    @Column(name = "casillero", nullable=false, length = 200)
    private int casillero;

    @Column(name = "estado", nullable=false, length = 1)
    private int status;
    // 1: EN_PROCESO, 2: PAGADO(pagado), 3: EN_CASILLERO(listo para retiro), 4:ENTREGADO

    @Column(name = "id_usuario" , nullable=false, length = 5)
    private long idUsuario;

    @Column(name = "estado_compra", length = 3)
    private int estadoCompra;

    @Column(name = "id_compra", length = 50)
    private long idCompra;

    @Column(name = "id_cliente", length = 50)
    private long idCliente;





   /* private OrderStatus status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<DetallePedido> details;

    public static enum OrderStatus{
        PENDIENTE,EN_PROCESO,COMPLETADO,CANCELADO;
    }*/

    public String getFechaIngresadoPedido() {
        return fechaIngresadoPedido;
    }

    public void setFechaIngresadoPedido(String fechaIngresadoPedido) {
        this.fechaIngresadoPedido = fechaIngresadoPedido;
    }

    public String getFechaRetiraPedido() {
        return fechaRetiraPedido;
    }

    public void setFechaRetiraPedido(String fechaRetiraPedido) {
        this.fechaRetiraPedido = fechaRetiraPedido;
    }

    public String getHoraRetiraPedido() {
        return horaRetiraPedido;
    }

    public void setHoraRetiraPedido(String horaRetiraPedido) {
        this.horaRetiraPedido = horaRetiraPedido;
    }

    public int getCasillero() {
        return casillero;
    }

    public void setCasillero(int casillero) {
        this.casillero = casillero;
    }

    public String getLugarRetiraPedido() {
        return lugarRetiraPedido;
    }

    public void setLugarRetiraPedido(String lugarRetiraPedido) {
        this.lugarRetiraPedido = lugarRetiraPedido;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(int estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }
}
