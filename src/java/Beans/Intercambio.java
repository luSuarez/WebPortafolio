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
public class Intercambio {
        public int IdIntercambio;
        public String Estado;
        public int IdAdministrativo;
        public int IdFamilia;
        public int IdAlumno;
        public int IdPrograma;
        
        public Intercambio(){
            this.Init();
        }

    public Intercambio(String intercambio){
            
        JsonReader reader = Json.createReader(new StringReader(intercambio));
        JsonObject intercambioObject = reader.readObject();
        reader.close();
        
        this.IdIntercambio = intercambioObject.getInt("IdIntercambio");
        this.Estado = intercambioObject.getString("Estado");
        try {
        this.IdAdministrativo = intercambioObject.getInt("IdAdministrativo");
        } catch (Exception e) {
            this.IdAdministrativo = 0;
        }
        this.IdFamilia = intercambioObject.getInt("IdFamilia");
        this.IdAlumno = intercambioObject.getInt("IdAlumno");
        this.IdPrograma = intercambioObject.getInt("IdPrograma");
    }
    
    public Intercambio(JsonObject intercambioObject){
        
        this.IdIntercambio = intercambioObject.getInt("IdIntercambio");
        this.Estado = intercambioObject.getString("Estado");
        try {
        this.IdAdministrativo = intercambioObject.getInt("IdAdministrativo");
        } catch (Exception e) {
            this.IdAdministrativo = 0;
        }
        this.IdFamilia = intercambioObject.getInt("IdFamilia");
        this.IdAlumno = intercambioObject.getInt("IdAlumno");
        this.IdPrograma = intercambioObject.getInt("IdPrograma");
    }
            
    private void Init() {
        this.IdIntercambio = 2;
        this.Estado = "";
        this.IdAdministrativo = 0;
        this.IdFamilia = 0;
        this.IdAlumno = 0;
        this.IdPrograma = 0;
    }
    
    public String Json(){
            JsonObject inter = Json.createObjectBuilder().
                    add("IdIntercambio", this.IdIntercambio).
                    add("Estado", this.Estado).
                    add("IdAdministrativo", this.IdAdministrativo).
                    add("IdFamilia", this.IdFamilia).
                    add("IdAlumno", this.IdAlumno).
                    add("IdPrograma", this.IdPrograma).build();
            
            StringWriter string = new StringWriter();
            JsonWriter writer = Json.createWriter(string);
            writer.writeObject(inter);
            writer.close(); 
            
            return string.getBuffer().toString();
    }
    
        public String JsonPostulacion(){
            JsonObject inter = Json.createObjectBuilder().
                    add("IdIntercambio", this.IdIntercambio).
                    add("Estado", this.Estado).
                    addNull("IdAdministrativo").
                    add("IdFamilia", this.IdFamilia).
                    add("IdAlumno", this.IdAlumno).
                    add("IdPrograma", this.IdPrograma).build();
            
            StringWriter string = new StringWriter();
            JsonWriter writer = Json.createWriter(string);
            writer.writeObject(inter);
            writer.close(); 
            
            return string.getBuffer().toString();
    }
    
}
