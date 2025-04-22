package com.cliente_usuario.gestion_teikit.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompararHorarioDto {

    String hora;
    int horaInteger;

    public void push(String hora) {
    }
}
