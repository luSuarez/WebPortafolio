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
public class Ciudad {
    
        public int IdCiudad;
        public String NombreCiudad;
        public int IdPais;

    public Ciudad() {
        this.Init();
    }

    private void Init() {
        this.IdCiudad = 0;
        this.NombreCiudad = "";
        this.IdPais = 0;
    }
    
    public Ciudad(JsonObject ciObject){
        this.IdCiudad = ciObject.getInt("IdCiudad");
        this.NombreCiudad = ciObject.getString("NombreCiudad");
        this.IdPais = ciObject.getInt("IdPais");
    }
    
    public Ciudad(String ci){
        
        JsonReader reader = Json.createReader(new StringReader(ci));
        JsonObject ciObject = reader.readObject();
        reader.close();
        
        this.IdCiudad = ciObject.getInt("IdCiudad");
        this.NombreCiudad = ciObject.getString("NombreCiudad");
        this.IdPais = ciObject.getInt("IdPais");
    }
    
    public String Json(){
        JsonObject us = Json.createObjectBuilder().
                add("IdCiudad", this.IdCiudad).
                add("NombreCiudad", this.NombreCiudad).
                add("IdPais", this.IdPais).build();

        StringWriter string = new StringWriter();
        JsonWriter writer = Json.createWriter(string);
        writer.writeObject(us);
        writer.close(); 

        return string.getBuffer().toString();
}
        
}
