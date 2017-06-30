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
public class eliminarRegistro extends HttpServlet {

    @EJB
    private DatosVehiculosLocal datosVehiculos;

    @EJB
    private RegistroFacadeLocal registroFacade;

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

        String fechaSistema = datosVehiculos.obtenerFecha();
        String horaSistema = datosVehiculos.obtenerHora();

        Boolean estado = Boolean.valueOf(request.getParameter("estado"));
        int idRegistro = Integer.parseInt(request.getParameter("idV"));

        Registro vehiculoBuscado = registroFacade.find(idRegistro);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet eliminarRegistro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet eliminarRegistro </h1>");
            if (estado == false) {

                String FechaEnt = vehiculoBuscado.getFechaEntrada();
                String horaEnt = vehiculoBuscado.getHoraEntrada();

                if (datosVehiculos.realizaCambio(FechaEnt, horaEnt, fechaSistema, horaSistema)) {
                    registroFacade.remove(vehiculoBuscado);
                    out.println("<h2> Ha sido eliminado la entrada del vehículo PPU: " + vehiculoBuscado.getPpu() + "</h2>");
                } else {
                    out.println("<h2> Ha excedido el tiempo máximo para eliminar la entrada del vehículo PPU: " + vehiculoBuscado.getPpu() + "</h2>");
                }

            } else {
                String FechaSal = vehiculoBuscado.getFechaSalida();
                String horaSal = vehiculoBuscado.getHoraEntrada();

                if (datosVehiculos.realizaCambio(FechaSal, horaSal, fechaSistema, horaSistema)) {
                    vehiculoBuscado.setFechaSalida(null);
                    vehiculoBuscado.setHoraSalida(null);
                    vehiculoBuscado.setRutPersonalSalida(null);
                    vehiculoBuscado.setMontoCancelado(0);
                    vehiculoBuscado.setRetirado(false);
                    registroFacade.edit(vehiculoBuscado);
                    out.println("<h2> Ha sido cancelada la salida del vehículo PPU: " + vehiculoBuscado.getPpu() + "</h2>");
                    out.println("<h3> Para registra la salida correspondiente utilice la página de Control Vehicular </h3>");
                } else {
                    out.println("<h2> Ha excedido el tiempo máximo para modificar la salida del vehículo PPU: " + vehiculoBuscado.getPpu() + "</h2>");
                }
            }
            out.println("<br>");
            out.println("<br>");
            out.println("<br> <a href='listadoVehiculos'> Volver al Listado de Vehiculos</a>");
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
