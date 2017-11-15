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
        
    }

}
