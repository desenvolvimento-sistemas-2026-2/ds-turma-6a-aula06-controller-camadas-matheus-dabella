package br.ceub.desenvolvimento.aula06.app;

import br.ceub.desenvolvimento.aula06.controller.AlunoController;
import br.ceub.desenvolvimento.aula06.repository.AlunoRepository;
import br.ceub.desenvolvimento.aula06.service.AlunoService;
import br.ceub.desenvolvimento.aula06.view.MenuAlunos;

public class Principal {
    public static void main(String[] args) {
        AlunoRepository repository = new AlunoRepository();
        AlunoService service = new AlunoService(repository);
        AlunoController controller = new AlunoController(service);
        MenuAlunos menu = new MenuAlunos(controller);
        menu.iniciar();
    }
}