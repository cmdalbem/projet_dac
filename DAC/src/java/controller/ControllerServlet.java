/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicob
 */
public class ControllerServlet extends HttpServlet {  
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
        
        String userPath = request.getServletPath();

        if (userPath.equals("/Accueil")) {
            // TODO: Implement category request

        } else if (userPath.equals("/AchatsC") || userPath.equals("/AchatsG")) {
            // TODO: Implement cart page request


        } else if (userPath.equals("/LocationC") || userPath.equals("/LocationG")) {
            // TODO: Implement checkout page request

        } else if (userPath.equals("/SAVC") || userPath.equals("/SAVG")) {
            // TODO: Implement language request

        } else if (userPath.equals("/FideliteC") || userPath.equals("/FideliteG")) {
            // TODO: Implement language request

        } else if (userPath.equals("/ProduitC") || userPath.equals("/ProduitG")) {
            // TODO: Implement language request

        } else if (userPath.equals("/ServicesC") || userPath.equals("/ServicesG")) {
            // TODO: Implement language request
          
        } else if (userPath.equals("/Connexion")) {
            // TODO: Implement language request

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".html";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
