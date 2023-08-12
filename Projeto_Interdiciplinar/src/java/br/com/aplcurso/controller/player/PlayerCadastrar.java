/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplcurso.controller.player;

import br.com.aplcurso.dao.GenericDAO;
import br.com.aplcurso.dao.PlayersDAO;
import br.com.aplcurso.model.Jogo;
import br.com.aplcurso.model.Player;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PlayerCadastrar", urlPatterns = {"/PlayerCadastrar"})
public class PlayerCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idPlayer = Integer.parseInt(request.getParameter("idplayer"));
        int idJogo = Integer.parseInt(request.getParameter("idjogo"));
        String nome = request.getParameter("nome");
        String mensagem = null;

        try {

            Player oPlayer = new Player();
            oPlayer.setIdPlayer(idPlayer);
            oPlayer.setNome(nome);
            oPlayer.setIdJogo(new Jogo(idJogo, "", ""));

            GenericDAO dao = new PlayersDAO();
            if (dao.cadastrar(oPlayer)) {
                mensagem = "Player cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Player. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("PlayerListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Player! Erro: " + ex.getMessage());
            ex.printStackTrace();
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
