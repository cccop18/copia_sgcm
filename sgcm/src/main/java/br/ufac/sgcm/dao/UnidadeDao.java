package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }

    public List<Unidade> get() {
        return null;
    }

    public int insert(Unidade objeto) {
        return 0;
    }

    public int update(Unidade objeto) {
        return 0;
    }

    public int delete(Unidade objeto) {
        return 0;
    }
}
