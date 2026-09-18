package br.ceub.desenvolvimento.aula06.service;

import java.util.List;

import br.ceub.desenvolvimento.aula06.model.Aluno;
import br.ceub.desenvolvimento.aula06.repository.AlunoRepository;

public class AlunoService {
    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(String nome, int semestre, String curso) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome e obrigatorio.";
        }
        if (curso == null || curso.trim().isEmpty()) {
            return "Curso e obrigatorio.";
        }
        if (semestre < 1 || semestre > 10) {
            return "Semestre deve estar entre 1 e 10.";
        }

        Aluno aluno = new Aluno(nome.trim(), semestre, curso.trim());
        repository.adicionar(aluno);
        return "Aluno cadastrado com sucesso.";
    }

    public String listarTodos() {
        List<Aluno> alunos = repository.listarTodos();
        if (alunos.isEmpty()) {
            return "Nenhum aluno cadastrado.";
        }

        String resultado = "";
        for (Aluno aluno : alunos) {
            resultado += aluno.gerarResumo() + "\n";
        }
        return resultado;
    }

    public String buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "Informe um nome para busca.";
        }

        Aluno aluno = repository.buscarPorNome(nome.trim());
        if (aluno == null) {
            return "Aluno nao encontrado.";
        }
        return aluno.gerarResumo();
    }

    public int quantidade() {
        return repository.quantidade();
    }
}
