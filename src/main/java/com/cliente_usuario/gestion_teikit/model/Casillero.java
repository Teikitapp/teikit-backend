package com.cliente_usuario.gestion_teikit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "casillero")
public class Casillero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private int numero;

    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "estado_casillero")
    private int estadoCasillero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public int getEstadoCasillero() {
        return estadoCasillero; //1:DISPONIBLE 2:NO DISPONIBLE
    }

    public void setEstadoCasillero(int estadoCasillero) {
        this.estadoCasillero = estadoCasillero;
    }
}
