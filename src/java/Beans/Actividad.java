/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.StringReader;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;

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

    public Actividad(String actividad){
        
        JsonReader reader = Json.createReader(new StringReader(actividad));
        JsonObject actividadObject = reader.readObject();
        reader.close();
        
        this.IdActividad = actividadObject.getInt("IdActividad");
        this.NombreActividad = actividadObject.getString("NombreActividad");
        this.Descripcion = actividadObject.getString("Descripcion");
        
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

    public String Json() {
        
        JsonObject us = Json.createObjectBuilder().
                add("IdActividad", this.IdActividad).
                add("NombreActividad", this.NombreActividad).
                add("Descripcion", this.Descripcion).build();

        StringWriter string = new StringWriter();
        JsonWriter writer = Json.createWriter(string);
        writer.writeObject(us);
        writer.close(); 

        return string.getBuffer().toString();
    }
    
}
