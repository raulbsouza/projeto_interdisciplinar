
package br.com.aplcurso.controller.time;

import br.com.aplcurso.dao.GenericDAO;
import br.com.aplcurso.dao.TimeDAO;
import br.com.aplcurso.model.Jogo;
import br.com.aplcurso.model.Time;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TimeCadastrar", urlPatterns = {"/TimeCadastrar"})
public class TimeCadastrar extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idTime = Integer.parseInt(request.getParameter("idtime"));
        int idJogo = Integer.parseInt(request.getParameter("idjogo"));
        String nomeTime = request.getParameter("nometime");
        String mensagem = null;

        try {

            Time oTime = new Time();
            oTime.setIdTime(idTime);
            oTime.setNomeTime(nomeTime);
            oTime.setIdJogo(new Jogo(idJogo, "", ""));

            GenericDAO dao = new TimeDAO();
            if (dao.cadastrar(oTime)) {
                mensagem = "Time cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Time. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("TimeListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Time! Erro: " + ex.getMessage());
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
