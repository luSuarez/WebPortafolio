/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletFamilia;

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
@WebServlet(name = "LogInFamilia", urlPatterns = {"/LogInFamilia"})
public class LogInFamilia extends HttpServlet {

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
            
            /*rescatar parametros de JSP*/
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            
            /*Iniciar Servicios*/
            Servicios ser = new Servicios();
            /*Instancia de usuario*/
            Usuario usuario = new Usuario();
            /*Almacenar datos de usuarios*/
            usuario.NomUsuario = user;
            usuario.Password = pass;
            
            /*Serializar usuarios en JSON*/
            String string = usuario.JsonFamilia();
            /*Metodo para validar si el usuario existe*/
            boolean b = ser.getBasicHttpBindingIServicios().validarUsuario(string);
            
            if (b) {
                /*Metodo para leer usuario*/
                String usua = ser.getBasicHttpBindingIServicios().leerUsuario(usuario.JsonFamilia());

                Usuario usuario2 = new Usuario(usua);
                FamiliaAnfitriona fa = new FamiliaAnfitriona();
                fa.IdFamilia = usuario2.IdFamilia;
                
                String fam = ser.getBasicHttpBindingIServicios().leerFamiliaAnfitriona(fa.Json());
                
                FamiliaAnfitriona familia = new FamiliaAnfitriona(fam);
                
                Ciudad c = new Ciudad();
                c.IdCiudad = familia.IdCiudad;
                
                String ci = ser.getBasicHttpBindingIServicios().leerCiudad(c.Json());
                Ciudad ciudad = new Ciudad(ci);
                
                Pais p  = new Pais();
                p.IdPais = familia.IdPais;
                
                String pa = ser.getBasicHttpBindingIServicios().leerPais(p.Json());
                
                Pais pais = new Pais(pa);
                
                request.setAttribute("pais", pais);
                request.setAttribute("ciudad", ciudad);
                
                request.setAttribute("familia", familia);
                request.setAttribute("usuario", usuario2);
                
                request.getRequestDispatcher("familia.jsp").forward(request, response);
            }else{
                response.sendRedirect("CargarLogInFamilia");
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
