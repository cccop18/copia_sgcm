package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.UnidadeDao;
import br.ufac.sgcm.model.Unidade;

public class UnidadeController {

    UnidadeDao uDao;

    public UnidadeController() {
        uDao = new UnidadeDao();
    }

    public List<Unidade> get() {
        return uDao.get();
    }

    public List<Unidade> get(String termoBusca) {
        return uDao.get(termoBusca);
    }

    public Unidade get(Long id) {
        return uDao.get(id);
    }

    public int insert(Unidade objeto) {
        return uDao.insert(objeto);
    }

    public int update(Unidade objeto) {
        return uDao.update(objeto);
    }

    public int delete(Unidade objeto) {
        return uDao.delete(objeto);
    }
}