/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author harshil
 */
public class ShowStudent extends HttpServlet {

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
            ResultSet rs =DataManager.executeQuery();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> ShowStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=center><u>STUDENT VERIFICATION</u></H1>");
            out.println("<table align=center border=1>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<td>"+"rollno"+"</td>");
            out.println("<td>"+"enrollmentno"+"</td>");
            out.println("<td>"+"sname"+"</td>");
            out.println("<td>"+"fname"+"</td>");
            out.println("<td>"+"gender"+"</td>");
            out.println("<td>"+"mobileno"+"</td>");
            out.println("<td>"+"EmailId"+"</td>");
            out.println("<td>"+"update"+"</td>");
            out.println("<td>"+"remove"+"</td>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr>");
            try {
                while(rs.next()){
                    out.println("<td>"+rs.getString("rollno")+"</td>");
                    out.println("<td>"+rs.getString("enrollmentno")+"</td>");
                    out.println("<td>"+rs.getString("sname")+"</td>");
                    out.println("<td>"+rs.getString("fname")+"</td>");
                    out.println("<td>"+rs.getString("gender")+"</td>");
                    out.println("<td>"+rs.getString("mobileno")+"</td>");
                    out.println("<td>"+rs.getString("emailid")+"</td>");
                    out.println("<td>"+"<a href='UpdateStudent?rollno="+rs.getInt("rollno")+"' >update</a>"+"</td>");
                    out.println("<td>"+"<a href='DeleteStudent?rollno="+rs.getInt("rollno")+"' >delete</a>"+"</td>");
                    out.println("</tr>");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<tr>");
            out.println("<td colspan=9>"+"<a href='AddStudentForm.html' >add new student</a>"+"</td>");
            out.println("</tr>");
           
            out.println("</tbody>");
            out.println("</table>");
            //out.println("<a href='AddStudentForm.html' >add new student</a>");
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
