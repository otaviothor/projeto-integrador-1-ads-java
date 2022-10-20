package projetointegrador.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class MenuService {
  private final String[] opcoes = new String[] { "1", "2", "3", "4", "0" };
  private final List<String> opcoesList = new ArrayList<>(Arrays.asList(opcoes));
  private final String[] modelos = new String[] { "1", "2", "3", "0" };
  private final List<String> modelosList = new ArrayList<>(Arrays.asList(modelos));

  /**
   * metodo que vai mostrar um JOptionPane com as opcoes das operacoes
   * que ele pode realizar (create, read, update, delete)
   * 
   * @return int opcao
   */
  public int menuInicial() {
    String opcao;

    do {
      opcao = JOptionPane.showInputDialog(null,
          "Selecione a opção desejada:\n" +
              "1. Consultar\n" +
              "2. Cadastrar\n" +
              "3. Editar\n" +
              "4. Excluir\n" +
              "*\n" +
              "0. Sair\n",
          "Sistema de gerenciamento de academia",
          JOptionPane.QUESTION_MESSAGE);

      if (!opcoesList.contains(opcao))
        JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
    } while (!opcoesList.contains(opcao));

    return Integer.parseInt(opcao);
  }

  /**
   * metodo que vai mostrar um JOptionPane com as opcoes dos modelos
   * que ele vai operar em cima delas
   * 
   * @return int modelo
   */
  public int menuModelo(int opcao) {
    String modelo, modeloOpcao;

    if (opcao == 1)
      modeloOpcao = "consultar";
    else if (opcao == 2)
      modeloOpcao = "cadastrar";
    else if (opcao == 3)
      modeloOpcao = "editar";
    else
      modeloOpcao = "excluir";

    do {
      modelo = JOptionPane.showInputDialog(null,
          "Selecione a opção que deseja " + modeloOpcao + "\n" +
              "1. Exercício\n" +
              "2. Treino\n" +
              "3. Usuário\n" +
              "*\n" +
              "0. Voltar\n",
          "Selecione a opção desejada",
          JOptionPane.QUESTION_MESSAGE);

      if (!opcoesList.contains(modelo))
        JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
    } while (!modelosList.contains(modelo));
    return Integer.parseInt(modelo);
  }
}
