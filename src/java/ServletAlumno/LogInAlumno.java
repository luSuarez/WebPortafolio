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
@WebServlet(name = "LogInAlumno", urlPatterns = {"/LogInAlumno"})
public class LogInAlumno extends HttpServlet {

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
            String string = usuario.JsonAlumno();
            /*Metodo para validar si el usuario existe*/
            boolean b = ser.getBasicHttpBindingIServicios().validarUsuario(string);
            /*Valida si el usuario existe*/
            if(b)
            {
                /*Metodo para leer usuario*/
                String usua = ser.getBasicHttpBindingIServicios().leerUsuario(usuario.JsonAlumno());

                Usuario usuario2 = new Usuario(usua);
                /*Valida contraseña valida*/
                if (pass.equals(usuario2.Password)) {
                    Alumno nalu = new Alumno();
                    nalu.IdAlumno = usuario2.IdAlumno;

                    String alu = ser.getBasicHttpBindingIServicios().leerAlumno(nalu.Json());

                    Alumno alumno = new Alumno(alu);

                    request.setAttribute("alumno", alumno);

                    sesion.setAttribute("usuario", usuario2);
                    request.getRequestDispatcher("Alumno.jsp").forward(request, response);
                }else{
                    sesion.invalidate();
                    response.sendRedirect("logAlumno.jsp");
                }
                
            }else
            {
                sesion.invalidate();
                response.sendRedirect("logAlumno.jsp");
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
