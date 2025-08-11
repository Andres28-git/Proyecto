package com.futurotech.controller.entity;

public class TipoMarcacionEntity {
   private String TipoMarca;

   public String getTipoMarca() {
       return TipoMarca;
   }
    public void setTipoMarca(String tipoMarca) {
         TipoMarca = tipoMarca;
    }

    @Override
    public String toString() {
        return TipoMarca;
    }
}
