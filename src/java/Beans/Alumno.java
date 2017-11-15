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
public class Alumno {

        public int IdAlumno;
        public String Dv;
        public String Nombre;
        public String ApePaterno;
        public String ApeMaterno; 
        public String Correo;
        public int Reserva;
        public int Telefono;
        public String EstadoMora;

    public Alumno() {
        this.Init();
    }
    
    public Alumno(String alu){
        
        JsonReader reader = Json.createReader(new StringReader(alu));
        JsonObject alumnoObject = reader.readObject();
        reader.close();
        
        this.IdAlumno = alumnoObject.getInt("IdAlumno");
        this.Dv = alumnoObject.getString("Dv");
        this.Nombre = alumnoObject.getString("Nombre");
        this.ApePaterno = alumnoObject.getString("ApePaterno");
        this.ApeMaterno = alumnoObject.getString("ApeMaterno");
        this.ApeMaterno = alumnoObject.getString("ApeMaterno");
        this.Correo = alumnoObject.getString("Correo");
        this.Reserva =  alumnoObject.getInt("Reserva");
        this.Telefono =  alumnoObject.getInt("Telefono");
        this.EstadoMora = alumnoObject.getString("EstadoMora");
        
    }


    private void Init() {
        this.IdAlumno = 0;
        this.Dv = "0";
        this.ApeMaterno = "0";
        this.ApePaterno = "0";
        this.Correo = "0";
        this.EstadoMora = "0";
        this.Nombre = "0";
        this.Reserva = 0;
        this.Telefono = 0;
    }
    
    public String Json(){
            JsonObject us = Json.createObjectBuilder().
                    add("IdAlumno", this.IdAlumno).
                    add("Dv", this.Dv).
                    add("ApeMaterno", this.ApeMaterno).
                    add("ApePaterno", this.ApePaterno).
                    add("Correo", this.Correo).
                    add("EstadoMora", this.EstadoMora).
                    add("Nombre", this.Nombre).
                    add("Reserva", this.Reserva).
                    add("Telefono", this.Telefono).build();
            
            StringWriter string = new StringWriter();
            JsonWriter writer = Json.createWriter(string);
            writer.writeObject(us);
            writer.close(); 
            
            return string.getBuffer().toString();
    }
    
    public String Rut(String rut){
        return rut.substring(0,rut.length()-2);
    }

    public String Dv(String rut){
        return rut.substring(rut.length()-1);
    }
}
