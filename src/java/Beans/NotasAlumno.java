/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class NotasAlumno {
    public String NombrePrograma;
    public List<Nota> Notas;
    public double Promedio;

    public NotasAlumno() {
        this.Init();
    }

    private void Init() {
        NombrePrograma = " ";
        Notas = new ArrayList<>();
        Promedio = 0;
    }
    
    public double CalcularPromedio(){
        int suma = 0;
        if (Notas==null) {
            return 0;
        }else if(Notas.isEmpty()) {
            return 0;
        }else{
            for (Nota Nota1 : Notas) {
             suma += Nota1.Evaluacion;   
            }
            return (double)suma/Notas.size();
        }
    }
    
    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    
}
