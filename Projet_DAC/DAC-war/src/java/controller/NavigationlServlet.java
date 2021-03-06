/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ClientFacade;

/**
 *
 * @author Nicob
 */
@WebServlet(name = "NavigationServlet", 
        urlPatterns = {"/index", 
                       "/AccueilG",
                       "/AccueilC",
                       "/AchatsG",
                       "/AchatsC",
                       "/SAVG",
                       "/SAVC",
                       "/Connexion",
                       "/ServicesG",
                       "/ServicesC",
                       "/FideliteG",
                       "/FideliteC",
                       "/LocationG",
                       "/LocationC",
                       "/ServicesC",
                       "/ProduitG",
                       "/ProduitC",
                       "/Panier",
                       "/Historique",
                       "/CritereLocationG",
                       "/CritereLocationC",
        })
public class NavigationlServlet extends HttpServlet {
    
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userPath = request.getServletPath();
        String url="";
        if (userPath.equals("/AccueilG") 
                || userPath.equals("/AccueilC")
                || userPath.equals("/AchatsG")
                || userPath.equals("/AchatsC")
                || userPath.equals("/Connexion")
                || userPath.equals("/FideliteG")
                || userPath.equals("/FideliteC")
                || userPath.equals("/LocationG")
                || userPath.equals("/LocationC")
                || userPath.equals("/SAVG")
                || userPath.equals("/SAVC")
                || userPath.equals("/ServicesG")
                || userPath.equals("/ServicesC")
                || userPath.equals("/ProduitG")
                || userPath.equals("/ProduitC")
                || userPath.equals("/Panier")
                || userPath.equals("/Historique")
                || userPath.equals("/CritereLocationG")
                || userPath.equals("/CritereLocationC")
                || userPath.equals("/index")) {
        
            url = "/WEB-INF/view" + userPath + ".jsp";

        }
        
        
            request.getRequestDispatcher(url).forward(request, response);
        
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
        processRequest(request, response);
        
        
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
