package projetointegrador.dto;

import projetointegrador.models.Exercicio;

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
