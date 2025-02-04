package com.cliente_usuario.gestion_teikit.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   //@ManyToOne
   // @JoinColumn(name = "id_cliente")
    private long idCliente;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "precio_unidad_producto")
    private int precioUnidad;

    private String categoria;
    private String descripcion;

    /*@Column(name = "foto")
    private int foto;*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
