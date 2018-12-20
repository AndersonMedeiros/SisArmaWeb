/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author alan
 */
@WebServlet(name = "ControllerRelatorios", urlPatterns = {"/ControllerRelatorios"})
public class ControllerRelatorios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        /*    int op = Integer.parseInt(request.getParameter("op"));
        
        switch (op) {
        case 1:
        try {
        
        //                   List<Salaries> ls = new Relatorios().salarioPorEmpregadoId(Integer.parseInt(request.getParameter("idEmployees")));
        //                 request.setAttribute("lista", ls);
        request.getRequestDispatcher("particular.jsp").forward(request, response);
        } catch (Exception ex) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        break;
        
        case 2:
        String de = request.getParameter("idDepartaments");
        {
        //                List<Dept_emp> lde = new Relatorios().aniversariantesPorDep(de);
        //                request.setAttribute("listaDept_emp", lde);
        request.getRequestDispatcher("aniversariantes.jsp").forward(request, response);
        }
        
        break;
        
        case 3:
        int id = Integer.parseInt(request.getParameter("id"));
        {
        //              List<Titles> lt = new Relatorios().funcPromovidosId(id);
        //              request.setAttribute("lt", lt);
        request.getRequestDispatcher("promocoes.jsp").forward(request, response);
        }
        
        break;
        }*/

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
