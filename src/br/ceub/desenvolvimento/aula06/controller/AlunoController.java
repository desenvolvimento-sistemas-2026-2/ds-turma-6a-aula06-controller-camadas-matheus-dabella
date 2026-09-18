package br.ceub.desenvolvimento.aula06.controller;

import br.ceub.desenvolvimento.aula06.service.AlunoService;

public class AlunoController {
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    public String cadastrar(String nome, int semestre, String curso) {
        return service.cadastrar(nome, semestre, curso);
    }

    public String listarTodos() {
        return service.listarTodos();
    }

    public String buscarPorNome(String nome) {
        return service.buscarPorNome(nome);
    }

    public int quantidade() {
        return service.quantidade();
    }
}
