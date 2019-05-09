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
 * @author Nikhil
 */
public class UpdateStudent extends HttpServlet {

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
        String rno = request.getParameter("rollno");
        ResultSet rs=DataManager.executeQuery("select * from studentmaster where rollno="+rno);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            rs.next();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=center> "+"<u>UPDATION FORM</u>"+"</h1>");
            out.println("<form action='UpdateStudent2' method=post align=center>");
            out.println("<table align=center>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<td>"+"feilds"+"</td>");
            out.println("<td>"+"details"+"</td>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>"+"Enrollmentno"+"</td>");
            out.println("<td>"+"<input type='text' required='required'  name='enrollmentno' value='"+rs.getString("enrollmentno")+"' />"+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+"Student name"+"</td>");
            out.println("<td>"+"<input type='text' required='required'  name='sname' value='"+rs.getString("sname")+"' />"+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+"Father name"+"</td>");
            out.println("<td>"+"<input type='text' required='required'  name='fname' value='"+rs.getString("fname")+"' />"+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+"gender"+"</td>");
            if(rs.getString("gender").equals("Male")){
                out.println("<td>"+"male"+"<input type='radio' required='required'  name='gender' checked value='Male' />");
                out.println("female"+"<input type='radio' required='required'  name='gender'  value='Female' />"+"</td>");
            }
            else{
                out.println("<td>"+"male"+"<input type='radio' required='required'  name='gender'  value='Male' />");
                out.println("female"+"<input type='radio' required='required'  name='gender' checked value='Female' />"+"</td>");
            }
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+"Mobile number"+"</td>");
            out.println("<td>"+"<input type='number' required='required'  name='mobileno' value='"+rs.getString("mobileno")+"' />"+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+"Email ID"+"</td>");
            out.println("<td>"+"<input type='email' required='required'  name='emailid' value='"+rs.getString("emailid")+"' />"+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+"<input type='submit'/>"+"</td>");
            out.println("<td>"+"<input type='reset' />"+"</td>");
            out.println("</tr>");
           
           
            out.println("</tbody>");
            out.println("</table>");
            out.println("<input type=hidden name=rollno value='"+rno+"' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
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
