/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ikaro
 */

public class boletaServlet extends HttpServlet {

    @EJB
    private CotizacionBeanLocal cotizacionBean;


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String horaIni = req.getParameter("hora_ini");
        String fechaIni = req.getParameter("fecha_ini");
        
        String horaFin = req.getParameter("hora_fin");
        String fechaFin = req.getParameter("fecha_fin");
        
        String tiempo =cotizacionBean.cotizaTiempoSer(fechaIni, horaIni, fechaFin, horaFin);
        String monto=cotizacionBean.cotizaMontoSer(fechaIni, horaIni, fechaFin, horaFin);
        
        
        req.setAttribute("fechaInicio", fechaIni);
        req.setAttribute("horaInicio", horaIni);
        req.setAttribute("fechaTermino", fechaFin);
        req.setAttribute("horaTermino", horaFin);
        req.setAttribute("tiempoUso", tiempo );
        req.setAttribute("aPagar", monto);
        RequestDispatcher dp = req.getRequestDispatcher("cotizaBoleta.jsp");
             
        dp.forward(req, resp);

    }
    
    

}