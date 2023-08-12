package br.com.aplcurso.dao;

import br.com.aplcurso.model.Jogo;
import br.com.aplcurso.model.Partida;
import br.com.aplcurso.model.Time;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO implements GenericDAO {

    private Connection conexao;

    public PartidaDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Partida oPartida = (Partida) objeto;
        Boolean retorno = false;
        if (oPartida.getIdPartida() == 0) {
            retorno = this.inserir(oPartida);
        } else {
            retorno = this.alterar(oPartida);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Partida oPartida = (Partida) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into partida(idjogo,idtimeum,idtimedois,datapartida,hora)values (?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, oPartida.getIdJogo().getIdJogo());
            stmt.setInt(2, oPartida.getTimeUm().getIdTime());
            stmt.setInt(3, oPartida.getTimeDois().getIdTime());
            stmt.setDate(4, new java.sql.Date(oPartida.getDataPartida().getTime()));
            stmt.setString(5, oPartida.getHora());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Partida Erro: " + ex.getMessage());
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
        Partida oPartida = (Partida) objeto;
        PreparedStatement stmt = null;
        String sql = "update partida set idjogo=?, idtimeum=?, idtimedois=?, datapartida=?, hora=? where idpartida=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, oPartida.getIdJogo().getIdJogo());
            stmt.setInt(2, oPartida.getTimeUm().getIdTime());
            stmt.setInt(3, oPartida.getTimeDois().getIdTime());
            stmt.setDate(4, new java.sql.Date(oPartida.getDataPartida().getTime()));
            stmt.setString(5, oPartida.getHora());;
            stmt.setInt(6, oPartida.getIdPartida());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Partida Erro: " + ex.getMessage());
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
        int idPartida = numero;
        PreparedStatement stmt = null;
        String sql = "delete from partida where idpartida=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPartida);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Partida! Erro: " + ex.getMessage());
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
        int idPartida = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Partida oPartida = null;
        String sql = "select * from partida where idpartida=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPartida);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oPartida = new Partida();
                oPartida.setIdPartida(rs.getInt("idpartida"));
                oPartida.setDataPartida(rs.getDate("datapartida"));
                oPartida.setHora(rs.getString("hora"));

                JogoDAO oJogoDAO = new JogoDAO();
                TimeDAO oTimeUM = new TimeDAO();
                TimeDAO oTimeDois = new TimeDAO();
                
                oPartida.setIdJogo((Jogo) oJogoDAO.carregar(rs.getInt("idjogo")));
                oPartida.setTimeUm((Time) oTimeUM.carregar(rs.getInt("idtimeum")));
                oPartida.setTimeDois((Time) oTimeDois.carregar(rs.getInt("idtimedois")));
            }
            return oPartida;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Partida! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select*from partida order by idpartida";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Partida oPartida = new Partida();
                oPartida.setIdPartida(rs.getInt("idpartida"));
                oPartida.setDataPartida(rs.getDate("datapartida"));
                oPartida.setHora(rs.getString("hora"));

                JogoDAO oJogoDAO = null;
                TimeDAO oTimeDois = null;
                TimeDAO oTimeUm = null;
                try {
                    oJogoDAO = new JogoDAO();
                    oTimeUm = new TimeDAO();
                    oTimeDois = new TimeDAO();
                } catch (Exception ex) {
                    System.out.println("Erro buscar jogo " + ex.getMessage());
                    ex.printStackTrace();
                }
                oPartida.setIdJogo((Jogo) oJogoDAO.carregar(rs.getInt("idjogo")));
                oPartida.setTimeUm((Time) oTimeUm.carregar(rs.getInt("idtimeum")));
                oPartida.setTimeDois((Time) oTimeDois.carregar(rs.getInt("idtimedois")));
                resultado.add(oPartida);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Partida! Erro: " + ex.getMessage());
        }
        return resultado;
    }
}
