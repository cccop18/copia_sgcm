package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;

public class EspecialidadeDao implements InterfaceDao<Especialidade> {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conexao;

    public EspecialidadeDao() {
        conexao = new ConexaoDB().getConexao();
    }

    // Metodo para retornar uma lista de especialidades
    public List<Especialidade> get() {
        String sql = "SELECT * FROM especialidade";
        List<Especialidade> registros = new ArrayList<>();
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidade objeto = new Especialidade();
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                registros.add(objeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Método para listar de acordo com um termo de busca
    public List<Especialidade> get(String termoBusca) {
        String sql = "SELECT * FROM especialidade WHERE nome LIKE ?";
        List<Especialidade> registros = new ArrayList<>();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidade objeto = new Especialidade();
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                registros.add(objeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Método para retornar um única especialidade
    public Especialidade get(Long id) {
        String sql = "SELECT * FROM especialidade WHERE id=?";
        Especialidade esp = new Especialidade();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                esp.setId(rs.getLong("id"));
                esp.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esp;
    }

    // Método para inserir uma especialidade
    public int insert(Especialidade objeto) {
        String sql = "INSERT INTO especialidade (nome) VALUES (?)";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Método para atualizar
    public int update(Especialidade objeto) {
        String sql = "UPDATE especialidade SET nome=? WHERE id=?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setLong(2, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Método para excluir
    public int delete(Especialidade objeto) {
        String sql = "DELETE FROM especialidade WHERE id=?";
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
