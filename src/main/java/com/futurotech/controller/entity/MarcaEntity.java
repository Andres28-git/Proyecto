package com.futurotech.controller.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MarcaEntity {
 private String nombre;
 private LocalDateTime fechaHora;
 private TipoMarcacionEntity tipoMarca;

 public String getNombre() {
    return nombre;
 }
 public void setNombre(String nombre) {
    this.nombre = nombre;
 }
 public LocalDateTime getFechaHora() {
    return fechaHora;
 }
 public void setFechaHora(LocalDateTime fechaHora) {
    this.fechaHora = fechaHora;
 }
 public TipoMarcacionEntity getTipoMarca() {
    return tipoMarca;
 }
 public void setTipoMarca(TipoMarcacionEntity tipoMarca) {
    this.tipoMarca = tipoMarca;
 }

public String getFechaHoraFormateada() {
    if (fechaHora != null) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fechaHora.format(formatter);
    }
    return "";
}

}


