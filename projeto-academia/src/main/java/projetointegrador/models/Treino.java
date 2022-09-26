package main.java.projetointegrador.models;

import java.util.List;

public class Treino {
  public int id;
  public String nome;
  public String descricao;
  public List<Exercicio> exercicios;

  public Treino(
      int id,
      String nome,
      String descricao,
      List<Exercicio> exercicios) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.exercicios = exercicios;
  }
}
