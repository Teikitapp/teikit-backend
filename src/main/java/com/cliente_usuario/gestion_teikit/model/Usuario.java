package com.cliente_usuario.gestion_teikit.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombreApellido")
    private String nombreApellido;


    @Column(name = "email")
    private String email;

    @Column(name = "pass_usuario")
    private String passUsuario;

    public String getNombreApellido() {
        return nombreApellido;
    }



    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
}
