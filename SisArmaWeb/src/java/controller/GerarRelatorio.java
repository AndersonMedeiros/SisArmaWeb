/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import bean.GeradorDeRelatorio;
import connection.FabricaConexao;

/**
 *
 * @author ander
 */
public class GerarRelatorio extends HttpServlet {

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
            out.println("<title>Servlet GerarRelatorio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GerarRelatorio at " + request.getContextPath() + "</h1>");
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
            ServletContext contexto = getServletContext();
            String jrxml = contexto.getRealPath("/relatorio_two/relatorioProntoReserva.jrxml");
            String prontoParticular = contexto.getRealPath("/relatorio_two/relatorioProntoParticular.jasper");
            String prontoReservaDetalhado = contexto.getRealPath("/relatorio_two/relatorioProntoReservaDetalhado.jasper");
            String prontoIndisponivel = contexto.getRealPath("/relatorio_two/relatorioProntoIndisponivel.jasper");
            String prontoRecolhido = contexto.getRealPath("/relatorio_two/relatorioProntoRecolhido.jasper");
            String subProntoDetalhado = contexto.getRealPath("/relatorio_two/subRelatorioProntoReservaDetalhado.jasper");
            System.out.println("vai "+ prontoParticular);
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("$P{REPORT_CONNECTION}", jrxml);
            parametros.put("$P{REPORT_CONNECTION}", prontoParticular);
            parametros.put("$P{REPORT_CONNECTION}", prontoRecolhido);
            parametros.put("$P{REPORT_CONNECTION}", prontoIndisponivel);
            parametros.put("$P{REPORT_CONNECTION}", prontoReservaDetalhado);           
            
            parametros.put("$P{REPORT_CONNECTION}", subProntoDetalhado);
            
            // abre conexão com o banco
            Connection conexao = FabricaConexao.conecta();

            // gera relatório
            GeradorDeRelatorio gerador = new GeradorDeRelatorio(conexao);
            gerador.geraPdf(jrxml, parametros, response.getOutputStream());

            try {
                conexao.close(); // não esqueça de fechar a conexão
            } catch (SQLException ex) {
                Logger.getLogger(GerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
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
