/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAlumno;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Alumno;
import Beans.Usuario;
import Servicios_Cem.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
/**
 *
 * @author nickm
 */
@WebServlet(name = "svlCrearAlumno", urlPatterns = {"/svlCrearAlumno"})
public class CrearAlumno extends HttpServlet {

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
            throws ServletException, IOException, JAXBException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /*Recatar datos de JSP*/
            String id_alumno = request.getParameter("id_alumno");
            String nombre = request.getParameter("id_nombre");
            String apellido_pa = request.getParameter("id_apellidop");
            String apellido_ma = request.getParameter("id_apellidom");
            String correo= request.getParameter("id_correo");
            int telefono= Integer.parseInt(request.getParameter("id_telefono"));
            String pass=request.getParameter("id_pass");
            
            /*Crear instancia de alumno*/
            Alumno alu = new Alumno();
            alu.IdAlumno = Integer.parseInt(alu.Rut(id_alumno));
            alu.Dv = alu.Dv(id_alumno);
            alu.Nombre = nombre;
            alu.ApePaterno = apellido_pa;
            alu.ApeMaterno = apellido_ma;
            alu.Correo = correo;
            alu.Telefono = telefono;
            
            /*Crear instancia de usuario*/
            Usuario user = new Usuario();
            user.IdAlumno = alu.IdAlumno;
            user.Password = pass;
            user.Nombreusuario(nombre, apellido_pa);
           
            Servicios ser = new Servicios();
            boolean crearAlumno =ser.getBasicHttpBindingIServicios().crearAlumno(alu.Json());
            
            if (crearAlumno) {
                boolean crearUsuario = ser.getBasicHttpBindingIServicios().crearUsuario(user.JsonAlumno());
                if (!crearUsuario) {
                    ser.getBasicHttpBindingIServicios().eliminarAlumno(alu.Json());
                }else{
                    response.sendRedirect("logAlumno.jsp");
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
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(CrearAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(CrearAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
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
