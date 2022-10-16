package projetointegrador.dto;

import projetointegrador.models.Exercicio;
import projetointegrador.models.Treino;

public class TreinoExerciciosDto {
  public Treino treino;
  public Exercicio[] exercicios;

  public TreinoExerciciosDto() {
  }

  public TreinoExerciciosDto(Treino treino,
      Exercicio[] exercicios) {
    this.treino = treino;
    this.exercicios = exercicios;
  }
}
