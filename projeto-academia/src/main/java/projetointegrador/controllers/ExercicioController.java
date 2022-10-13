package projetointegrador.controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import projetointegrador.models.Exercicio;
import projetointegrador.services.ExercicioService;

public class ExercicioController {
  Exercicio exercicios[] = new Exercicio[30];
  ExercicioService exercicioService = new ExercicioService();

  public void controlador(int opcao) {

    Exercicio e1 = new Exercicio(UUID.randomUUID().toString(),
        UUID.randomUUID().toString(),
        "exercicio desc 1 " + UUID.randomUUID().toString(), "exercicio video 1 " +
            UUID.randomUUID().toString());
    Exercicio e2 = new Exercicio(UUID.randomUUID().toString(),
        UUID.randomUUID().toString(),
        "exercicio desc 2 " + UUID.randomUUID().toString(), "exercicio video 2 " +
            UUID.randomUUID().toString());

    exercicios[0] = e1;
    exercicios[1] = e2;

    int exerciciosIndex = 0;
    String[] nomeExercicios = new String[30];
    for (Exercicio exercicio : exercicios) {
      if (exercicio != null) {
        nomeExercicios[exerciciosIndex] = exercicio.nome;
        exerciciosIndex += 1;
      }
    }

    if (opcao == 1) {
      if (exerciciosIndex == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum exercício foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        String selecionado = (String) JOptionPane.showInputDialog(null,
            "Selecione o exercício que deseja consultar.",
            "Consultar exercício", JOptionPane.QUESTION_MESSAGE, null, nomeExercicios, nomeExercicios[0]);

        Exercicio exercicioSelecionado = new Exercicio();

        for (Exercicio exercicio : exercicios) {
          if (exercicio.nome == selecionado) {
            exercicioSelecionado = exercicio;
            break;
          }
        }

        JOptionPane.showMessageDialog(null,
            "ID: " + exercicioSelecionado.id + "\n" +
                "Nome: " + exercicioSelecionado.nome + "\n" +
                "Descrição: " + exercicioSelecionado.descricao + "\n" +
                "Vídeo: " + exercicioSelecionado.video,
            "Consultar exercício",
            JOptionPane.INFORMATION_MESSAGE);
      }
    }

    else if (opcao == 2) {
      if (exerciciosIndex >= 30) {
        JOptionPane.showMessageDialog(null,
            "Você atingiu o máximo de 30 cadastros de exercícios. Você deve editar ou excluir um registro.",
            "Limite atigido",
            JOptionPane.WARNING_MESSAGE);
      } else {
        Exercicio exercicio = exercicioService.cadastrarExercicio();
        String id = UUID.randomUUID().toString();
        exercicio.id = id;
        exercicios[exerciciosIndex] = exercicio;

        JOptionPane.showMessageDialog(null,
            "Exercício cadastrado com sucesso.",
            "Sucesso.",
            JOptionPane.INFORMATION_MESSAGE);
      }
    } else if (opcao == 3)
      System.out.println();
    else if (opcao == 4)
      System.out.println();
  }
}
