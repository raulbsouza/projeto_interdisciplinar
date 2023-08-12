package br.com.aplcurso.dao;

import br.com.aplcurso.model.Partidalol;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartidalolDAO implements GenericDAO {

    private Connection conexao;

    public PartidalolDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Partidalol oPartida = (Partidalol) objeto;
        Boolean retorno = false;
        if (oPartida.getIdPartida()== 0) {
            retorno = this.inserir(oPartida);
        } else {
            retorno = this.alterar(oPartida);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Partidalol oPartida = (Partidalol) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into partida_lol(jogopart,camppart,teamone,teamtwo,datapart,horapart) values(?,?,?,?,?,?);";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPartida.getJogoPartida());
            stmt.setString(2, oPartida.getCampPartida());
            stmt.setString(3, oPartida.getTimeUm());
            stmt.setString(4, oPartida.getTimeDois());
            stmt.setString(5, oPartida.getDataPartida());
            stmt.setString(6, oPartida.getHoraPartida());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar o Partida! Erro: " + ex.getMessage());
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
        Partidalol oPartida = (Partidalol) objeto;
        PreparedStatement stmt = null;
        String sql = "update partida_lol set jogopart=?, camppart=?,teamone=?,teamtwo=?,datapart=?,horapart=?  where idpartida=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPartida.getJogoPartida());
            stmt.setString(2, oPartida.getCampPartida());
            stmt.setString(3, oPartida.getTimeUm());
            stmt.setString(4, oPartida.getTimeDois());
            stmt.setString(5, oPartida.getDataPartida());
            stmt.setString(6, oPartida.getHoraPartida());
            stmt.setInt(7, oPartida.getIdPartida());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Partida! Erro: " + ex.getMessage());
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

        String sql = "delete from partida_lol where idpartida=?";
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
        Partidalol oPartida = null;
        String sql = "select * from partida_lol where idpartida=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPartida);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oPartida = new Partidalol();
                oPartida.setIdPartida(rs.getInt("idpartida"));
                oPartida.setJogoPartida(rs.getString("jogopart"));
                oPartida.setCampPartida(rs.getString("camppart"));
                oPartida.setTimeUm(rs.getString("teamone"));
                oPartida.setTimeDois(rs.getString("teamtwo"));
                oPartida.setDataPartida(rs.getString("datapart"));
                oPartida.setHoraPartida(rs.getString("horapart"));
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
        String sql = "Select * from partida_lol order by idpartida";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Partidalol oPartida = new Partidalol();
                oPartida.setIdPartida(rs.getInt("idPartida"));
                oPartida.setJogoPartida(rs.getString("jogopart"));
                oPartida.setCampPartida(rs.getString("camppart"));
                oPartida.setTimeUm(rs.getString("teamone"));
                oPartida.setTimeDois(rs.getString("teamtwo"));
                oPartida.setDataPartida(rs.getString("datapart"));
                oPartida.setHoraPartida(rs.getString("horapart"));
                resultado.add(oPartida);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Partida! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
