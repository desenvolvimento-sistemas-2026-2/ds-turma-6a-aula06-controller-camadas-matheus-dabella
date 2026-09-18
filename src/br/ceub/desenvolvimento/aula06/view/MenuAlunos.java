package br.ceub.desenvolvimento.aula06.view;

import javax.swing.JOptionPane;

import br.ceub.desenvolvimento.aula06.service.AlunoService;

public class MenuAlunos {
    private AlunoService service;

    public MenuAlunos(AlunoService service) {
        this.service = service;
    }

    public void iniciar() {
        int opcao = -1;
        while (opcao != 0) {
            String menu = "1 - Cadastrar aluno\n"
                    + "2 - Listar alunos\n"
                    + "3 - Buscar aluno por nome\n"
                    + "0 - Sair";
            opcao = lerInteiro(menu, 0, 3);

            if (opcao == 1) {
                cadastrarAluno();
            } else if (opcao == 2) {
                mostrar(service.listarTodos());
            } else if (opcao == 3) {
                String nome = lerTexto("Nome para busca:");
                mostrar(service.buscarPorNome(nome));
            }
        }
        mostrar("Programa encerrado. Total de alunos: " + service.quantidade());
    }

    private void cadastrarAluno() {
        String nome = lerTexto("Nome do aluno:");
        String curso = lerTexto("Curso:");
        int semestre = lerInteiro("Semestre:", 1, 10);
        String mensagem = service.cadastrar(nome, semestre, curso);
        mostrar(mensagem);
    }

    private String lerTexto(String mensagem) {
        String texto = JOptionPane.showInputDialog(mensagem);
        if (texto == null) {
            return "";
        }
        return texto;
    }

    private int lerInteiro(String mensagem, int minimo, int maximo) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(mensagem);
                if (entrada == null) {
                    return minimo;
                }
                int numero = Integer.parseInt(entrada);
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }
                mostrar("Digite um numero entre " + minimo + " e " + maximo + ".");
            } catch (NumberFormatException erro) {
                mostrar("Digite apenas numeros.");
            }
        }
    }

    private void mostrar(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
