/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.json.JsonObject;

/**
 *
 * @author nickm
 */
public class Actividad {
    
    public int IdActividad;
    public String NombreActividad;
    public String Descripcion;

    public Actividad() {
        this.Init();
    }

    private void Init() {
        this.IdActividad = 0;
        this.NombreActividad = "";
        this.Descripcion = "";
    }
    
        public Actividad(JsonObject actividadObject){
        
        this.IdActividad = actividadObject.getInt("IdActividad");
        this.NombreActividad = actividadObject.getString("NombreActividad");
        this.Descripcion = actividadObject.getString("Descripcion");
    }
    
}
