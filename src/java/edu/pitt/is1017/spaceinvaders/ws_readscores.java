/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.pitt.is1017.spaceinvaders.DbUtilities;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Troy Dinkel
 * tad55@pitt.edu
 */
@WebServlet(urlPatterns = {"/ws_readscores"})
public class ws_readscores extends HttpServlet {

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
            String sql = "SELECT lastName, firstName, MAX(scoreValue) AS highestScore FROM finalscores JOIN users ON fk_userID = userID GROUP BY lastName, firstName ORDER BY `MAX(scoreValue)` DESC LIMIT 5;";
            
            DbUtilities db = new DbUtilities();
            
            try{
                ResultSet rs = db.getResultSet(sql);
                JSONArray userList = new JSONArray();
                
                while(rs.next()){
                   
                    JSONObject user = new JSONObject();
                    user.put("lastName", rs.getString("lastName"));
                    user.put("firstName", rs.getString("firstName"));
                    user.put("highestScore", rs.getString("highestScore"));
                    userList.put(user);
                   
                }
               JSONObject leaders = new JSONObject();
               leaders.put("Leaders", userList);
               
               out.print(leaders.toString());
            }catch(SQLException ex)
                  {
                Logger.getLogger(ws_readscores.class.getName()).log(Level.SEVERE,null,ex);
            } } catch (JSONException ex) {
                        Logger.getLogger(ws_readscores.class.getName()).log(Level.SEVERE, null, ex);
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
