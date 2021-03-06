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

/**
 *
 * @author luis
 */
@WebServlet(name = "ListarProgramas", urlPatterns = {"/ListarProgramas"})
public class ListarProgramas extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            Servicios ser = new Servicios();
            
            String listaProgramas = ser.getBasicHttpBindingIServicios().leerTodosProgramas();
            
            JsonReader reader = Json.createReader(new StringReader(listaProgramas));
            
            JsonArray list = reader.readArray();
            List<Programa> programas = new ArrayList<>();
            
            for (JsonValue jsonValue : list) {
                JsonObject prog = (JsonObject)jsonValue;
                Programa programa = new Programa(prog);
//                if (programa.Estado == 2) {
                    programas.add(programa);
//                }
            }
            
            String listaInstitucion = ser.getBasicHttpBindingIServicios().leerTodasInstituciones();
            
            JsonReader readerInstitucion = Json.createReader(new StringReader(listaInstitucion));
            
            JsonArray listInstitucion = readerInstitucion.readArray();
            List<Institucion> instituciones = new ArrayList<>();
            
            for (JsonValue jsonValue : listInstitucion) {
                JsonObject inst = (JsonObject)jsonValue;
                Institucion institucion = new Institucion(inst);
                instituciones.add(institucion);
            }
            
            String p = ser.getBasicHttpBindingIServicios().leerTodosPaises();
            
            JsonReader reader1 = Json.createReader(new StringReader(p));
            JsonArray listpais = reader1.readArray();
            List<Pais> paises = new ArrayList<>();
            
            for (JsonValue jsonValue : listpais) {
                JsonObject pa = (JsonObject)jsonValue;
                Pais pais = new Pais(pa);
                paises.add(pais);
            }
            
            String c = ser.getBasicHttpBindingIServicios().leerTodasCiudades();
            
            JsonReader reader2 = Json.createReader(new StringReader(c));
            JsonArray listciudad = reader2.readArray();
            List<Ciudad> ciudades = new ArrayList<>();
            
            for (JsonValue jsonValue : listciudad) {
                JsonObject ci = (JsonObject)jsonValue;
                Ciudad ciudad = new Ciudad(ci);
                ciudades.add(ciudad);
            }
            
            if (paises.isEmpty() || ciudades.isEmpty() || programas.isEmpty() || instituciones.isEmpty()) {
                response.sendRedirect("InicioAlumno");
            }else{
                request.setAttribute("listaPaises", paises);
                request.setAttribute("listaCiudades", ciudades);
                request.setAttribute("listaProgramas", programas);
                request.setAttribute("listaInstituciones", instituciones);
                request.getRequestDispatcher("postulacion.jsp").forward(request, response);
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
