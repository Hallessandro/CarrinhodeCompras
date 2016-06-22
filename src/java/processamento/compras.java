/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processamento;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Hallessandro
 */
@WebServlet(name = "compras", urlPatterns = {"/compras"})
public class compras extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList<Produto>produtos = new ArrayList<>();
    @Override
    public void init()
            throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String produto = request.getParameter("produto");
        int op = Integer.parseInt(request.getParameter("op"));
        double total = 0;
        Produto p = new Produto();
        if(op == 1){
            if(produto.equals("mana")){
                p.setNome("Pote de Mana");
                p.setPreco(1.25);
            }else if(produto.equals("crocks")){
                p.setNome("Crocks de Combate");
                p.setPreco(20.00);
            }else if(produto.equals("calca")){
                p.setNome("Calça Setor II UFRN");
                p.setPreco(25.00);
            }else if(produto.equals("calcao")){
                p.setNome(("Calção de Força"));
                p.setPreco(10.00);
            }else if(produto.equals("escudo")){
                p.setNome(("Escudo protetor"));
                p.setPreco(800.00);
            }else if(produto.equals("camisa")){
                p.setNome(("Camisa Xavosa de Rico"));
                p.setPreco(100.00);
            }else if(produto.equals("health")){
                p.setNome(("Pote de Health"));
                p.setPreco(2.00);
            }else if(produto.equals("oculos")){
                p.setNome(("Oculos Xavoso da Ray Ban"));
                p.setPreco(120.00);
            }
            produtos.add(p);
            response.sendRedirect("index.html");
            
        }else if(op == 2){
            HttpSession session = request.getSession();
            session.setAttribute("produtos", produtos); 
            response.sendRedirect("resultado.jsp");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Total Compras</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<legend>Total de Compras</legend>");
                out.println("<table border='solid'>");
                for(Produto p1 : produtos){
                out.println("<tr>");
                out.print("<td><h4>" + p1.getNome() + "</h4></td>");
                out.print("<td><h4>" + p1.getPreco()+ " R$</h4></td>");
                total+= p1.getPreco();
                out.println("</tr>");
                }
                out.println("<tr>");
                out.print("<td><h3> Total: </h3></td>");
                out.print("<td><h3>" + total + " R$</h3></td>");
                out.println("</tr>");
                out.println("</table>");
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
