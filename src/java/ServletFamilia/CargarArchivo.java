/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletFamilia;

import Beans.*;
import Servicios_Cem.Servicios;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author luis
 */
@WebServlet(name = "CargarArchivo", urlPatterns = {"/CargarArchivo"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class CargarArchivo extends HttpServlet {

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
            
            Usuario ususario  = (Usuario)sesion.getAttribute("usuario");
            
            FamiliaAnfitriona fa = new FamiliaAnfitriona();
            fa.IdFamilia = ususario.IdFamilia;
            
            Servicios ser = new Servicios();
            
            String familia = ser.getBasicHttpBindingIServicios().leerFamiliaAnfitriona(fa.Json());
            
            FamiliaAnfitriona familiaAnfitriona = new FamiliaAnfitriona(familia);
            
            InputStream inputStream = null;
            String carpeta =  "Familias/"+familiaAnfitriona.Identificador;
                    
            Part filePart = request.getPart("photo");
            
            String GUIDwithext = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String GUID = GUIDwithext.substring(0, GUIDwithext.lastIndexOf('.'));

           
            inputStream = filePart.getInputStream();
            
            String Type = null;
            
            if(filePart.getContentType().equals("image/png")){
                Type = ".png";
            }else if(filePart.getContentType().equals("image/jpeg")){
                Type = ".jpg";
            }else if(filePart.getContentType().equals("aplication/PDF")){
                Type = ".pdf";
            }else{
                response.sendRedirect("SubirArchivos.jsp");
            }
            
            try {

                FTPClient ftpClient = new FTPClient();
                ftpClient.connect(InetAddress.getByName("190.46.53.32"));
                ftpClient.login("cem", "nick6831");
                String namefile = GUID + Type;
                
                if (ftpClient.changeWorkingDirectory(carpeta)) {
                    ftpClient.changeWorkingDirectory(carpeta);
                    ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
                    BufferedInputStream buffIn=null;
                    buffIn=new BufferedInputStream(inputStream);
                    ftpClient.enterLocalPassiveMode();
                    ftpClient.storeFile(namefile, buffIn);

                    buffIn.close();
                    ftpClient.logout();
                    ftpClient.disconnect();
                }else{
                    ftpClient.makeDirectory(carpeta);
                    
                    ftpClient.changeWorkingDirectory(carpeta);
                    ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
                    BufferedInputStream buffIn=null;
                    buffIn=new BufferedInputStream(inputStream);
                    ftpClient.enterLocalPassiveMode();
                    ftpClient.storeFile(namefile, buffIn);

                    buffIn.close();
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
                
                response.sendRedirect("");
                
            } catch (IOException e){
                    System.out.println("error"+e);
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
