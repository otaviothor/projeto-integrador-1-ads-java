package projetointegrador.dto;

import projetointegrador.models.Exercicio;

/**
 * classe auxiliar para transferencia de informacoes
 * de todos os exercicio e a quantidade cadastrada
 */
public class ExerciciosQuantidadeDto {
  public Exercicio[] exercicios;
  public int quantidade;

  public ExerciciosQuantidadeDto() {
  }

  public ExerciciosQuantidadeDto(Exercicio[] exercicios, int quantidade) {
    this.exercicios = exercicios;
    this.quantidade = quantidade;
  }
}
