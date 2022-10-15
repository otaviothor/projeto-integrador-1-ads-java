package projetointegrador.dto;

import projetointegrador.models.Exercicio;

public class ExercicioIndexDto {
  public Exercicio exercicio;
  public int index;

  public ExercicioIndexDto() {
  }

  public ExercicioIndexDto(Exercicio exercicio, int index) {
    this.exercicio = exercicio;
    this.index = index;
  }
}
