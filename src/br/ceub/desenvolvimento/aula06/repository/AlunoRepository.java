package br.ceub.desenvolvimento.aula06.repository;

import java.util.ArrayList;
import java.util.List;

import br.ceub.desenvolvimento.aula06.model.Aluno;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public Aluno buscarPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public int quantidade() {
        return alunos.size();
    }
}
