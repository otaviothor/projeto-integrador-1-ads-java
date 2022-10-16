package projetointegrador.models;

public class Treino {
  public String id;
  public String nome;
  public String descricao;
  public String[] idExercicios;

  public Treino() {
  }

  public Treino(
      String id,
      String nome,
      String descricao,
      String[] idExercicios) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.idExercicios = idExercicios;
  }
}
