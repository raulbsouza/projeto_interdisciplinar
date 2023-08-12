package br.com.aplcurso.dao;

import br.com.aplcurso.model.Jogador_lol;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorlolDAO implements GenericDAO {

    private Connection conexao;

    public JogadorlolDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Jogador_lol oJogador = (Jogador_lol) objeto;
        Boolean retorno = false;
        if (oJogador.getIdJogadorLOL() == 0) {
            retorno = this.inserir(oJogador);
        } else {
            retorno = this.alterar(oJogador);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Jogador_lol oJogador = (Jogador_lol) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into jogador_lol(nomejogador,kda,csminute,goldminute,participacao) values(?,?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oJogador.getNomeJogadorLOL());
            stmt.setDouble(2, oJogador.getCsMinute());
            stmt.setDouble(3, oJogador.getKdaJogadorLOL());
            stmt.setInt(4, oJogador.getGoldMinute());
            stmt.setString(5, oJogador.getPart());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar o Jogador! Erro: " + ex.getMessage());
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
        Jogador_lol oJogador = (Jogador_lol) objeto;
        PreparedStatement stmt = null;
        String sql = "update jogador_lol set nomejogador=? ,kda=?,csminute=?,goldminute=?,participacao=? where idjogador = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oJogador.getNomeJogadorLOL());
            stmt.setDouble(2, oJogador.getCsMinute());
            stmt.setDouble(3, oJogador.getKdaJogadorLOL());
            stmt.setInt(4, oJogador.getGoldMinute());
            stmt.setString(5, oJogador.getPart());
            stmt.setInt(6, oJogador.getIdJogadorLOL());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Jogador! Erro: " + ex.getMessage());
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
        int idJogadorLOL = numero;
        PreparedStatement stmt = null;

        String sql = "delete from jogador_lol where idjogador=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idJogadorLOL);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir Jogador! Erro: " + ex.getMessage());
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
        int idJogadorLOL = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jogador_lol oJogador = null;
        String sql = "select * from jogador_lol where idjogador=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idJogadorLOL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oJogador = new Jogador_lol();
                oJogador.setIdJogadorLOL(rs.getInt("idjogador"));
                oJogador.setNomeJogadorLOL(rs.getString("nomejogador"));    
                oJogador.setKdaJogadorLOL(rs.getDouble("kda"));
                oJogador.setCsMinute(rs.getDouble("csminute"));
                oJogador.setGoldMinute(rs.getInt("goldminute"));
                oJogador.setPart(rs.getString("participacao"));
            }
            return oJogador;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Jogadores! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from jogador_lol order by idjogador";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Jogador_lol oJogador = new Jogador_lol();
                oJogador.setIdJogadorLOL(rs.getInt("idjogador"));
                oJogador.setNomeJogadorLOL(rs.getString("nomejogador"));
                oJogador.setKdaJogadorLOL(rs.getDouble("kda"));
                oJogador.setCsMinute(rs.getDouble("csminute"));
                oJogador.setGoldMinute(rs.getInt("goldminute"));
                oJogador.setPart(rs.getString("participacao"));
                resultado.add(oJogador);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Estado! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
