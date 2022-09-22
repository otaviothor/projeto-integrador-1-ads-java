package main.java.projetointegrador.models;

public class Exercicio {
  public int id;
  public String nome;
  public String video;
  public String descricao;

  public Exercicio(
      int id,
      String nome,
      String video,
      String descricao) {
    this.id = id;
    this.nome = nome;
    this.video = video;
    this.descricao = descricao;
  }
}
