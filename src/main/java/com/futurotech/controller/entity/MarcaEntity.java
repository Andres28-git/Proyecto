package com.futurotech.controller.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class MarcaEntity {
 private String nombre;
 private LocalDateTime fechaHora;
 private TipoMarcacionEntity tipoMarca;

 public void setNombre(String nombre) throws IllegalArgumentException {
   if (nombre != null && !nombre.trim().isEmpty()){
      if(nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")){
         this.nombre = nombre;
      } else {
         throw new IllegalArgumentException("El nombre solo debe contener letras y espacios.");
      }
      }
       else {
         throw new IllegalArgumentException("El nombre no puede estar vacío.");
      }
     }   
   

 public String getNombre() {
    return nombre;
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


