package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class ProfissionalDao implements InterfaceDao<Profissional> {

    PreparedStatement ps;
    ResultSet rs;
    Connection conexao;
    EspecialidadeDao eDao;
    UnidadeDao uDao;

    public ProfissionalDao() {
        eDao = new EspecialidadeDao();
        uDao = new UnidadeDao();
        conexao = new ConexaoDB().getConexao();
    }

    public List<Profissional> get() {
        String sql = "SELECT * FROM profissional";
        List<Profissional> registros = new ArrayList<>();
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional objeto = new Profissional();
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                objeto.setEmail(rs.getString("email"));
                objeto.setTelefone(rs.getString("telefone"));
                objeto.setRegistroConselho(rs.getString("registro_conselho"));
                Especialidade esp = eDao.get(rs.getLong("especialidade_id"));
                objeto.setEspecialidade(esp);
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                objeto.setUnidade(u);
                registros.add(objeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Atividade consiste em implementar os métodos sobrescritos

     public List<Profissional> get(String termoBusca) {
        String sql = "SELECT * FROM profissional WHERE nome LIKE ? OR email LIKE ? OR telefone LIKE ?";
        List<Profissional> registros = new ArrayList<>();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            ps.setString(3, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional objeto = new Profissional();
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                objeto.setEmail(rs.getString("email"));
                objeto.setTelefone(rs.getString("telefone"));
                objeto.setRegistroConselho(rs.getString("registro_conselho"));
                Especialidade esp = eDao.get(rs.getLong("especialidade_id"));
                objeto.setEspecialidade(esp);
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                objeto.setUnidade(u);
                registros.add(objeto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public Profissional get(Long id) {
        String sql = "SELECT * FROM profissional WHERE id=?";
        Profissional objeto = new Profissional();
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                objeto.setEmail(rs.getString("email"));
                objeto.setTelefone(rs.getString("telefone"));
                objeto.setRegistroConselho(rs.getString("registro_conselho"));
                Especialidade esp = eDao.get(rs.getLong("especialidade_id"));
                objeto.setEspecialidade(esp);
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                objeto.setUnidade(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objeto;
    }

    public int insert(Profissional objeto) {
        String sql = "INSERT INTO profissional (nome, email, telefone, registro_conselho, especialidade_id, unidade_id) VALUES (?, ?, ?, ?, ?, ?)";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getRegistroConselho());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public int update(Profissional objeto) {
        String sql = "UPDATE profissional SET nome=?, email=?, telefone=?, registro_conselho=?, especialidade_id=?, unidade_id=? WHERE id=?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getRegistroConselho());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            ps.setLong(7, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public int delete(Profissional objeto) {
        String sql = "DELETE FROM profissional WHERE id=?";
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
