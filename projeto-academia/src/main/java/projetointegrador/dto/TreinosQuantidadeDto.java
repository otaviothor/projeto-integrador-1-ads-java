package projetointegrador.dto;

import projetointegrador.models.Treino;

/**
 * classe auxiliar para transferencia de informacoes
 * de todos os treinos e a quantidade cadastrada
 */
public class TreinosQuantidadeDto {
  public Treino[] treinos;
  public int quantidade;

  public TreinosQuantidadeDto() {
  }

  public TreinosQuantidadeDto(Treino[] treinos, int quantidade) {
    this.treinos = treinos;
    this.quantidade = quantidade;
  }
}
