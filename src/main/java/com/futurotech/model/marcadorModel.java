package com.futurotech.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcador")
public class marcadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 127)
    private String nombre;
    @Column(name = "tipo_marcacion", nullable = false, length = 15)
    private String tipoMarcacion;
    @Column(name = "fecha_hora", nullable = false, length = 19)
    private String fechaHora;
    @Column(name = "feCreacion", nullable = true)
    private LocalDate  feCreacion;
    @Column(name = "usrCreacion", nullable = true, length = 127)
    private String usrCreacion;
    @Column(name = "feUltModificacion", nullable = true)
    private LocalDate feUltModificacion;
    @Column(name = "usrUltModificacion", nullable = true, length = 127)
    private String usrUltModificacion;


    // Getters and Setters


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoMarcacion() {
        return tipoMarcacion;
    }
    public void setTipoMarcacion(String tipoMarcacion) {
        this.tipoMarcacion = tipoMarcacion;
    }
    public String getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
    public LocalDate getFeCreacion() {
        return feCreacion;
    }
    public  void setFeCreacion(LocalDate tipoMarca) {
        this.feCreacion = tipoMarca;
    }
    public String getUsrCreacion() {
        return usrCreacion;
    }
    public void setUsrCreacion(String usrCreacion) {
        this.usrCreacion = usrCreacion;
    }
    public LocalDate getFeModificacion() {
        return feUltModificacion;
    }
    public void setFeModificacion(LocalDate feModificacion) {
        this.feUltModificacion = feModificacion;
    }
    public String getUsrModificacion() {
        return usrUltModificacion;
    }
    public void setUsrModificacion(String usrModificacion) {
        this.usrUltModificacion = usrModificacion;
    }

    


    
}
