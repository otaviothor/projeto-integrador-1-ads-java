package projetointegrador.models;

/**
 * classe modelo do usuario
 */
public class Usuario {
  public String id;
  public String nome;
  public String dataNascimento;
  public String idTreino;

  public Usuario() {
  }

  public Usuario(
      String id,
      String nome,
      String dataNascimento,
      String idTreino) {
    this.id = id;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.idTreino = idTreino;
  }
}
