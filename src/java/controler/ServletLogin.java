
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import beans.beanLogin;
import beans.beanProducto;
import dao.DaoLogin;
import dao.DaoProductos;
import dao.DaoVentas;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author carlos
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

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
            out.println("<title>Servlet ServletLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() + "</h1>");
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
        HttpSession sesion= request.getSession();
        int conf=Integer.parseInt(request.getParameter("conf"));
        if(conf==0){
            sesion.removeAttribute("sUsuario");
            sesion.invalidate();
            response.sendRedirect("index.html");
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
        System.out.print("##########DOPOST");
        HttpSession sesion= request.getSession();
        
        String usuario=request.getParameter("txtUsuario");
        String clave=request.getParameter("txtPassword");
        beanLogin user= new beanLogin();
        DaoLogin login= new DaoLogin();
        beanLogin obj= new beanLogin();
        
        user.setUsuario(usuario);
        user.setClave(clave);
 
        obj=login.Logueo(user);
        
        if(obj==null || obj.getUsuario()==null){
            response.sendRedirect("error.jsp");
        }else{
            response.sendRedirect("principal.jsp");
            sesion.setAttribute("sUsuario", obj.getUsuario());
        }
        
        //DATA PRODUCTOS
        DaoProductos productos= new DaoProductos();
        List<beanProducto> productosList = new ArrayList<beanProducto>(); 
        productosList = productos.getProductos();
        sesion.setAttribute("productos", productosList);
        
        // DATA CARRO
        List<beanProducto> productosCarroList = new ArrayList<beanProducto>();
        productosCarroList = productos.getProductosCarro(usuario);
        sesion.setAttribute("productosCarro", productosCarroList);
        
        
        //DATA HISTORIAL
        DaoVentas ventas= new DaoVentas();
        List<beanProducto> productosHistorialList = new ArrayList<beanProducto>();
        productosHistorialList = ventas.getProductosVenta(usuario);
        sesion.setAttribute("productosHistorial", productosHistorialList);
        
  
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
