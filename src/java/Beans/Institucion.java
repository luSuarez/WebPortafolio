/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author luis
 */
public class Institucion {
        public int IdInstitucion;
        public String Nombres;
        public String Correo;
        public long Telefono;
        public String PaginaWeb;
        public String Direcion;
        public int IdCiudad;
        public int IdPais;

    public Institucion() {
        this.Init();
    }

    private void Init() {
        this.IdInstitucion = 0;
        this.Nombres = "";
        this.Correo = "";
        this.Telefono = 0;
        this.PaginaWeb = "";
        this.Direcion = "";
        this.IdCiudad = 0;
        this.IdPais = 0;
    }
    
    public Institucion(String inst){
        JsonReader reader = Json.createReader(new StringReader(inst));
        JsonObject institucionObject = reader.readObject();
        reader.close();
        
        this.IdInstitucion = institucionObject.getInt("IdInstitucion");
        this.Nombres = institucionObject.getString("Nombres");
        this.Correo = institucionObject.getString("Correo");
        this.Telefono = institucionObject.getInt("Telefono");
        this.PaginaWeb = institucionObject.getString("PaginaWeb");
        this.Direcion = institucionObject.getString("Direcion");
        this.IdCiudad = institucionObject.getInt("IdCiudad");
        this.IdPais = institucionObject.getInt("IdPais");
    }
    public Institucion(JsonObject institucionObject){
        
        this.IdInstitucion = institucionObject.getInt("IdInstitucion");
        this.Nombres = institucionObject.getString("Nombres");
        this.Correo = institucionObject.getString("Correo");
        this.Telefono = institucionObject.getInt("Telefono");
        this.PaginaWeb = institucionObject.getString("PaginaWeb");
        this.Direcion = institucionObject.getString("Direcion");
        this.IdCiudad = institucionObject.getInt("IdCiudad");
        this.IdPais = institucionObject.getInt("IdPais");
    }    
}
