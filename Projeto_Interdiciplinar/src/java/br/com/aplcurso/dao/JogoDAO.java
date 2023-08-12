package br.com.aplcurso.dao;

import br.com.aplcurso.model.Jogo;
import br.com.aplcurso.model.Tipo;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO implements GenericDAO {

    private Connection conexao;

    public JogoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Jogo oJogo = (Jogo) objeto;
        Boolean retorno = false;
        if (oJogo.getIdJogo()== 0) {
            retorno = this.inserir(oJogo);
        } else {
            retorno = this.alterar(oJogo);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Jogo oJogo = (Jogo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into jogo(descricao,tipo) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oJogo.getDescricao());
            stmt.setString(2, oJogo.getTipo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Jogo Erro: " + ex.getMessage());
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
        Jogo oJogo = (Jogo) objeto;
        PreparedStatement stmt = null;
        String sql = "update jogo set descricao = ?,tipo=? where idjogo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oJogo.getDescricao());
            stmt.setString(2, oJogo.getTipo());
            stmt.setInt(3, oJogo.getIdJogo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Jogo Erro: " + ex.getMessage());
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
        int idJogo = numero;
        PreparedStatement stmt = null;
        String sql = "delete from jogo where idjogo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idJogo);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Jogo! Erro: " + ex.getMessage());
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
        int idJogo = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jogo oJogo = null;
        String sql = "select * from jogo where idjogo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idJogo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oJogo = new Jogo();
                oJogo.setIdJogo(rs.getInt("idJogo"));
                oJogo.setDescricao(rs.getString("descricao"));
                oJogo.setTipo(rs.getString("tipo"));
            }
            return oJogo;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Jogo! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select*from jogo order by idjogo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Jogo oJogo = new Jogo();
                oJogo.setIdJogo(rs.getInt("idJogo"));
                oJogo.setDescricao(rs.getString("descricao"));
                oJogo.setTipo(rs.getString("tipo"));
                resultado.add(oJogo);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Jogo! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
