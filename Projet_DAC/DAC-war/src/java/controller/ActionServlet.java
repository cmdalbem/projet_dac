/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;

/**
 *
 * @author DARK
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet","/creerClient"})
public class ActionServlet extends HttpServlet {
 @EJB
    private ClientFacade clientFacade;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  protected void ajouterClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String adresse=request.getParameter("adresse");
        long telephone=Long.parseLong(request.getParameter("telephone"));
        String mail=request.getParameter("mail");
        String mdp=request.getParameter("mdp");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance;
        try {
            dateNaissance = dateFormat.parse(request.getParameter("dateNaissance"));
            
            clientFacade.creerClient(  nom,  prenom,  adresse,  telephone,  mail,  mdp, dateNaissance);
            RequestDispatcher view=request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NavigationlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        //message javascript ou page html confirmant la creation du compte
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] path = request.getServletPath().split("/");
       String action = path[path.length - 1];
        if (action.equals("creerClient")) {
           
               ajouterClient( request, response);
           
        }
        else{
        
        
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
