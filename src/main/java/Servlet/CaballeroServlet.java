package Servlet;

import modelo.dao.CaballeroDAO;
import modelo.bean.Caballero;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/verCaballeros")
public class CaballeroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 CaballeroDAO caballeroDAO = new CaballeroDAO();
         ArrayList<Caballero> caballeros = caballeroDAO.getAllCaballeros();

         request.setAttribute("caballeros", caballeros);
         request.getRequestDispatcher("/verCaballeros.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
