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
public class FamiliaAnfitriona {
        public int IdFamilia;
        public String Nombres;
        public String ApePaterno;
        public String ApeMaterno;
        public String Identificador;
        public String Correo;
        public int Telefono;
        public String RutaArchivo; 
        public String Direccion;
        public int IdCiudad;
        public int IdPais;
        public String Estado;

    public FamiliaAnfitriona() {
     this.Init();
    }

    private void Init() {
        this.IdFamilia = 0;
        this.Nombres = "";
        this.ApePaterno = "";
        this.ApeMaterno = "";
        this.Identificador = "";
        this.Correo = "";
        this.Telefono = 0;
        this.RutaArchivo = "";
        this.Direccion = "";
        this.IdCiudad = 0;
        this.IdPais = 0;
        this.Estado = "0";
    }
        
    public FamiliaAnfitriona(String fa){
        
        JsonReader reader = Json.createReader(new StringReader(fa));
        JsonObject faObject = reader.readObject();
        reader.close();
        
        this.IdFamilia = faObject.getInt("IdFamilia");
        this.Nombres = faObject.getString("Nombres");
        this.ApePaterno = faObject.getString("ApePaterno");
        this.ApeMaterno = faObject.getString("ApeMaterno");
        this.Identificador = faObject.getString("Identificador");
        this.Correo = faObject.getString("Correo");
        this.Telefono = faObject.getInt("Telefono");
        this.RutaArchivo = faObject.getString("RutaArchivo");
        this.Direccion = faObject.getString("Direccion");
        this.IdCiudad = faObject.getInt("IdCiudad");
        this.IdPais = faObject.getInt("IdPais");
        this.Estado = faObject.getString("Estado");
    }
    
    public String Json(){
            JsonObject us = Json.createObjectBuilder().
                    add("IdFamilia", this.IdFamilia).
                    add("Nombres", this.Nombres).
                    add("ApePaterno", this.ApePaterno).
                    add("ApeMaterno", this.ApeMaterno).
                    add("Identificador", this.Identificador).
                    add("Correo", this.Correo).
                    add("Telefono", this.Telefono).
                    add("RutaArchivo", this.RutaArchivo).
                    add("Direccion", this.Direccion).
                    add("IdCiudad", this.IdCiudad).
                    add("IdPais", this.IdPais).
                    add("Estado", this.Estado).build();
            
            StringWriter string = new StringWriter();
            JsonWriter writer = Json.createWriter(string);
            writer.writeObject(us);
            writer.close(); 
            
            return string.getBuffer().toString();
    }
    
    public String NombreCompleto(){
        String nom = Nombres +" "+ ApePaterno+" "+ApeMaterno;
        return nom;
    }
        
    public void algo(){
        this.RutaArchivo = "160.195.1.45/"+Nombres+".zip";
        this.Identificador = "algo";
        this.Estado = "Listo";
    }
}
