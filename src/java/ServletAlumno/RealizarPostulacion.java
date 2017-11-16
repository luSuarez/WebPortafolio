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
@WebServlet(name = "RealizarPostulacion", urlPatterns = {"/RealizarPostulacion"})
public class RealizarPostulacion extends HttpServlet {

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
            
            String idPrograma = request.getParameter("idPrograma");
            String idFamilia = request.getParameter("idFamilia");
            int idFam = Integer.parseInt(idFamilia);
            int idPro = Integer.parseInt(idPrograma);
            
            Usuario user = (Usuario)sesion.getAttribute("usuario");
            
            Servicios ser = new Servicios();
            
            Intercambio inter = new Intercambio();
            inter.IdAlumno = user.IdAlumno;
            inter.IdPrograma = idPro;
            inter.IdFamilia = idFam; 
            inter.Estado = "Pendiente";
            
            boolean postula = ser.getBasicHttpBindingIServicios().crearIntercambio(inter.JsonPostulacion());
            String Mensaje = null;
            if (postula) {
                Mensaje = "La postulicion ha sido registrada";
            }else{
                Mensaje = "La postulicion no se ha podido registrar, vuelva a ";
            }
            request.setAttribute("mensaje", Mensaje);
            request.getRequestDispatcher("InicioAlumno").forward(request, response);
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
