/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlVehiculos;

import SessionBean.DatosVehiculosLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Registro;
import persistencia.RegistroFacadeLocal;

/**
 *
 * @author Ikaro
 */
public class ingresaVehiculo extends HttpServlet {

    @EJB
    private RegistroFacadeLocal registroFacade;

    @EJB
    private DatosVehiculosLocal datosVehiculos;


    
    
    
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
        request.setCharacterEncoding("UTF-8");
        
        String fechaIngreso = datosVehiculos.obtenerFecha();
        String horaEntrada = datosVehiculos.obtenerHora();
        
        String placaPatente = request.getParameter("Placa_Patente");
        
        Registro vehiculo = new Registro();
        
        vehiculo.setPpu(placaPatente);
        vehiculo.setFechaEntrada(fechaIngreso);
        vehiculo.setHoraEntrada(horaEntrada);
        vehiculo.setRutPersonalIngreso("15556735-K");
        
        registroFacade.create(vehiculo);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"css/semantic.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<title>Servlet ingresaVehiculo</title>"); 
            out.println("<meta http-equiv=\"Refresh\" content=\"3;url=http://localhost:8080/Estacionamiento_EspAya-war/controlVehicular.jsp\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"ui center aligned segment\">");
            out.println("<h1>Registro exitoso</h1>");
            out.println("<h2>Placa Patente: " + placaPatente + "</h2>");
            out.println("<p>Fecha: " + fechaIngreso+ "</p>");
            out.println("<p>Hora: " + horaEntrada+ "</p>");
            out.println("</div>");
            out.println("<br>");
            out.println("<br>");
            out.println("<div align=\"center\">");
            out.println("<a href='controlVehicular.jsp' class=\"ui massive teal button\"> Volver a control vehicular </a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
