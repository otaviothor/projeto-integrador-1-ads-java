package projetointegrador.models;

public class Exercicio {
  public String id;
  public String nome;
  public String descricao;
  public String musculo;

  public Exercicio() {
  }

  public Exercicio(
      String id,
      String nome,
      String descricao,
      String musculo) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.musculo = musculo;
  }
}
