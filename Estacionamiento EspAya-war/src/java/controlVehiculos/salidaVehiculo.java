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
public class salidaVehiculo extends HttpServlet {

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
        
        String fechaSalida = datosVehiculos.obtenerFecha();
        String horaSalida = datosVehiculos.obtenerHora();
        String placaPatente = request.getParameter("Placa_Patente");
        
        int idRegistro = registroFacade.obtenerID(placaPatente);
        
        Registro vehiculoBuscado = registroFacade.find(idRegistro);
        
        
        String fechaEnt = vehiculoBuscado.getFechaEntrada();
        String horaEnt = vehiculoBuscado.getHoraEntrada();
        
        int monto = datosVehiculos.cotizaMontoServicio(fechaEnt, horaEnt, fechaSalida, horaSalida);
        String tiempoEstadia = datosVehiculos.tiempoEstadia(fechaEnt, horaEnt, fechaSalida, horaSalida);
        
        vehiculoBuscado.setFechaSalida(fechaSalida);
        vehiculoBuscado.setHoraSalida(horaSalida);
        vehiculoBuscado.setRetirado(true);
        vehiculoBuscado.setRutPersonalSalida("15556735-k");
        vehiculoBuscado.setMontoCancelado(monto);
        
        registroFacade.edit(vehiculoBuscado);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet salidaVehiculo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet salidaVehiculo at </h1>");
            out.println("<h2>Placa Patente " + placaPatente + "</h2>");
            out.println("<p>fecha ent" + fechaEnt+ "</p>");
            out.println("<p>hora ent" + horaEnt+ "</p>");
            out.println("<p>monto" + monto+ "</p>");
            out.println("<p>Fecha sal" + fechaSalida+ "</p>");
            out.println("<p>hora sal " + horaSalida+ "</p>");
            out.println("<p>id" + idRegistro+ "</p>");
            out.println("<p>Tiempo Estadia" + tiempoEstadia+ "</p>");
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
