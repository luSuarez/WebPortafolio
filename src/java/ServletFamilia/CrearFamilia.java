/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletFamilia;

import Beans.FamiliaAnfitriona;
import Beans.Usuario;
import Servicios_Cem.Servicios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
@WebServlet(name = "CrearFamilia", urlPatterns = {"/CrearFamilia"})
public class CrearFamilia extends HttpServlet {

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
            /*Rescatar datos del jsp*/
            String nombre = request.getParameter("nombre");
            String aPaterno = request.getParameter("paellidoPaterno");
            String aMaterno = request.getParameter("apellidoMaterno");
            String correo = request.getParameter("correo");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String direccion = request.getParameter("direccion");
            int pais = Integer.parseInt(request.getParameter("pais"));
            int ciudad = Integer.parseInt(request.getParameter("ciudad"));
            String pass = request.getParameter("pass");
            
            /*Crear instancia de familia*/
            FamiliaAnfitriona fa = new FamiliaAnfitriona();
            fa.Nombres = nombre;
            fa.ApePaterno = aPaterno;
            fa.ApeMaterno = aMaterno;
            fa.Correo = correo;
            fa.Telefono = telefono;
            fa.Direccion = direccion;
            fa.IdPais = pais;
            fa.IdCiudad = ciudad;
            fa.algo();
            
            Servicios ser = new Servicios();
            
            boolean b = ser.getBasicHttpBindingIServicios().crearFamiliaAnfitriona(fa.Json());
            if (b) {
                /*ya que la familia se pudo insertar, hay que insertar el usuario*/
                String f = ser.getBasicHttpBindingIServicios().leerFamiliaAnfitriona(fa.Json());
                
                FamiliaAnfitriona familia = new FamiliaAnfitriona(f);
                Usuario user = new Usuario();
                user.Nombreusuario(nombre, aPaterno);
                user.Password = pass;
                user.IdFamilia = familia.IdFamilia;
                
                boolean c = ser.getBasicHttpBindingIServicios().crearUsuario(user.JsonFamilia());
                
                if (c) {
                    response.sendRedirect("CargarLogInFamilia");
                }else{
                    ser.getBasicHttpBindingIServicios().eliminarFamiliaAnfitriona(familia.Json());
                    response.sendRedirect("index.jsp");
                }
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
