package cl.espaya.estacionamiento;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reclamos.do")
public class reclamosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String ppu = req.getParameter("ppu");
        String tipoMensaje = req.getParameter("tipoMensaje");
        String mensaje = req.getParameter("mensaje");
        ppu = ppu.toUpperCase();
        req.setAttribute("textoNombre", nombre);
        req.setAttribute("textoApellido", apellido);
        req.setAttribute("textoEmail", email);
        req.setAttribute("textoPpu", ppu);
        req.setAttribute("textoTipoMensaje", tipoMensaje);
        req.setAttribute("textoMensaje", mensaje);
        RequestDispatcher dp = req.getRequestDispatcher("reclamoenviado.jsp");
        dp.forward(req, resp);

    }

}
