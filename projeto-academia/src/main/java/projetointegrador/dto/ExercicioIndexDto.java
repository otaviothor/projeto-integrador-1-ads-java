package projetointegrador.dto;

import projetointegrador.models.Exercicio;

/**
 * classe auxiliar para transferencia de informacoes
 * de exercicio e qual sua posicao no array
 */
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
