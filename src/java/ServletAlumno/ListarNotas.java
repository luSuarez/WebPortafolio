/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAlumno;

import Beans.*;
import Servicios_Cem.Servicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luis
 */
@WebServlet(name = "ListarNotas", urlPatterns = {"/ListarNotas"})
public class ListarNotas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /*Rescatar el usuario alumno de la sesion.*/
            
            HttpSession sesion = request.getSession();
            Usuario user = (Usuario)sesion.getAttribute("usuario");
            
            /*Crear instancia de los servicios*/
            
            Servicios ser = new Servicios();
            
            /*Rescatar coleccion de intercambios de la bd y pasarla a List<Intercambio>*/
            
            String listaIntercambio = ser.getBasicHttpBindingIServicios().leerTodosIntercambios();
            JsonReader readerIntercambio = Json.createReader(new StringReader(listaIntercambio));
            JsonArray listIntercambio = readerIntercambio.readArray();
            List<Intercambio> intercambios = new ArrayList<>();
            for (JsonValue object : listIntercambio) {
                JsonObject inter = (JsonObject)object;
                if (user.IdAlumno == inter.getInt("IdAlumno")) {
                    if (inter.getJsonString("Estado").equals("Aprobado")) {
                        Intercambio interc = new Intercambio(inter);
                        intercambios.add(interc);
                    }
                }
            }
            
            /*Obtener programas que estan en la lista intercambio*/
            
            List<Programa> programas = new ArrayList<>();
            for (Intercambio intercambio : intercambios) {
                Programa pro = new Programa();
                pro.IdPrograma = intercambio.IdPrograma;
                String jsonPrograma = ser.getBasicHttpBindingIServicios().leerPrograma(pro.Json());
                Programa programa = new Programa(jsonPrograma);
                programas.add(programa);
            }
            
            /*Obtener coleccion de notas*/
            
            String listaNotas = ser.getBasicHttpBindingIServicios().leerTodasNotas();
            JsonReader readerNotas = Json.createReader(new StringReader(listaNotas));
            JsonArray listNotas = readerNotas.readArray();
            List<Nota> notas = new ArrayList<>();
            for (JsonValue nota1 : listNotas) {
                JsonObject not = (JsonObject)nota1;
                Nota n = new Nota(not);
                notas.add(n);
            }
            
            /*Generar lista de Notas por Programa*/
            
            List<NotasAlumno> listProgramas = new ArrayList<>();
            for (Programa programa : programas) {
                NotasAlumno ltsNotas = new NotasAlumno();
                ltsNotas.NombrePrograma = programa.NombrePrograma;
                for (Nota nota : notas) {
                    if (nota.IdPrograma == programa.IdPrograma && user.IdAlumno == nota.IdAlumno) {
                        ltsNotas.Notas.add(nota);
                    }
                }
                ltsNotas.Promedio = ltsNotas.round(ltsNotas.CalcularPromedio(), 1);
                listProgramas.add(ltsNotas);
            }
            
            if (listProgramas.isEmpty()) {
                response.sendRedirect("InicioAlumno");
            }else{
                request.setAttribute("lista", listProgramas);
                request.getRequestDispatcher("Nota.jsp").forward(request, response);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
