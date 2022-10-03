package projetointegrador.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuService {
  private final Integer[] opcoes = new Integer[] { 1, 2, 3, 4, 0 };
  private final List<Integer> opcoesList = new ArrayList<>(Arrays.asList(opcoes));

  Scanner scanner = new Scanner(System.in);

  public int menuInicial() {
    int opcao;
    do {
      System.out.println("****************************************");
      System.out.println("  Sistema de gerenciamento de academia");
      System.out.println("  Selecione a opção desejada:");
      System.out.println("  1. Consultar");
      System.out.println("  2. Cadastrar");
      System.out.println("  3. Editar");
      System.out.println("  4. Excluir");
      System.out.println("  *");
      System.out.println("  0. Sair");
      System.out.println("****************************************");
      opcao = scanner.nextInt();

      if (!opcoesList.contains(opcao))
        System.out.println("Opção inválida!");
    } while (!opcoesList.contains(opcao));
    return opcao;
  }

  public int menuModelo(int opcao) {
    int modelo;
    String modeloOpcao;

    if (opcao == 1)
      modeloOpcao = "consultar";
    else if (opcao == 2)
      modeloOpcao = "cadastrar";
    else if (opcao == 3)
      modeloOpcao = "editar";
    else
      modeloOpcao = "excluir";

    do {
      System.out.println("******************************************");
      System.out.println("  Selecione a opção que deseja " + modeloOpcao);
      System.out.println("  1. Endereço");
      System.out.println("  2. Exercício");
      System.out.println("  3. Treino");
      System.out.println("  4. Usuário");
      System.out.println("  *");
      System.out.println("  0. Voltar");
      System.out.println("******************************************");
      modelo = scanner.nextInt();

      if (!opcoesList.contains(modelo))
        System.out.println("Opção inválida!");
    } while (!opcoesList.contains(modelo));
    return opcao;
  }
}
