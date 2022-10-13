package projetointegrador.models;

public class Treino {
  public int id;
  public String nome;
  public String descricao;
  public int[] idExercicios;

  public Treino() {
  }

  public Treino(
      int id,
      String nome,
      String descricao,
      int[] idExercicios) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.idExercicios = idExercicios;
  }
}
