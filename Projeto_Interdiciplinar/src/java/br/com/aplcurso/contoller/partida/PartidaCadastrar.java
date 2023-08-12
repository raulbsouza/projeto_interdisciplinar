/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.aplcurso.contoller.partida;

import br.com.aplcurso.dao.GenericDAO;
import br.com.aplcurso.dao.PartidaDAO;
import br.com.aplcurso.model.Jogo;
import br.com.aplcurso.model.Partida;
import br.com.aplcurso.model.Time;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "PartidaCadastrar", urlPatterns = {"/PartidaCadastrar"})
public class PartidaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idPartida = Integer.parseInt(request.getParameter("idpartida"));
        int idJogo = Integer.parseInt(request.getParameter("idjogo"));
        int idTimeUm = Integer.parseInt(request.getParameter("timeUm"));
        int idTimeDois = Integer.parseInt(request.getParameter("timeDois"));
        String hora = request.getParameter("hora");
        String mensagem = null;

        try {

            Partida oPartida = new Partida();
            oPartida.setIdPartida(idPartida);
            oPartida.setIdJogo(new Jogo(idJogo, "", ""));
            oPartida.setTimeUm(new Time(idTimeUm, (new Jogo(idJogo, "", "")), ""));
            oPartida.setTimeDois(new Time(idTimeDois, (new Jogo(idJogo, "", "")), ""));
            oPartida.setDataPartida(Date.valueOf(request.getParameter("datapartida")));
            oPartida.setHora(hora);

            GenericDAO dao = new PartidaDAO();
            if (dao.cadastrar(oPartida)) {
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
//        int idJogo = Integer.parseInt(request.getParameter("idjogo"));
//        int timeUm = Integer.parseInt(request.getParameter("timeum"));
//        int timeDois = Integer.parseInt(request.getParameter("timedois"));
//        String mensagem = null;
//        try {
//            Partida oPartida = new Partida();
//            oPartida.setIdPartida(Integer.parseInt(request.getParameter("idpartida")));
//            oPartida.setIdJogo(new Jogo(idJogo, "", ""));
//            oPartida.setTimeUm(new Time(timeUm, (new Jogo(idJogo, "", "")), ""));
//            oPartida.setTimeDois(new Time(timeDois, (new Jogo(idJogo, "", "")), ""));
//            oPartida.setDataPartida(Date.valueOf(request.getParameter("datapartida")));
//            oPartida.setHora(request.getParameter("hora"));
//           
//            PartidaDAO dao = new PartidaDAO();
//            
//            if (dao.cadastrar(oPartida)) {
//                mensagem = "Partida cadastrado com sucesso!";
//            } else {
//                mensagem = "Problemas ao cadastrar Partida. Verifique os dados informados e tente novamente!";
//            }
//            request.setAttribute("mensagem", mensagem);
//            response.sendRedirect("PartidaListar");
//        } catch (Exception ex) {
//            System.out.println("Problemas no Servlet ao cadastrar Partida! Erro: " + ex.getMessage());
//            ex.printStackTrace();
//        }
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
