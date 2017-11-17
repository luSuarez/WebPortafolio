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
 * @author portafolio
 */
public class Programa {
    
    public int IdPrograma;
    public String NombrePrograma;
    public int Cupos;
    public int IdInstitucion;
    public String FechaInicio;
    public String FechaTermino;
    private int TipoCurso;
//    public int Estado;

    public Programa() {
    }
    
    public Programa(String pro){
        JsonReader reader = Json.createReader(new StringReader(pro));
        JsonObject programaObject = reader.readObject();
        reader.close();
        
        this.IdPrograma = programaObject.getInt("IdPrograma");
        this.NombrePrograma = programaObject.getString("NombrePrograma");
        try {
            this.Cupos = programaObject.getInt("Cupos");
        } catch (Exception e) {
            this.Cupos = 0;
        }
        this.IdInstitucion = programaObject.getInt("IdInstitucion");
        this.FechaInicio = programaObject.getString("FechaInicio".toString());
        this.FechaTermino = programaObject.getString("FechaTermino".toString());
        this.TipoCurso = programaObject.getInt("TipoCurso");
//        this.Estado = programaObject.getInt("Estado");
    }
    
    public Programa(JsonObject programaObject){
        
        this.IdPrograma = programaObject.getInt("IdPrograma");
        this.NombrePrograma = programaObject.getString("NombrePrograma");
        try {
            this.Cupos = programaObject.getInt("Cupos");
        } catch (Exception e) {
            this.Cupos = 0;
        }
        this.IdInstitucion = programaObject.getInt("IdInstitucion");
        this.FechaInicio = programaObject.getString("FechaInicio".toString());
        this.FechaTermino = programaObject.getString("FechaTermino".toString());
        try {
            this.TipoCurso = programaObject.getInt("TipoCurso");
        } catch (Exception e) {
            this.TipoCurso = 0;
        }
//        this.Estado = programaObject.getInt("Estado");
        
    }

    public String Json(){
            JsonObject us = Json.createObjectBuilder().
                    add("IdPrograma", this.IdPrograma).
                    add("NombrePrograma", this.NombrePrograma).
                    add("Cupos", this.Cupos).
                    add("IdInstitucion", this.IdInstitucion).
                    add("FechaInicio", this.FechaInicio).
                    add("FechaTermino", this.FechaTermino).
                    add("TipoCurso", this.TipoCurso).
//                    add("Estado", this.Estado).
                    build();
            
            StringWriter string = new StringWriter();
            JsonWriter writer = Json.createWriter(string);
            writer.writeObject(us);
            writer.close(); 
            
            return string.getBuffer().toString();
    }
    

}
