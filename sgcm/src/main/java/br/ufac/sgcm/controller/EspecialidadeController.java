package br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.model.Especialidade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EspecialidadeController {
    EspecialidadeDao eDao;

    public EspecialidadeController() {
        eDao = new EspecialidadeDao();
    }

    public List<Especialidade> get() {
        return eDao.get();
    }

    public List<Especialidade> get(String termoBusca) {
        return eDao.get(termoBusca);
    }

    public Especialidade get(Long id) {
        return eDao.get(id);
    }

    public int insert(Especialidade objeto) {
        return eDao.insert(objeto);
    }

    public int update(Especialidade objeto) {
        return eDao.update(objeto);
    }

    public int delete(Especialidade objeto) {
        return eDao.delete(objeto);
    }

    // Método que usa servlet
    public List<Especialidade> processList(HttpServletRequest req, HttpServletResponse res) {
        List<Especialidade> registros = new ArrayList<>();
        String paramExcluir = req.getParameter("excluir");
        if (paramExcluir != null && !paramExcluir.isEmpty()){
            Long id = Long.parseLong(paramExcluir);
            Especialidade objeto = this.get(id);
            this.delete(objeto);
        }
        registros = this.get();
        return registros;
    }

    public Especialidade processRequest(HttpServletRequest req, HttpServletResponse res) {
        Especialidade objeto = new Especialidade();
        String paramSubmit = req.getParameter("submit");
        String paramId = req.getParameter("id");
        String paramNome = req.getParameter("nome");
        if (paramId != null && !paramId.isEmpty()) { //Verifica se clicou no link para editar
            Long id = Long.parseLong(paramId); 
            objeto = this.get(id);      //Preenche o objeto com uma linha do banco de dados
        }
        if (paramSubmit != null) {      //Verifica se clicou no botão enviar do form
            objeto.setNome(paramNome);  //Altera o conteúdo do objeto com o parâmetro da requisição (conteúdo do input no HTML)
            if (objeto.getId() == null) //Se o objeto não tem id, significa uma inseção
                this.insert(objeto);
            else                        //Caso contrário, significa uma edição
                this.update(objeto);
            try {
                res.sendRedirect("especialidade.jsp"); //Em seguida, redirecional para a página de listagem
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return objeto;
    }
}
