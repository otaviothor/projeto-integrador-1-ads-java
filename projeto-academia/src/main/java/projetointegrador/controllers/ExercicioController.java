package projetointegrador.controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import projetointegrador.dto.ExercicioIndexDto;
import projetointegrador.dto.ExerciciosQuantidadeDto;
import projetointegrador.models.Exercicio;
import projetointegrador.services.ExercicioService;

public class ExercicioController {
  public Exercicio exercicios[] = new Exercicio[30];
  public ExercicioService exercicioService = new ExercicioService();
  public int qtdExerciciosCadastrados = 0;

  /**
   * metodo que vai receber um parametro referente a qual operacao ele
   * vai realizar (create, read, update, delete) e direcionar a seu
   * respectivo bloco através do if-else
   * 
   * @param int operacao
   */
  public void controlador(int operacao) {
    atualizaQtdExerciciosCadastrados();

    /**
     * controlador para consultar um exercicio
     */
    if (operacao == 1) {
      if (qtdExerciciosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum exercício foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        ExercicioIndexDto selecionado = mostraESelecionaExercicioDoArray("Selecione o exercício que consultar editar.",
            "Consultar exercício");

        exercicioService.mostrarExercicio(selecionado.exercicio);
      }
    }

    /**
     * controlador para cadastrar um exercicio
     */
    else if (operacao == 2) {
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
    else if (operacao == 3) {
      if (qtdExerciciosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum exercício foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        ExercicioIndexDto selecionado = mostraESelecionaExercicioDoArray("Selecione o exercício que deseja editar.",
            "Editar exercício");

        int resultado = JOptionPane.showConfirmDialog(null,
            "Deseja realmente editar esse exercício?", "Editar exercício",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          Exercicio novoExercicio = exercicioService.editarExercicio(exercicios[selecionado.index]);
          exercicios[selecionado.index] = novoExercicio;

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
    else if (operacao == 4) {
      if (qtdExerciciosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum exercício foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        ExercicioIndexDto selecionado = mostraESelecionaExercicioDoArray("Selecione o exercício que excluir editar.",
            "Excluir exercício");

        int resultado = JOptionPane.showConfirmDialog(null,
            "Podem ter treinos cadastrados com esse exercício, deseja excluir mesmo assim?", "Excluir exercício",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          exercicios = exercicioService.excluirExercicio(exercicios, selecionado.index);

          JOptionPane.showMessageDialog(null,
              "Exercício excluído com sucesso.",
              "Excluir exercício",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }

      atualizaQtdExerciciosCadastrados();
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
   * para que seja selecionado uma opcao dentre os exercicios
   * cadastrados e retornar o selecionado junto do indice dele no array
   * 
   * @param String message
   * @param String title
   * @return ExercicioIndexDto
   */
  public ExercicioIndexDto mostraESelecionaExercicioDoArray(String message, String title) {
    int indexNomes = 0;
    String[] nomeExercicios = new String[30];
    for (Exercicio exercicio : exercicios) {
      if (exercicio != null) {
        nomeExercicios[indexNomes] = exercicio.nome;
        indexNomes++;
      }
    }

    String nomeExercicioSelecionado = (String) JOptionPane.showInputDialog(null,
        message,
        title, JOptionPane.QUESTION_MESSAGE, null, nomeExercicios, nomeExercicios[0]);

    Exercicio exercicioSelecionado = new Exercicio();
    int indexSelecionado = 0;
    for (Exercicio exercicio : exercicios) {
      if (exercicio.nome == nomeExercicioSelecionado) {
        exercicioSelecionado = exercicio;
        break;
      }
      indexSelecionado++;
    }

    ExercicioIndexDto exercicioIndexDto = new ExercicioIndexDto(exercicioSelecionado, indexSelecionado);

    return exercicioIndexDto;
  }

  /**
   * metodo que retorna quantos exercicios foram cadastrados e tambem
   * os exercicios em si
   * 
   * @return ExerciciosQuantidadeDto exerciciosQtd
   */
  public ExerciciosQuantidadeDto retornaExerciciosEQuantidadeCadastrado() {
    ExerciciosQuantidadeDto exerciciosQtd = new ExerciciosQuantidadeDto();

    atualizaQtdExerciciosCadastrados();

    exerciciosQtd.exercicios = exercicios;
    exerciciosQtd.quantidade = qtdExerciciosCadastrados;

    return exerciciosQtd;
  }

  /**
   * metodo que atualiza a variavel de quantos treinos foram cadastrados
   * 
   * @return void
   */
  public void atualizaQtdExerciciosCadastrados() {
    qtdExerciciosCadastrados = 0;
    for (Exercicio exercicio : exercicios) {
      if (exercicio != null) {
        qtdExerciciosCadastrados++;
      }
    }
  }
}
