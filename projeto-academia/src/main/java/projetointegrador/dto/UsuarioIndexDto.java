package projetointegrador.dto;

import projetointegrador.models.Usuario;

/**
 * classe auxiliar para transferencia de informacoes
 * de usuario e qual sua posicao no array
 */
public class UsuarioIndexDto {
  public Usuario usuario;
  public int index;

  public UsuarioIndexDto() {
  }

  public UsuarioIndexDto(Usuario usuario, int index) {
    this.usuario = usuario;
    this.index = index;
  }
}
