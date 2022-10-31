package projetointegrador.dto;

import projetointegrador.models.Exercicio;
import projetointegrador.models.Treino;
import projetointegrador.models.Usuario;

/**
 * classe auxiliar para transferencia de informacoes
 * de usuario, treino e seus exercicios
 */
public class UsuarioTreinoExerciciosDto {
  public Usuario usuario;
  public Treino treino;
  public Exercicio[] exercicios;

  public UsuarioTreinoExerciciosDto() {
  }

  public UsuarioTreinoExerciciosDto(Usuario usuario,
      Treino treino,
      Exercicio[] exercicios) {
    this.usuario = usuario;
    this.treino = treino;
    this.exercicios = exercicios;
  }
}
