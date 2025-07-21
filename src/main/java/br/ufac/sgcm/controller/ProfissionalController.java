package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Profissional;

public class ProfissionalController {

    private ProfissionalDao pDao;

    public ProfissionalController() {
        pDao = new ProfissionalDao();
    }

    public List<Profissional> get() {
        return pDao.get();
    }

    public List<Profissional> get(String termoBusca) {
        return pDao.get(termoBusca);
    }

    public Profissional get(Long id) {
        return pDao.get(id);
    }

    public int insert(Profissional objeto) {
        return pDao.insert(objeto);
    }

    public int update(Profissional objeto) {
        return pDao.update(objeto);
    }

    public int delete(Profissional objeto) {
        return pDao.delete(objeto);
    }
}