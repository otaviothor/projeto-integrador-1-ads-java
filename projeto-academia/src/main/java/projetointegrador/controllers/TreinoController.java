package projetointegrador.controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import projetointegrador.dto.ExerciciosQuantidadeDto;
import projetointegrador.dto.TreinoExerciciosDto;
import projetointegrador.dto.TreinoIndexDto;
import projetointegrador.models.Treino;
import projetointegrador.services.TreinoService;

public class TreinoController {
  Treino treinos[] = new Treino[30];
  TreinoService treinoService = new TreinoService();
  TreinoExerciciosDto TreinoExerciciosDto = new TreinoExerciciosDto();

  public void controlador(int operacao, ExercicioController exercicioController) {
    int qtdTreinosCadastrados = 0;
    for (Treino treino : treinos) {
      if (treino != null) {
        qtdTreinosCadastrados++;
      }
    }

    /**
     * controlador para consultar um treino
     */
    if (operacao == 1) {
      if (qtdTreinosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum treino foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        TreinoIndexDto selecionado = mostraESelecionaTreinoDoArray("Selecione o treino que consultar editar.",
            "Consultar treino");
        // TODO pegar os exercicios dos arrays de ids e filtrar
        ExerciciosQuantidadeDto exerciciosQtd = exercicioController.retornaExerciciosEQuantidadeCadstrado();

        TreinoExerciciosDto.treino = selecionado.treino;
        TreinoExerciciosDto.exercicios = exerciciosQtd.exercicios;

        treinoService.mostrarTreino(TreinoExerciciosDto);
      }
    }

    /**
     * controlador para cadastrar um treino
     */
    else if (operacao == 2) {
      if (exercicioController.retornaExerciciosEQuantidadeCadstrado().quantidade == 0) {
        JOptionPane.showMessageDialog(null,
            "Você ainda não cadastrou nenhum exercício. Faça-o primeiro e retorne para cadastrar seu treino.",
            "Sem exercícios",
            JOptionPane.WARNING_MESSAGE);
      } else if (qtdTreinosCadastrados >= 30) {
        JOptionPane.showMessageDialog(null,
            "Você atingiu o máximo de 30 cadastros de treinos. Você deve editar ou excluir um registro.",
            "Limite atigido",
            JOptionPane.WARNING_MESSAGE);
      } else {
        Treino treino = treinoService.cadastrarTreino(exercicioController);
        String id = UUID.randomUUID().toString();
        treino.id = id;
        treinos[qtdTreinosCadastrados] = treino;

        // TODO remover logs
        System.out.println(treino.descricao);
        System.out.println(treino.id);
        System.out.println(treino.nome);

        for (String ide : treino.idExercicios) {
          System.out.println(ide);
        }

        JOptionPane.showMessageDialog(null,
            "Exercício cadastrado com sucesso.",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
      }
    }

    /**
     * controlador para editar um treino
     */
    else if (operacao == 3) {
      if (qtdTreinosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum treino foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        TreinoIndexDto selecionado = mostraESelecionaTreinoDoArray("Selecione o treino que deseja editar.",
            "Editar treino");

        int resultado = JOptionPane.showConfirmDialog(null,
            "Deseja realmente editar esse treino?", "Editar treino",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          Treino novoTreino = treinoService.editarTreino(treinos[selecionado.index], exercicioController);
          treinos[selecionado.index] = novoTreino;

          JOptionPane.showMessageDialog(null,
              "Exercício editado com sucesso.",
              "Editar treino",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }

    }

    /**
     * controlador para excluir um treino
     */
    else if (operacao == 4) {
      if (qtdTreinosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum treino foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        TreinoIndexDto selecionado = mostraESelecionaTreinoDoArray("Selecione o treino que excluir editar.",
            "Excluir treino");

        int resultado = JOptionPane.showConfirmDialog(null,
            "Podem ter treinos cadastrados com esse treino, deseja excluir mesmo assim?", "Excluir treino",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          treinos = treinoService.excluirTreino(treinos, selecionado.index);

          JOptionPane.showMessageDialog(null,
              "Exercício excluído com sucesso.",
              "Excluir treino",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }

    /**
     * controlador para caso de opcao selecionada invalida
     */
    else {
      JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
    }
  }

  /**
   * metodo mostrar um JOptionPane.showInputDialog com uma lista
   * para que seja selecionado uma opcao dentre os treinos
   * cadastrados e retornar o selecionado junto do indice dele no array
   * 
   * @param String message
   * @param String title
   * @return TreinoIndexDto
   */
  public TreinoIndexDto mostraESelecionaTreinoDoArray(String message, String title) {
    int indexNomes = 0;
    String[] nomeTreinos = new String[30];
    for (Treino treino : treinos) {
      if (treino != null) {
        nomeTreinos[indexNomes] = treino.nome;
        indexNomes++;
      }
    }

    String nomeTreinoSelecionado = (String) JOptionPane.showInputDialog(null,
        message,
        title, JOptionPane.QUESTION_MESSAGE, null, nomeTreinos, nomeTreinos[0]);

    Treino treinoSelecionado = new Treino();
    int indexSelecionado = 0;
    for (Treino treino : treinos) {
      if (treino.nome == nomeTreinoSelecionado) {
        treinoSelecionado = treino;
        break;
      }
      indexSelecionado++;
    }

    TreinoIndexDto treinoIndexDto = new TreinoIndexDto(treinoSelecionado, indexSelecionado);

    return treinoIndexDto;
  }

}
