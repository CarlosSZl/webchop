/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import beans.beanProducto;
import dao.DaoProductos;
import dao.DaoVentas;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
@WebServlet(name = "ServletVentas", urlPatterns = {"/ServletVentas"})
public class ServletVentas extends HttpServlet {

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
            out.println("<title>Servlet ServletVentas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletVentas at " + request.getContextPath() + "</h1>");
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
        
        int in=Integer.parseInt(request.getParameter("in"));
        DaoVentas ventas= new DaoVentas();
        HttpSession sesion= request.getSession();
        String user = (String) sesion.getAttribute("sUsuario");
        
        if(in==0){
           List<beanProducto> productosList = (List<beanProducto>) request.getSession().getAttribute("productosCarro");
           
           for(beanProducto producto : productosList){
               ventas.addVenta(producto.getProductoID(), user);
           }
           response.sendRedirect("historial.jsp");
           
           List<beanProducto> productosHistorialList = new ArrayList<beanProducto>();
           productosHistorialList = ventas.getProductosVenta(user);
           sesion.setAttribute("productosHistorial", productosHistorialList);

        }
        if(in==2){
           List<beanProducto> productosHistorialList = new ArrayList<beanProducto>();
           productosHistorialList = ventas.getProductosVenta(user);
           sesion.setAttribute("productosHistorial", productosHistorialList);
           
           response.sendRedirect("historial.jsp");
        }
       
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
