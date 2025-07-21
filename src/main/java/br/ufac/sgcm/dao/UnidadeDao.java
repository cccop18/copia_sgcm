package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Unidade;

public class UnidadeDao implements InterfaceDao<Unidade> {

    PreparedStatement ps;
    ResultSet rs;
    Connection conexao;

    public UnidadeDao() {
        conexao = new ConexaoDB().getConexao();
    }

    public Unidade get(Long id) {
        Unidade u = new Unidade();
        String sql = "SELECT * FROM unidade WHERE id=?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    // Atividade consiste em implementar os métodos sobrescritos

    public List<Unidade> get(String termoBusca) {
        String sql = "SELECT * FROM unidade WHERE nome LIKE ? OR endereco LIKE ?";
        List<Unidade> registros = new ArrayList<>();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade objeto = new Unidade();
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                objeto.setEndereco(rs.getString("endereco"));
                registros.add(objeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public List<Unidade> get() {
        String sql = "SELECT * FROM unidade";
        List<Unidade> registros = new ArrayList<>();
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade objeto = new Unidade();
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                objeto.setEndereco(rs.getString("endereco"));
                registros.add(objeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int insert(Unidade objeto) {
        String sql = "INSERT INTO unidade (nome, endereco) VALUES (?, ?)";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEndereco());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public int update(Unidade objeto) {
        String sql = "UPDATE unidade SET nome=?, endereco=? WHERE id=?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEndereco());
            ps.setLong(3, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public int delete(Unidade objeto) {
        String sql = "DELETE FROM unidade WHERE id=?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}

