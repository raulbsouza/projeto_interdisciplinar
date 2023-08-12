package br.com.aplcurso.dao;

import br.com.aplcurso.model.Jogo;
import br.com.aplcurso.model.Player;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayersDAO implements GenericDAO {

    private Connection conexao;

    public PlayersDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Player oPlayer = (Player) objeto;
        Boolean retorno = false;
        if (oPlayer.getIdPlayer() == 0) {
            retorno = this.inserir(oPlayer);
        } else {
            retorno = this.alterar(oPlayer);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Player oPlayer = (Player) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into jogadores_geral(nome,idjogo) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPlayer.getNome());
            stmt.setInt(2, oPlayer.getIdJogo().getIdJogo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Player Erro: " + ex.getMessage());
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
        Player oPlayer = (Player) objeto;
        PreparedStatement stmt = null;
        String sql = "update jogadores_geral set nome = ?,idjogo=? where idplayer=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPlayer.getNome());
            stmt.setInt(2, oPlayer.getIdJogo().getIdJogo());
            stmt.setInt(3, oPlayer.getIdPlayer());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Player Erro: " + ex.getMessage());
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
        int idPlayer = numero;
        PreparedStatement stmt = null;
        String sql = "delete from jogadores_geral where idplayer=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPlayer);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Player! Erro: " + ex.getMessage());
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
        int idPlayer = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Player oPlayer = null;
        String sql = "select * from jogadores_geral where idplayer=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPlayer);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oPlayer = new Player();
                oPlayer.setIdPlayer(rs.getInt("idPlayer"));
                oPlayer.setNome(rs.getString("nome"));

                JogoDAO oJogoDAO = new JogoDAO();
                oPlayer.setIdJogo((Jogo) oJogoDAO.carregar(rs.getInt("idjogo")));
            }
            return oPlayer;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Player! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select*from jogadores_geral order by idjogo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Player oPlayer = new Player();
                oPlayer.setIdPlayer(rs.getInt("idPlayer"));
                oPlayer.setNome(rs.getString("nome"));

                JogoDAO oJogoDAO = null;
                try {
                    oJogoDAO = new JogoDAO();
                } catch (Exception ex) {
                    System.out.println("Erro buscar jogo " + ex.getMessage());
                    ex.printStackTrace();
                }
                oPlayer.setIdJogo((Jogo) oJogoDAO.carregar(rs.getInt("idjogo")));
                resultado.add(oPlayer);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Player! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
