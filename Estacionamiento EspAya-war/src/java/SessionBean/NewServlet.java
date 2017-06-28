/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author camilo
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/hora.html"})
public class NewServlet extends HttpServlet {
    Calendar fechahora = new GregorianCalendar();
    String Fecha =fechahora.get(Calendar.DAY_OF_MONTH) + "/" +
                (fechahora.get(Calendar.MONTH)+1) + "/" +
                fechahora.get(Calendar.YEAR);
    String Hora= fechahora.get(Calendar.HOUR_OF_DAY) + ":" +
                fechahora.get(Calendar.MINUTE) + ":" +
                fechahora.get(Calendar.SECOND);

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            

            out.println("<script language=\"JavaScript\">\n" +
"\n" +
"function actualizaReloj(){\n" +
"\n" +
"marcacion = new Date()\n" +
"Hora = marcacion.getHours()\n" +
"Minutos = marcacion.getMinutes()\n" +
"Segundos = fechahora.get(Calendar.SECOND) \n" +
"if (Hora<=9)\n" +
"Hora = \"0\" + Hora\n" +
"if (Minutos<=9)\n" +
"Minutos = \"0\" + Minutos\n" +
"if (Segundos<=9)\n" +
"Segundos = \"0\" + Segundos\n" +
"var Dia = new Array(\"Domingo\", \"Lunes\", \"Martes\", \"Miércoles\", \"Jueves\", \"Viernes\", \"Sábado\", \"Domingo\");\n" +
"var Mes = new Array(\"Enero\",\"Febrero\",\"Marzo\",\"Abril\",\"Mayo\",\"Junio\",\"Julio\",\"Agosto\",\"Septiembre\",\"Octubre\",\"Noviembre\",\"Diciembre\");\n" +
"var Hoy = new Date();\n" +
"var Anio = Hoy.getFullYear();\n" +
"var Fecha = \"Hoy es \" + Dia[Hoy.getDay()] + \", \" + Hoy.getDate() + \" de \" + Mes[Hoy.getMonth()] + \" de \" + Anio + \", a las \";\n" +
"var Inicio, Script, Final, Total\n" +
"Inicio = \"<font size=3 color=red>\"\n" +
"Script = Fecha + Hora + \":\" + Minutos + \":\" + Segundos\n" +
"Final = \"</font>\"\n" +
"Total = Inicio + Script + Final\n" +
"document.getElementById('Fecha_Reloj').innerHTML = Total\n" +
"setTimeout(\"actualizaReloj()\",1000)\n" +
"}\n" +
"</script>");
            out.println("<body onload=\"actualizaReloj()\">");
            out.println("<h1 id=\"Fecha_Reloj\"></h1>");
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
