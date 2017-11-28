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
@WebServlet(name = "GenrarCertificado", urlPatterns = {"/GenrarCertificado"})
public class GenrarCertificado extends HttpServlet {

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
            
            HttpSession sesion = request.getSession();
            Usuario usuario = (Usuario)sesion.getAttribute("sesion");
            NotasAlumno elemento = (NotasAlumno)request.getAttribute("elemento");
            Servicios ser = new Servicios();
            
            Intercambio inter = new Intercambio();
            inter.IdIntercambio = elemento.IdIntercambio;
            
            Intercambio intercambio = new Intercambio(ser.getBasicHttpBindingIServicios().leerIntercambio(inter.Json()));
            
            Programa program = new Programa();
            program.IdPrograma = intercambio.IdPrograma;
            
            Programa programa = new Programa(ser.getBasicHttpBindingIServicios().leerPrograma(program.Json()));
            
            Institucion insti = new Institucion();
            insti.IdInstitucion = programa.IdInstitucion;
            
            Institucion institucion = new Institucion(ser.getBasicHttpBindingIServicios().leerInstitucionXML(insti.Json()));
            
            Pais pa = new Pais();
            pa.IdPais = institucion.IdPais;
            
            Pais pais = new Pais(ser.getBasicHttpBindingIServicios().leerPais(pa.Json()));
            
            Ciudad ci = new Ciudad();
            ci.IdCiudad = institucion.IdCiudad;
            
            Ciudad ciudad = new Ciudad(ser.getBasicHttpBindingIServicios().leerCiudad(ci.Json()));
            
            Alumno alu = new Alumno();
            alu.IdAlumno = usuario.IdAlumno;
            
            Alumno alumno = new Alumno(ser.getBasicHttpBindingIServicios().leerAlumno(alu.Json()));
            
            pdf pdf = new pdf();
            pdf.GenerarPDF(alumno.NombreCompleto(), alumno.RUTAting(), programa.NombrePrograma, institucion.Nombres, pais.NombrePais, ciudad.NombreCiudad, elemento.Promedio);
            
            
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
