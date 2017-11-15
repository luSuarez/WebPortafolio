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
public class programa_actividad {
    public int IdPrograma;
    public int IdActividad;
    
    public programa_actividad(){
        this.Init();
    }

    private void Init() {
        this.IdActividad = 0;
        this.IdPrograma = 0;
    }
    
    public programa_actividad(String pro){
        JsonReader reader = Json.createReader(new StringReader(pro));
        JsonObject programaObject = reader.readObject();
        reader.close();
        
        this.IdPrograma = programaObject.getInt("IdPrograma");
        this.IdActividad = programaObject.getInt("IdActividad");
    }
    
    public programa_actividad(JsonObject programaObject){
        
        this.IdPrograma = programaObject.getInt("IdPrograma");
        this.IdActividad = programaObject.getInt("IdActividad");
    }
}
