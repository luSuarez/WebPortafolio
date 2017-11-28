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
@WebServlet(name = "ListarActividadesFamilia", urlPatterns = {"/ListarActividadesFamilia"})
public class ListarActividadesFamilia extends HttpServlet {

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
            String id = request.getParameter("IdPrograma");
            
            Programa pro = new Programa();
            pro.IdPrograma = Integer.parseInt(id);
            
            Servicios ser = new Servicios();
            
            String progjson = ser.getBasicHttpBindingIServicios().leerPrograma(pro.Json());
            Programa prog = new Programa(progjson);
            
            
            Institucion insti = new Institucion();
            insti.IdInstitucion = prog.IdInstitucion;
            
            String IstitucionJson = ser.getBasicHttpBindingIServicios().leerInstitucionXML(insti.Json());
            Institucion institucio  = new Institucion(IstitucionJson);
            
            /*leer familias*/
            String listaFamilia = ser.getBasicHttpBindingIServicios().leerTodasFamiliasAnfitrionas();
            JsonReader readerFamilia = Json.createReader(new StringReader(listaFamilia));
            
            JsonArray listFamilia = readerFamilia.readArray();
            List<FamiliaAnfitriona> familias = new ArrayList<>();
            
            for (JsonValue jsonValue : listFamilia) {
                JsonObject fam = (JsonObject)jsonValue;
                FamiliaAnfitriona famili = new FamiliaAnfitriona(fam);
                if (institucio.IdCiudad == famili.IdCiudad) {
                    familias.add(famili);
                }
            }
            
            if (familias.isEmpty()/* || actividades.isEmpty()*/) {
                response.sendRedirect("ListarProgramas");
            }else{
//                request.setAttribute("actividades", actividades);
//                request.setAttribute("familias", familias);
                HttpSession sesion = request.getSession();
                sesion.setAttribute("idPrograma", pro.IdPrograma);
                sesion.setAttribute("familias", familias);
                response.sendRedirect("ListaFamilia.jsp");
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
