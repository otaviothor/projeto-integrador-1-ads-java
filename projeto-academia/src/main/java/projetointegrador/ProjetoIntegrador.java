package projetointegrador;

import javax.swing.JOptionPane;

import projetointegrador.controllers.ExercicioController;
import projetointegrador.controllers.TreinoController;
import projetointegrador.controllers.UsuarioController;
import projetointegrador.services.MenuService;

public class ProjetoIntegrador {
	public static void main(String[] args) {

		MenuService menuService = new MenuService();
		ExercicioController exercicioController = new ExercicioController();
		TreinoController treinoController = new TreinoController();
		UsuarioController usuarioController = new UsuarioController();

		int opcao;

		do {
			opcao = menuService.menuInicial();

			if (opcao != 0) {
				int modelo = menuService.menuModelo(opcao);

				if (modelo == 1)
					exercicioController.controlador(opcao);
				else if (modelo == 2)
					treinoController.controlador(opcao);
				else if (modelo == 3)
					usuarioController.controlador(opcao);
			}

		} while (opcao != 0);

		JOptionPane.showMessageDialog(null,
				"Obrigado por usar nosso sistema.",
				"Sistema de gerenciamento de academia",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
