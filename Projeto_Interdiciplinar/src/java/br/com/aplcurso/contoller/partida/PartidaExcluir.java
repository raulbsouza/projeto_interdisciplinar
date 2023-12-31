
package br.com.aplcurso.contoller.partida;

import br.com.aplcurso.dao.GenericDAO;
import br.com.aplcurso.dao.PartidaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PartidaExcluir", urlPatterns = {"/PartidaExcluir"})
public class PartidaExcluir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idPartida = Integer.parseInt(request.getParameter("idPartida"));
        String mensagem = null;
        try {
            GenericDAO dao = new PartidaDAO();
            if (dao.excluir(idPartida)) {
                mensagem = "Partida excluido com Sucesso!";
            } else {
                mensagem = "Problemas ao excluir Partida";
            }
            request.setAttribute("mensagem", mensagem);            
            response.sendRedirect("PartidaListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servelet ao excluir Partida! Erro: "+ ex.getMessage());
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
