/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.saa.bookwebapp3.controller1;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.wctc.saa.bookwebapp3.model.Author;
import edu.wctc.saa.bookwebapp3.model.AuthorService;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Gladwin
 */
@WebServlet(name = "AuthorController1", urlPatterns = {"/AuthorController1"})
public class AuthorController1 extends HttpServlet {
AuthorService aus;
    
    private static final String ADD_PAGE = "Add.jsp";
    private static final String EDIT_PAGE = "Edit.jsp";
    private static final String DEST_PAGE = "Authors.jsp";
    private static final String SUBMIT_ACTION = "submit";
    private static final String DELETE_ACTION = "Delete";
    private static final String EDIT_ACTION = "Edit";
    private static final String ADD_ACTION = "Add";
    private static final String UPDATE_ACTION = "Update";
    private static final String CREATE_ACTION = "Create";
    private static final String REFRESH_ACTION = "Back to List";
    private String destination;
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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
         String destination = DEST_PAGE;
    
           // configDbConnection();

            String id = request.getParameter("author_id");
            String name = request.getParameter("author_name");
            String date = request.getParameter("date_added");
            String subAction = request.getParameter(SUBMIT_ACTION);

            //delete
            if (subAction.equals(DELETE_ACTION)) {
                if (id != null && !"".equals(id)) {
                    aus.deleteAuthorById(id);
                }
            }
            //edit
            if (subAction.equals(EDIT_ACTION)) {
                if (id != null && !"".equals(id)) {
                    Author author = aus.getAuthorById(id);
                    request.setAttribute("author", author);
                } else {
                    String error = "No Id passed into Edit.";
                    request.setAttribute("error", error);
                }
                destination = EDIT_PAGE;
            }

            //Re-direct to Add page (could just be a link, decided to show understanding of submit actions)
            if (subAction.equals(ADD_ACTION)) {
                destination = ADD_PAGE;
            }

            //update
            if (subAction.equals(UPDATE_ACTION)) {
                if (name == null || "".equals(name)) {
                    String error = "Name cannot be Empty.";
                    request.setAttribute("error", error);
                    destination = EDIT_PAGE;
                }
                aus.updateAuthor(id, name, date);
            }

            //create
            if (subAction.equals(CREATE_ACTION)) {
                if (name == null || "".equals(name)) {
                    String error = "Name cannot be Empty.";
                    request.setAttribute("error", error);
                    destination = ADD_PAGE;
                } else {
                    aus.createOneAuthor(name, new Date());
                }
            }

            //Essentially refresh the page
            if (subAction.equals(REFRESH_ACTION)) {
                List<Author> authors = aus.getAuthorList();
                request.setAttribute("authors", authors);
            }

            //display table
            List<Author> authors = aus.getAuthorList();
            request.setAttribute("authors", authors);

        } 
        
        
        // Forward to destination page
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
    


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
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(AuthorController1.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(AuthorController1.class.getName()).log(Level.SEVERE, null, ex);
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
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(AuthorController1.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(AuthorController1.class.getName()).log(Level.SEVERE, null, ex);
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
