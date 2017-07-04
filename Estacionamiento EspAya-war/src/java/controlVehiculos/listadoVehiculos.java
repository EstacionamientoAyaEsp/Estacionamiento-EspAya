/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlVehiculos;

import SessionBean.DatosVehiculosLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
public class listadoVehiculos extends HttpServlet {

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
        
        List <Registro> listaVehiculos = registroFacade.listadoVehiculosEntrado(false);
        
        
        request.setAttribute("listaDeVehiculos", listaVehiculos);
        
        //RequestDispatcher dp = request.getRequestDispatcher("controlVehicular.jsp");
        //dp.forward(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet listadoVehiculos</title>"); 
            out.println("<link href=\"css/semantic.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"ui center aligned segment\"><table class=\"ui teal celled table\" aling='center'>"); 
            out.println("<thead>"); 
            out.println("<tr>"); 
            out.println("<th>ID</td>");
            out.println("<th>PPU</td>");
            out.println("<th>FECHA INGRESO</th>");
            out.println("<th> HORA INGRESO </th>");
            out.println("<th> FECHA SALIDA </th>");
            out.println("<th> HORA SALIDA </th>");
            out.println("<th> MONTO A CANCELAR </th>");
            out.println("<th> ELIMINAR </th>");
            out.println("</tr>");
            out.println("</thead>"); 
            out.println("<tbody>"); 
            out.println("<tr>");
            for (Registro r: listaVehiculos){
            out.println("<td>"+r.getId()+"</th>");
            out.println("<td>"+r.getPpu()+"</th>");
            out.println("<td>"+r.getFechaEntrada()+"</td>");
            out.println("<td>"+r.getHoraEntrada()+"</td>");
            out.println("<td>"+datosVehiculos.borrarNull(r.getFechaSalida())+"</td>");
            out.println("<td>"+datosVehiculos.borrarNull(r.getHoraSalida())+"</td>");
            out.println("<td>"+datosVehiculos.borrarCero(r.getMontoCancelado())+"</td>");
            out.println("<td> <a class=\"ui teal small  button\" href='eliminarRegistro?idV="+r.getId()+"&estado="+r.isRetirado()+"'> "+datosVehiculos.eliminaEdita(r.isRetirado())+" </a> </td>");
            out.println("</tr>");}
            out.println("</table>");
            out.println("</br>");
            out.println("</br>");
            out.println("<a href='controlVehicular.jsp' class=\"ui teal small  button\"> Volver a control vehicular </a></div>");
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
