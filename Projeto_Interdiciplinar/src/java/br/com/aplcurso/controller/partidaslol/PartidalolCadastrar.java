package br.com.aplcurso.controller.partidaslol;

import br.com.aplcurso.dao.GenericDAO;
import br.com.aplcurso.dao.PartidalolDAO;
import br.com.aplcurso.model.Partidalol;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PartidalolCadastrar", urlPatterns = {"/PartidalolCadastrar"})
public class PartidalolCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html/charset=iso8859-1");
        int idPartida = Integer.parseInt(request.getParameter("idpartida"));
        String jogoPartida = request.getParameter("jogopart");
        String campPartida = request.getParameter("camppart");
        String timeUm = request.getParameter("teamone");
        String timeDois = request.getParameter("teamtwo");
        String dataPartida = request.getParameter("datapart");
        String horaPartida = request.getParameter("horapart");
        String mensagem = null;

        Partidalol oPartida = new Partidalol();
        oPartida.setIdPartida(idPartida);
        oPartida.setJogoPartida(jogoPartida);
        oPartida.setCampPartida(campPartida);
        oPartida.setTimeUm(timeUm);
        oPartida.setTimeDois(timeDois);
        oPartida.setDataPartida(dataPartida);
        oPartida.setHoraPartida(horaPartida);
        try {
            GenericDAO dao = new PartidalolDAO();
            if (dao.cadastrar(oPartida)) {
                mensagem = "Patida cadastada com Sucesso!";
            } else {
                mensagem = "Problemas ao cadastar partida. Verifique os dados informados e tente novamente";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("PartidalolListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Partida! Erro: " + ex.getMessage());

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
