
package br.com.aplcurso.dao;

import br.com.aplcurso.model.Jogo;
import br.com.aplcurso.model.Time;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TimeDAO implements GenericDAO{
    private Connection conexao;

    public TimeDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Time oTime = (Time) objeto;
        Boolean retorno = false;
        if (oTime.getIdTime()== 0) {
            retorno = this.inserir(oTime);
        } else {
            retorno = this.alterar(oTime);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Time oTime = (Time) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into times(nometime,idjogo) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oTime.getNomeTime());
            stmt.setInt(2, oTime.getIdJogo().getIdJogo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Time Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Time oTime = (Time) objeto;
        PreparedStatement stmt = null;
        String sql = "update times set nometime = ?,idjogo=? where idtime=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oTime.getNomeTime());
            stmt.setInt(2, oTime.getIdJogo().getIdJogo());
            stmt.setInt(3, oTime.getIdTime());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Time Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idTime = numero;
        PreparedStatement stmt = null;
        String sql = "delete from times where idtime=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTime);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Time! Erro: " + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rollback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }

    }

    @Override
    public Object carregar(int numero) {
        int idTime = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Time oTime = null;
        String sql = "select * from times where idtime=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTime);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oTime = new Time();
                oTime.setIdTime(rs.getInt("idTime"));
                oTime.setNomeTime(rs.getString("nomeTime"));

                JogoDAO oJogoDAO = new JogoDAO();
                oTime.setIdJogo((Jogo) oJogoDAO.carregar(rs.getInt("idjogo")));
            }
            return oTime;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Time! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select*from times order by idjogo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Time oTime = new Time();
                oTime.setIdTime(rs.getInt("idTime"));
                oTime.setNomeTime(rs.getString("nomeTime"));

                JogoDAO oJogoDAO = null;
                try {
                    oJogoDAO = new JogoDAO();
                } catch (Exception ex) {
                    System.out.println("Erro buscar jogo " + ex.getMessage());
                    ex.printStackTrace();
                }
                oTime.setIdJogo((Jogo) oJogoDAO.carregar(rs.getInt("idjogo")));
                resultado.add(oTime);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Time! Erro: " + ex.getMessage());
        }
        return resultado;
    }
}
