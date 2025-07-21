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
        return null;
    }

    public Profissional get(Long id) {
        return null;
    }

    public int insert(Profissional objeto) {
        return 0;
    }

    public int update(Profissional objeto) {
        return 0;
    }

    public int delete(Profissional objeto) {
        return 0;
    }
}
