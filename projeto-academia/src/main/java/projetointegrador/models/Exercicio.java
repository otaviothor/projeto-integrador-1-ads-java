package projetointegrador.models;

public class Exercicio {
  public String id;
  public String nome;
  public String video;
  public String descricao;

  public Exercicio() {
  }

  public Exercicio(
      String id,
      String nome,
      String video,
      String descricao) {
    this.id = id;
    this.nome = nome;
    this.video = video;
    this.descricao = descricao;
  }
}
