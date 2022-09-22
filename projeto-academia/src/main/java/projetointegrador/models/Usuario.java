package main.java.projetointegrador.models;

public class Usuario {
  public int id;
  public String nome;
  public String dataNascimento;
  public float altura;
  public float peso;
  public String cpf;
  public String email;
  public String telefone;

  public Usuario(
      int id,
      String nome,
      String dataNascimento,
      float altura,
      float peso,
      String cpf,
      String email,
      String telefone) {
    this.id = id;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.altura = altura;
    this.peso = peso;
    this.cpf = cpf;
    this.email = email;
    this.telefone = telefone;
  }
}
