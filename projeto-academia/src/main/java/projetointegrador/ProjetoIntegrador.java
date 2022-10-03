package projetointegrador;

import projetointegrador.controllers.*;
import projetointegrador.models.*;
import projetointegrador.services.MenuService;

public class ProjetoIntegrador {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		EnderecoController enderecoController = new EnderecoController();
		ExercicioController exercicioController = new ExercicioController();
		TreinoController treinoController = new TreinoController();
		UsuarioController usuarioController = new UsuarioController();

		int opcao;

		do {
			opcao = menuService.menuInicial();

			if (opcao != 0) {
				int modelo = menuService.menuModelo(opcao);

				if (modelo == 1)
					enderecoController.controlador(opcao);
				else if (modelo == 2)
					exercicioController.controlador(opcao);
				else if (modelo == 3)
					treinoController.controlador(opcao);
				else if (modelo == 4)
					usuarioController.controlador(opcao);
			}

		} while (opcao != 0);

		System.out.println("Obrigado por usar nosso sistema.");
	}
}
