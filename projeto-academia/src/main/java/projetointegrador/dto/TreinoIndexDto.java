package projetointegrador.dto;

import projetointegrador.models.Treino;

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
