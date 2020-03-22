/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.servlet;

import backend.core.Doomsday;
import backend.core.Validator;
import backend.model.SpecificDate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anton
 */
public class FormServlet extends HttpServlet {

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
            out.println("<title>Servlet FormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        int day = Integer.parseInt(request.getParameter("day"));
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));
        
        request.setAttribute("day", day);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        
        Validator val = new Validator();
        SpecificDate date = new SpecificDate(day, month, year);
        System.out.println(val.validate(date));
        System.out.println(val.getErrorMessage());
        if(val.validate(date)){
            request.setAttribute("errorMsg", null);
            Doomsday doomsday = new Doomsday(date);
            switch(doomsday.findDay()){
                case 1:
                    request.setAttribute("dayOfTheWeek", "Domingo");
                    break;
                case 2:
                    request.setAttribute("dayOfTheWeek", "Segunda-feira");
                    break;
                case 3:
                    request.setAttribute("dayOfTheWeek", "Terça-feira");
                    break;
                case 4:
                    request.setAttribute("dayOfTheWeek", "Quarta-feira");
                    break;
                case 5:
                    request.setAttribute("dayOfTheWeek", "Quinta-feira");
                    break;
                case 6:
                    request.setAttribute("dayOfTheWeek", "Sexta-feira");
                    break;
                default:
                    request.setAttribute("dayOfTheWeek", "Sábado");
                    break;
                    
            }
        }
        else{
            request.setAttribute("errorMsg", val.getErrorMessage());   
        }
        
        request.getRequestDispatcher("dia.jsp").forward(request, response);
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
