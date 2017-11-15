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
public class Pais {
        public int IdPais;
        public String NombrePais;
        public String Sigla;

    public Pais() {
        this.Init();
    }

    private void Init() {
        this.IdPais=0;
        this.NombrePais="";
        this.Sigla="";
    }
    
    public Pais(JsonObject paObject){
        this.IdPais = paObject.getInt("IdPais");
        this.NombrePais = paObject.getString("NombrePais");
        this.Sigla = paObject.getString("Sigla");
    }
    
    public Pais(String pais){
            
        JsonReader reader = Json.createReader(new StringReader(pais));
        JsonObject paObject = reader.readObject();
        reader.close();
        
        this.IdPais = paObject.getInt("IdPais");
        this.NombrePais = paObject.getString("NombrePais");
        this.Sigla = paObject.getString("Sigla");
    }
        
    public String Json(){
    JsonObject us = Json.createObjectBuilder().
            add("IdPais", this.IdPais).
            add("NombrePais", this.NombrePais).
            add("Sigla", this.Sigla).build();

    StringWriter string = new StringWriter();
    JsonWriter writer = Json.createWriter(string);
    writer.writeObject(us);
    writer.close(); 

    return string.getBuffer().toString();
    }
}
