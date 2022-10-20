package projetointegrador.dto;

import projetointegrador.models.Treino;

/**
 * classe auxiliar para transferencia de informacoes
 * de treino e qual sua posicao no array
 */
public class TreinoIndexDto {
  public Treino treino;
  public int index;

  public TreinoIndexDto() {
  }

  public TreinoIndexDto(Treino treino, int index) {
    this.treino = treino;
    this.index = index;
  }
}
