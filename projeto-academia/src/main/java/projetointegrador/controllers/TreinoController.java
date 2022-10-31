package projetointegrador.controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import projetointegrador.dto.ExerciciosQuantidadeDto;
import projetointegrador.dto.TreinoExerciciosDto;
import projetointegrador.dto.TreinoIndexDto;
import projetointegrador.dto.TreinosQuantidadeDto;
import projetointegrador.models.Treino;
import projetointegrador.models.Exercicio;
import projetointegrador.services.TreinoService;

public class TreinoController {
  public Treino treinos[] = new Treino[30];
  public TreinoService treinoService = new TreinoService();
  public TreinoExerciciosDto TreinoExerciciosDto = new TreinoExerciciosDto();
  public int qtdTreinosCadastrados = 0;

  /**
   * metodo que vai receber um parametro referente a qual operacao ele
   * vai realizar (create, read, update, delete) e direcionar a seu
   * respectivo bloco através do if-else
   * 
   * @param int                 operacao
   * @param ExercicioController exercicioController
   */
  public void controlador(int operacao, ExercicioController exercicioController) {
    atualizaQtdTreinosCadastrados();

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
        TreinoIndexDto selecionado = mostraESelecionaTreinoDoArray("Selecione o treino que deseja consultar.",
            "Consultar treino");
        ExerciciosQuantidadeDto exerciciosQtd = exercicioController.retornaExerciciosEQuantidadeCadastrado();

        Exercicio[] exerciciosDoTreino = new Exercicio[selecionado.treino.idExercicios.length];
        int indexExercicio = 0;
        for (String id : selecionado.treino.idExercicios) {
          for (Exercicio exercicio : exerciciosQtd.exercicios) {
            if (exercicio != null && exercicio.id == id) {
              exerciciosDoTreino[indexExercicio] = exercicio;
              indexExercicio++;
            }
          }
        }

        TreinoExerciciosDto.treino = selecionado.treino;
        TreinoExerciciosDto.exercicios = exerciciosDoTreino;

        treinoService.mostrarTreino(TreinoExerciciosDto);
      }
    }

    /**
     * controlador para cadastrar um treino
     */
    else if (operacao == 2) {
      if (exercicioController.retornaExerciciosEQuantidadeCadastrado().quantidade == 0) {
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
            "Podem ter usuários cadastrados com esse treino, deseja excluir mesmo assim?", "Excluir treino",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          treinos = treinoService.excluirTreino(treinos, selecionado.index);

          JOptionPane.showMessageDialog(null,
              "Exercício excluído com sucesso.",
              "Excluir treino",
              JOptionPane.INFORMATION_MESSAGE);
        }

        atualizaQtdTreinosCadastrados();
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

  /**
   * metodo que retorna quantos treinos foram cadastrados e tambem
   * os treinos em si
   * 
   * @return TreinosQuantidadeDto treinosQtd
   */
  public TreinosQuantidadeDto retornaTreinosEQuantidadeCadastrado() {
    TreinosQuantidadeDto treinosQtd = new TreinosQuantidadeDto();

    atualizaQtdTreinosCadastrados();

    treinosQtd.treinos = treinos;
    treinosQtd.quantidade = qtdTreinosCadastrados;

    return treinosQtd;
  }

  /**
   * metodo que atualiza a variavel de quantos treinos foram cadastrados
   * 
   * @return void
   */
  public void atualizaQtdTreinosCadastrados() {
    for (Treino treino : treinos) {
      if (treino != null) {
        qtdTreinosCadastrados++;
      }
    }
  }
}
