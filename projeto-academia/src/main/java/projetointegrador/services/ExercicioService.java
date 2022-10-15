package projetointegrador.services;

import java.util.Scanner;

import javax.swing.JOptionPane;

import projetointegrador.models.Exercicio;

public class ExercicioService {
  Scanner scanner = new Scanner(System.in);

  /**
   * metodo que recebe um parametro do tipo `Exercicio`
   * que serve para mostrar detalhes de um exercicio
   * 
   * @param Exercicio exercicio
   * @return void
   */
  public void mostrarExercicio(Exercicio exercicio) {
    JOptionPane.showMessageDialog(null,
        "ID: " + exercicio.id + "\n" +
            "Nome: " + exercicio.nome + "\n" +
            "Descrição: " + exercicio.descricao + "\n" +
            "Músculo ativado: " + exercicio.musculo,
        "Consultar exercício",
        JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * metodo que captura as informacoes de um exercicios,
   * valida se todos tem no minimo 5 caracteres e retorna
   * para que seja salvo no array onde estão todos os
   * exercicios salvos
   * 
   * @return Exercicio exercicio
   */
  public Exercicio cadastrarExercicio() {
    Exercicio exercicio = new Exercicio();

    // captura o nome do exercicio
    do {
      exercicio.nome = JOptionPane.showInputDialog(null, "Informe o nome do exercício:", "Cadastro de exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicio.nome.length() < 5)
        JOptionPane.showMessageDialog(null, "O nome deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.nome.length() < 5);

    // captura a descricao do exercicio
    do {
      exercicio.descricao = JOptionPane.showInputDialog(null, "Informe a descrição do exercício:",
          "Cadastro de exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicio.descricao.length() < 5)
        JOptionPane.showMessageDialog(null, "A descrição deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.descricao.length() < 5);

    // captura musculo do exercicio
    do {
      String[] musculos = { "Costas", "Ombro", "Trapézio", "Bíceps", "Tríceps", "Antebraço", "Peito", "Abdómen",
          "Lombar", "Quadríceps", "Panturrilha" };
      exercicio.musculo = (String) JOptionPane.showInputDialog(null,
          "Selecione o músculo que esse exercício ativa:",
          "Cadastro de exercício", JOptionPane.QUESTION_MESSAGE, null, musculos, musculos[0]);

      if (exercicio.musculo.length() < 5)
        JOptionPane.showMessageDialog(null, "O músculo ativado deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.musculo.length() < 5);

    return exercicio;
  }

  /**
   * metodo que recebe um parametro do tipo `Exercicio`,
   * valida se um novo valor foi informado para atualizar e
   * se ele possui no minimo 5 caracteres, se nao mantem o
   * valor existente previamente vindo atraves do parametro
   * e retorna
   * 
   * @param Exercicio exercicioCadastrado
   * @return Exercicio novoExercicios
   */
  public Exercicio editarExercicio(Exercicio exercicioCadastrado) {
    Exercicio exercicioEditado = new Exercicio();
    exercicioEditado.id = exercicioCadastrado.id;

    // captura o nome do exercicio
    do {
      exercicioEditado.nome = JOptionPane.showInputDialog(null,
          "Nome atual do exercício: " + exercicioCadastrado.nome
              + "\nInforme o novo nome do exercício (caso queira manter o mesmo, basta prosseguir):",
          "Editar exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicioEditado.nome.length() == 0) {
        exercicioEditado.nome = exercicioCadastrado.nome;
      } else if (exercicioEditado.nome.length() < 5) {
        JOptionPane.showMessageDialog(null, "O novo nome deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (exercicioEditado.nome.length() < 5);

    // captura a descricao do exercicio
    do {
      exercicioEditado.descricao = JOptionPane.showInputDialog(null,
          "Descrição atual do exercício: " + exercicioCadastrado.descricao
              + "\nInforme a novo descrição exercício (caso queira manter a mesma, basta prosseguir):",
          "Editar exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicioEditado.descricao.length() == 0) {
        exercicioEditado.descricao = exercicioCadastrado.descricao;
      } else if (exercicioEditado.descricao.length() < 5) {
        JOptionPane.showMessageDialog(null, "A nova descrição deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (exercicioEditado.descricao.length() < 5);

    // captura musculo do exercicio
    do {
      String[] musculos = { "Costas", "Ombro", "Trapézio", "Bíceps", "Tríceps", "Antebraço", "Peito", "Abdómen",
          "Lombar", "Quadríceps", "Panturrilha" };
      exercicioEditado.musculo = (String) JOptionPane.showInputDialog(null,
          "Selecione o músculo que esse exercício ativa:",
          "Editar exercício", JOptionPane.QUESTION_MESSAGE, null, musculos, musculos[0]);

      if (exercicioEditado.musculo.length() < 5)
        JOptionPane.showMessageDialog(null, "O músculo ativado deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicioEditado.musculo.length() < 5);

    return exercicioEditado;
  }

  /**
   * metodo que recebe um parametro do tipo `Exercicio[]`,
   * contendo todos os exercicios cadastrados e tambem um
   * parametro `int` que serve como index da posicao do array
   * que deve ser excluida, e apos a exclusao, um novo array e
   * retornado sem a posicao informada para que seja salvo
   * 
   * @param Exercicio[] exercicios
   * @param int         index
   * @return Exercicio[] novoExercicios
   */
  public Exercicio[] excluirExercicio(Exercicio[] exercicios, int index) {
    Exercicio[] novoExercicios = new Exercicio[exercicios.length - 1];

    for (int i = 0, k = 0; i < novoExercicios.length; i++) {
      if (i == index) {
        continue;
      }
      novoExercicios[k++] = exercicios[i];
    }

    return novoExercicios;
  }
}
