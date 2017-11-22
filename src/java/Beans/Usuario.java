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

public class Usuario {
        public int IdUsuario;
        public String NomUsuario;
        public String Password;
        public int IdAlumno;
        public int IdAdministrativo;
        public String Rol;
        public int IdFamilia;
        public int IdEncargadoCel;
        public int IdEncargadoCem;

    public Usuario(String usua){
        
        JsonReader reader = Json.createReader(new StringReader(usua));
        JsonObject usuarioObject = reader.readObject();
        reader.close();
        
        this.IdUsuario = usuarioObject.getInt("IdUsuario");
        this.NomUsuario = usuarioObject.getString("NomUsuario");
        this.Password = usuarioObject.getString("Password");
        try {
            this.IdAlumno = usuarioObject.getInt("IdAlumno");
        } catch (Exception e) {
            this.IdAlumno = 0;
        }
        try {
            this.IdFamilia = usuarioObject.getInt("IdFamilia");
        } catch (Exception e) {
        this.IdFamilia = 0;
        }
        this.IdAdministrativo = 0;
        this.Rol = "0";
        this.IdEncargadoCel = 0;
        this.IdEncargadoCem = 0;
    }
        
    public Usuario() {
        this.Init();
    }
    
    private void Init() {
        this.IdUsuario = 0;
        this.NomUsuario = "";
        this.Password = "";
        this.Rol = "";
        this.IdAlumno = 0;
        this.IdAdministrativo = 0;
        this.IdFamilia = 0;
        this.IdEncargadoCel = 0;
        this.IdEncargadoCem = 0;
    }    
    
    public String JsonAlumno(){
        JsonObject us = Json.createObjectBuilder().
                    add("IdUsuario", this.IdUsuario).
                    add("NomUsuario", this.NomUsuario).
                    add("Password", this.Password).
                    add("IdAlumno", this.IdAlumno).
                    add("Rol", "Alumno").
                    addNull("IdAdministrativo").
                    addNull("IdFamilia").
                    addNull("IdEncargadoCel").
                    addNull("IdEncargadoCem").build();
            
        StringWriter string = new StringWriter();
        JsonWriter writer = Json.createWriter(string);
        writer.writeObject(us);
        writer.close();
        
        return string.getBuffer().toString();
    }

    public String JsonFamilia() {
        JsonObject us = Json.createObjectBuilder().
                    add("IdUsuario", this.IdUsuario).
                    add("NomUsuario", this.NomUsuario).
                    add("Password", this.Password).
                    addNull("IdAlumno").
                    add("Rol", "Familia").
                    addNull("IdAdministrativo").
                    add("IdFamilia", this.IdFamilia).
                    addNull("IdEncargadoCel").
                    addNull("IdEncargadoCem").build();
            
        StringWriter string = new StringWriter();
        JsonWriter writer = Json.createWriter(string);
        writer.writeObject(us);
        writer.close();
        
        return string.getBuffer().toString();
    }
    
    public void Nombreusuario(String nombre, String apellidoPaterno){
        nombre = nombre.substring(0, 3);
        NomUsuario = nombre+"."+apellidoPaterno;
        NomUsuario = NomUsuario.toLowerCase();
    }

}
