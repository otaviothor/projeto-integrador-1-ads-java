package projetointegrador.services;

import java.util.Scanner;

import javax.swing.JOptionPane;

import projetointegrador.controllers.ExercicioController;
import projetointegrador.dto.ExercicioIndexDto;
import projetointegrador.dto.TreinoExerciciosDto;
import projetointegrador.models.Exercicio;
import projetointegrador.models.Treino;

public class TreinoService {
  Scanner scanner = new Scanner(System.in);

  /**
   * 
   * @param TreinoExerciciosDto TreinoExerciciosDto
   * @return void
   */
  public void mostrarTreino(TreinoExerciciosDto TreinoExerciciosDto) {
    String exerciciosMensagem = "";
    int index = 1;

    for (Exercicio exercicio : TreinoExerciciosDto.exercicios) {
      exerciciosMensagem += "" + index + "º exercício\n" +
          "ID: " + exercicio.id + "\n" +
          "Nome: " + exercicio.nome + "\n" +
          "Descrição: " + exercicio.descricao + "\n" +
          "Músculo ativado: " + exercicio.musculo + "\n\n";
      index++;
    }

    JOptionPane.showMessageDialog(null,
        "ID: " + TreinoExerciciosDto.treino.id + "\n" +
            "Nome: " + TreinoExerciciosDto.treino.nome + "\n" +
            "Descrição: " + TreinoExerciciosDto.treino.descricao + "\n\n" +
            exerciciosMensagem,
        "Consultar treino",
        JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * 
   * @param ExercicioController exercicioController
   * @return Treino Treino
   */
  public Treino cadastrarTreino(ExercicioController exercicioController) {
    Treino treino = new Treino();
    ExercicioIndexDto exercicioSelecionado;
    int index = 0;
    String[] idExerciciosSelecionados = new String[2];

    // captura o nome do treino
    do {
      treino.nome = JOptionPane.showInputDialog(null, "Informe o nome do treino:", "Cadastrar treino",
          JOptionPane.QUESTION_MESSAGE);

      if (treino.nome.length() < 5)
        JOptionPane.showMessageDialog(null, "O nome deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (treino.nome.length() < 5);

    // captura a descricao do treino
    do {
      treino.descricao = JOptionPane.showInputDialog(null, "Informe a descrição do treino:",
          "Cadastrar treino",
          JOptionPane.QUESTION_MESSAGE);

      if (treino.descricao.length() < 5)
        JOptionPane.showMessageDialog(null, "A descrição deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (treino.descricao.length() < 5);

    // captura os exercicios do treino
    while (index < 2) {
      exercicioSelecionado = exercicioController.mostraESelecionaExercicioDoArray(
          "Selecione o " + (index + 1) + "º exercício do treino:\n\nObs.: Você pode selecionar até 2 exercícios.",
          "Cadastrar treino");
      idExerciciosSelecionados[index] = exercicioSelecionado.exercicio.id;

      index++;

      if (index <= 2)
        break;

      int resultado = JOptionPane.showConfirmDialog(null,
          "Deseja cadastrar mais exercícios?", "Cadastrar treino",
          JOptionPane.YES_NO_OPTION);

      if (resultado == JOptionPane.NO_OPTION)
        break;
    }
    treino.idExercicios = idExerciciosSelecionados;

    return treino;
  }

  /**
   * 
   * @param Treino              treinoCadastrado
   * @param ExercicioController exercicioController
   * @return Treino treinoEditado
   */
  public Treino editarTreino(Treino treinoCadastrado, ExercicioController exercicioController) {
    Treino treinoEditado = new Treino();
    ExercicioIndexDto exercicioSelecionado;
    int index = 0;
    String[] idExerciciosSelecionados = new String[3];
    treinoEditado.id = treinoCadastrado.id;

    // captura o nome do treino
    do {
      treinoEditado.nome = JOptionPane.showInputDialog(null,
          "Nome atual do treino: " + treinoCadastrado.nome
              + "\nInforme o novo nome do treino (caso queira manter o mesmo, basta prosseguir):",
          "Editar treino",
          JOptionPane.QUESTION_MESSAGE);

      if (treinoEditado.nome.length() == 0) {
        treinoEditado.nome = treinoCadastrado.nome;
      } else if (treinoEditado.nome.length() < 5) {
        JOptionPane.showMessageDialog(null, "O novo nome deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (treinoEditado.nome.length() < 5);

    // captura a descricao do treino
    do {
      treinoEditado.descricao = JOptionPane.showInputDialog(null,
          "Descrição atual do treino: " + treinoCadastrado.descricao
              + "\nInforme a novo descrição treino (caso queira manter a mesma, basta prosseguir):",
          "Editar treino",
          JOptionPane.QUESTION_MESSAGE);

      if (treinoEditado.descricao.length() == 0) {
        treinoEditado.descricao = treinoCadastrado.descricao;
      } else if (treinoEditado.descricao.length() < 5) {
        JOptionPane.showMessageDialog(null, "A nova descrição deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (treinoEditado.descricao.length() < 5);

    // captura musculo do exercicio
    while (index <= 2) {
      exercicioSelecionado = exercicioController.mostraESelecionaExercicioDoArray(
          "Selecione o " + index + 1 + "º exercício do treino:\n\nObs.: Você pode selecionar até 3 exercícios.",
          "Editar treino");
      idExerciciosSelecionados[index] = exercicioSelecionado.exercicio.id;

      int resultado = JOptionPane.showConfirmDialog(null,
          "Deseja cadastrar mais exercícios?", "Editar treino",
          JOptionPane.YES_NO_OPTION);

      if (resultado == JOptionPane.NO_OPTION)
        break;

      index++;
    }
    treinoEditado.idExercicios = idExerciciosSelecionados;

    return treinoEditado;
  }

  /**
   * 
   * @param Treino[] treinos
   * @param int      index
   * @return Treino[] novoTreinos
   */
  public Treino[] excluirTreino(Treino[] treinos, int index) {
    Treino[] novoTreinos = new Treino[treinos.length - 1];

    for (int i = 0, k = 0; i < novoTreinos.length; i++) {
      if (i == index) {
        continue;
      }
      novoTreinos[k++] = treinos[i];
    }

    return novoTreinos;
  }
}
