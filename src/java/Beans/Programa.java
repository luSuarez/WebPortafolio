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
//    public int IdActividad;
    public String Descripcion;

    public Programa() {
        this.Init();
    }
    
    private void Init() {
        this.IdPrograma = 0;
        this.NombrePrograma = "0";
        this.Cupos = 0;
        this.IdInstitucion = 0;
        this.FechaInicio = "0";
        this.FechaTermino = "0";
        this.TipoCurso = 0;
//        this.IdActividad = 0;
        this.Descripcion = "0";
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
        try {
            this.IdInstitucion = programaObject.getInt("IdInstitucion");
        } catch (Exception e) {
            this.IdInstitucion = 0;
        }
        this.FechaInicio = programaObject.getString("FechaInicio".toString());
        this.FechaTermino = programaObject.getString("FechaTermino".toString());
        this.TipoCurso = programaObject.getInt("TipoCurso");
//        this.IdActividad = programaObject.getInt("IdActividad");
        try {
            this.Descripcion = programaObject.getString("Descripcion");
        } catch (Exception e) {
            this.Descripcion = "0";
        }
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
        try {
            this.IdInstitucion = programaObject.getInt("IdInstitucion");
        } catch (Exception e) {
            this.IdInstitucion = 0;
        }
        this.FechaInicio = programaObject.getString("FechaInicio".toString());
        this.FechaTermino = programaObject.getString("FechaTermino".toString());
        try {
            this.TipoCurso = programaObject.getInt("TipoCurso");
        } catch (Exception e) {
            this.TipoCurso = 0;
        }
//        this.IdActividad = programaObject.getInt("IdActividad");
        try {
            this.Descripcion = programaObject.getString("Descripcion");
        } catch (Exception e) {
            this.Descripcion = "0";
        }
//        this.Estado = programaObject.getInt("Estado");
        
    }

    public String Json(){
            JsonObject us = Json.createObjectBuilder().
                    add("IdPrograma", this.IdPrograma).
                    add("NombrePrograma", this.NombrePrograma).
                    add("Cupos", this.Cupos).
                    add("IdInstitucion", this.IdInstitucion).
                    addNull("FechaInicio").
                    addNull("FechaTermino").
                    add("TipoCurso", this.TipoCurso).
//                    add("IdActividad", this.IdActividad).
                    add("Descripcion", this.Descripcion).
//                    add("Estado", this.Estado).
                    build();
            
            StringWriter string = new StringWriter();
            JsonWriter writer = Json.createWriter(string);
            writer.writeObject(us);
            writer.close(); 
            
            return string.getBuffer().toString();
    }


    

}
