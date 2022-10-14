package projetointegrador.controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import projetointegrador.models.Exercicio;
import projetointegrador.services.ExercicioService;

public class ExercicioController {
  Exercicio exercicios[] = new Exercicio[30];
  ExercicioService exercicioService = new ExercicioService();

  /**
   * metodo de controlador
   * 
   * @param opcao
   */
  public void controlador(int opcao) {
    int qtdExerciciosCadastrados = 0;
    for (Exercicio exercicio : exercicios) {
      if (exercicio != null) {
        qtdExerciciosCadastrados++;
      }
    }

    /**
     * controlador para consultar um exercicio
     */
    if (opcao == 1) {
      if (qtdExerciciosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum exercício foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        String selecionado = mostraESelecionaExercicioDoArray();

        Exercicio exercicioSelecionado = new Exercicio();

        for (Exercicio exercicio : exercicios) {
          if (exercicio.nome == selecionado) {
            exercicioSelecionado = exercicio;
            break;
          }
        }

        exercicioService.mostrarExercicio(exercicioSelecionado);
      }
    }

    /**
     * controlador para cadastrar um exercicio
     */
    else if (opcao == 2) {
      if (qtdExerciciosCadastrados >= 30) {
        JOptionPane.showMessageDialog(null,
            "Você atingiu o máximo de 30 cadastros de exercícios. Você deve editar ou excluir um registro.",
            "Limite atigido",
            JOptionPane.WARNING_MESSAGE);
      } else {
        Exercicio exercicio = exercicioService.cadastrarExercicio();
        String id = UUID.randomUUID().toString();
        exercicio.id = id;
        exercicios[qtdExerciciosCadastrados] = exercicio;

        JOptionPane.showMessageDialog(null,
            "Exercício cadastrado com sucesso.",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
      }
    }

    /**
     * controlador para editar um exercicio
     */
    else if (opcao == 3) {
      if (qtdExerciciosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum exercício foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        String selecionado = mostraESelecionaExercicioDoArray();

        int resultado = JOptionPane.showConfirmDialog(null,
            "Deseja realmente editar esse exercício?", "Editar exercício",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          int index = 0;
          for (Exercicio exercicio : exercicios) {
            if (exercicio.nome == selecionado) {
              index++;
              break;
            }
          }

          Exercicio novoExercicio = exercicioService.editarExercicio(exercicios[index - 1]);
          exercicios[index - 1] = novoExercicio;

          JOptionPane.showMessageDialog(null,
              "Exercício editado com sucesso.",
              "Editar exercício",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }

    }

    /**
     * controlador para excluir um exercicio
     */
    else if (opcao == 4) {
      if (qtdExerciciosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum exercício foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        String selecionado = mostraESelecionaExercicioDoArray();

        int resultado = JOptionPane.showConfirmDialog(null,
            "Podem ter treinos cadastrados com esse exercício, deseja excluir mesmo assim?", "Excluir exercício",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          int index = 0;
          for (Exercicio exercicio : exercicios) {
            if (exercicio.nome == selecionado) {
              index++;
              break;
            }
          }

          exercicios = exercicioService.excluirExercicio(exercicios, index - 1);

          JOptionPane.showMessageDialog(null,
              "Exercício excluído com sucesso.",
              "Excluir exercício",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }
  }

  /**
   * metodo mostrar um JOptionPane.showInputDialog com uma lista
   * para que seja selecionado uma opcao dentre os exercicios
   * cadastrados
   * 
   * @return String
   */
  public String mostraESelecionaExercicioDoArray() {
    int qtdExerciciosCadastrados = 0;
    String[] nomeExercicios = new String[30];
    for (Exercicio exercicio : exercicios) {
      if (exercicio != null) {
        nomeExercicios[qtdExerciciosCadastrados] = exercicio.nome;
        qtdExerciciosCadastrados++;
      }
    }

    return (String) JOptionPane.showInputDialog(null,
        "Selecione o exercício que deseja editar.",
        "Editar exercício", JOptionPane.QUESTION_MESSAGE, null, nomeExercicios, nomeExercicios[0]);
  }
}
