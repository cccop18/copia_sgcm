package br.ufac.sgcm.model;

import java.util.List;

import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.ProfissionalDao;

public class Teste {
    public static void main(String[] args) throws Exception {
        Especialidade e1 = new Especialidade();
        e1.setId(10L);
        e1.setNome("Endocrinologia");
        System.out.println(e1.getNome());

        // Criar um objeto da classe ConxeaoDB
        // ConexaoDB conexao = new ConexaoDB();
        // Connection instancia = conexao.getConexao();

        // if (instancia != null)
        // System.out.println("Conexão realizada com sucesso!");
        // else
        // System.out.println("Falha na conexão.");

        // Testes com a conexão do banco
        // String sql = "SELECT * FROM especialidade";
        // PreparedStatement ps;
        // ResultSet rs;
        // ps = instancia.prepareStatement(sql);
        // rs = ps.executeQuery();
        // List<Especialidade> lista = new ArrayList<>();
        // while (rs.next()) {
        // Especialidade obj = new Especialidade();
        // obj.setId(rs.getLong("id"));
        // obj.setNome(rs.getString("nome"));
        // lista.add(obj);
        // }
        // for (Especialidade esp : lista)
        // System.out.println(esp);

        // Testando as classes do pacote DAO
        EspecialidadeDao eDao = new EspecialidadeDao();

        // eDao.insert(e1);
        // eDao.update(e1);
        // Teste com termo de busca
        String s = "gia";
        List<Especialidade> lista = eDao.get(s);
        for (Especialidade item : lista)
            System.out.println(item);

        // Teste com id
        Long i = 8L;
        System.out.println("Especialidade única: " + eDao.get(i));
        // Teste da exclusão
        // Especialidade esp = eDao.get(i); // Especialidade a ser deletada
        // eDao.delete(esp);
        // Verificando se excluiu a especialidade
        // lista = eDao.get(); // Atualiza a lista
        // for (Especialidade item : lista) {
        // System.out.println(item);
        // }
        // Testando a lista de profissional
        ProfissionalDao pDao = new ProfissionalDao();
        List<Profissional> listaProfissionais = pDao.get();
        for (Profissional item : listaProfissionais)
            System.out.println(item);
    }
}
