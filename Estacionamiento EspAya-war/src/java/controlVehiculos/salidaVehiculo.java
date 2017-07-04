/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlVehiculos;

import SessionBean.DatosVehiculosLocal;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
        Registro vehiculoBuscado = new Registro();
        String fechaSalida = datosVehiculos.obtenerFecha();
        String horaSalida = datosVehiculos.obtenerHora();
        String placaPatente = request.getParameter("Placa_Patente");

        int idRegistro = registroFacade.obtenerID(placaPatente);

        if (idRegistro != -1) {
            vehiculoBuscado = registroFacade.find(idRegistro);

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
                out.println("<meta http-equiv=\"Refresh\" content=\"20;url=http://localhost:8080/Estacionamiento_EspAya-war/controlVehicular.jsp\">");
                out.println("<link href=\"css/semantic.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<title>Servlet salidaVehiculo</title>");
                out.println("</head>");
                out.println("<body>"); 
                out.println("<div class=\"ui center aligned segment\">");
                out.println("<h1>Salida Exitosa</h1>");
                out.println("<h2>Placa Patente :" + placaPatente + "</h2>");
                out.println("<p>fecha entrada :" + fechaEnt + "</p>");
                out.println("<p>hora entrada :" + horaEnt + "</p>");
                out.println("<p>Fecha salida :" + fechaSalida + "</p>");
                out.println("<p>hora salida :" + horaSalida + "</p>");
                out.println("<h5>Tiempo Estadia" + tiempoEstadia + "</h5>");
                out.println("<h3>Monto a cancelar $" + monto + "</h3>");
                out.println("<br>");
                out.println("<br>");
                out.println("<a href='controlVehicular.jsp' class=\"ui massive teal button\"> Volver a control vehicular </a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Refresh\" content=\"5;url=http://localhost:8080/Estacionamiento_EspAya-war/controlVehicular.jsp\">");
                out.println("<link href=\"css/semantic.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<title>Servlet salidaVehiculo</title>");
                out.println("</head>");
                out.println("<body>");
                
                out.println("<div class=\"ui center aligned segment\">");
                out.println("<h1>Salida Fallida</h1>");
                out.println("<h1>El vehículo con la PPU " + placaPatente + " no se encuentra registrado en el sistema.</h1>");
                out.println("<br>");
                out.println("<br>");
                out.println("<a href='controlVehicular.jsp' class=\"ui massive teal button\"> Volver a control vehicular </a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
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
