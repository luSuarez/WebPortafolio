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
 * @author luis
 */
public class Nota {
    public int IdNota;
    public int Evaluacion;
    public int IdPrograma;
    public int IdAlumno;  

    public Nota() {
        this.Init();
    }

    private void Init() {
        this.IdNota = 0;
        this.Evaluacion = 0;
        this.IdPrograma = 0;
        this.IdAlumno = 0;

    }        
    public Nota(JsonObject notaObject){
        this.IdNota = notaObject.getInt("IdNota");
        this.Evaluacion = notaObject.getInt("Evaluacion");
        this.IdPrograma = notaObject.getInt("IdPrograma");
        this.IdAlumno = notaObject.getInt("IdAlumno");
    }
        
    public Nota(String nota){
            
        JsonReader reader = Json.createReader(new StringReader(nota));
        JsonObject notaObject = reader.readObject();
        reader.close();
        
        this.IdNota = notaObject.getInt("IdNota");
        this.Evaluacion = notaObject.getInt("Evaluacion");
        this.IdPrograma = notaObject.getInt("IdPrograma");
        this.IdAlumno = notaObject.getInt("IdAlumno");
    }
        
    public String Json(){
    JsonObject us = Json.createObjectBuilder().
            add("IdNota", this.IdNota).
            add("Evaluacion", this.Evaluacion).
            add("IdPrograma", this.IdPrograma).
            add("IdAlumno", this.IdAlumno).build();

    StringWriter string = new StringWriter();
    JsonWriter writer = Json.createWriter(string);
    writer.writeObject(us);
    writer.close(); 

    return string.getBuffer().toString();
    }    
    
    
}
