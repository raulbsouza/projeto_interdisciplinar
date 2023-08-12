
package br.com.aplcurso.dao;

import br.com.aplcurso.model.Tipo;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TipoDAO implements GenericDAO{

    private Connection conexao;

    public TipoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Tipo oTipo = (Tipo) objeto;
        Boolean retorno = false;
        if (oTipo.getIdtipo()== 0) {
            retorno = this.inserir(oTipo);
        } else {
            retorno = this.alterar(oTipo);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Tipo oTipo = (Tipo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into tipo(nome) values(?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oTipo.getNome());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar o Tipo! Erro: " + ex.getMessage());
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
        Tipo oTipo = (Tipo) objeto;
        PreparedStatement stmt = null;
        String sql = "update tipo set nome=? where idtipo = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oTipo.getNome());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o Tipo! Erro: " + ex.getMessage());
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
        int idTipo = numero;
        PreparedStatement stmt = null;

        String sql = "delete from tipo where idtipo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipo);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir Tipo! Erro: " + ex.getMessage());
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
        int idTipo = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tipo oTipo = null;
        String sql = "select * from tipo where idtipo=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oTipo = new Tipo();
                oTipo.setIdtipo(rs.getInt("idtipo"));
                oTipo.setNome(rs.getString("nome"));    
            }
            return oTipo;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Tipo! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from tipo order by idtipo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Tipo oTipo = new Tipo();
                oTipo.setIdtipo(rs.getInt("idtipo"));
                oTipo.setNome(rs.getString("nome"));
                resultado.add(oTipo);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Tipo! Erro: " + ex.getMessage());
        }
        return resultado;
    }
    
}
