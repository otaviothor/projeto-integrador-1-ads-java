package projetointegrador.controllers;

import java.util.UUID;

import javax.swing.JOptionPane;

import projetointegrador.dto.ExerciciosQuantidadeDto;
import projetointegrador.dto.TreinosQuantidadeDto;
import projetointegrador.dto.UsuarioIndexDto;
import projetointegrador.dto.UsuarioTreinoExerciciosDto;
import projetointegrador.models.Exercicio;
import projetointegrador.models.Treino;
import projetointegrador.models.Usuario;
import projetointegrador.services.UsuarioService;

public class UsuarioController {
  public Usuario usuarios[] = new Usuario[30];
  public UsuarioService usuarioService = new UsuarioService();
  public UsuarioTreinoExerciciosDto usuarioTreinoExerciciosDto = new UsuarioTreinoExerciciosDto();
  public int qtdUsuariosCadastrados = 0;

  /**
   * metodo que vai receber um parametro referente a qual operacao ele
   * vai realizar (create, read, update, delete) e direcionar a seu
   * respectivo bloco através do if-else
   * 
   * @param int              operacao
   * @param TreinoController treinoController
   */
  public void controlador(int operacao, TreinoController treinoController, ExercicioController exercicioController) {
    atualizaQtdUsuariosCadastrados();

    /**
     * controlador para consultar um usuario
     */
    if (operacao == 1) {
      if (qtdUsuariosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum usuário foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        UsuarioIndexDto usuarioSelecionado = mostraESelecionaUsuarioDoArray("Selecione o usuário que deseja consultar.",
            "Consultar usuário");
        TreinosQuantidadeDto treinosQtd = treinoController.retornaTreinosEQuantidadeCadastrado();
        ExerciciosQuantidadeDto exerciciosQtd = exercicioController.retornaExerciciosEQuantidadeCadastrado();

        Treino treinoUsuario = new Treino();
        for (Treino treino : treinosQtd.treinos) {
          if (treino != null) {
            if (treino.id == usuarioSelecionado.usuario.idTreino) {
              treinoUsuario = treino;
              break;
            }
          }
        }

        Exercicio[] exerciciosDoTreino = new Exercicio[2];
        int indexExercicio = 0;
        if (treinoUsuario.id != null) {
          for (String id : treinoUsuario.idExercicios) {
            for (Exercicio exercicio : exerciciosQtd.exercicios) {
              if (exercicio != null && exercicio.id == id) {
                exerciciosDoTreino[indexExercicio] = exercicio;
                indexExercicio++;
              }
            }
          }
        }

        usuarioTreinoExerciciosDto.usuario = usuarioSelecionado.usuario;
        usuarioTreinoExerciciosDto.treino = treinoUsuario;
        usuarioTreinoExerciciosDto.exercicios = exerciciosDoTreino;

        usuarioService.mostrarUsuario(usuarioTreinoExerciciosDto);
      }
    }

    /**
     * controlador para cadastrar um usuario
     */
    else if (operacao == 2) {
      if (treinoController.retornaTreinosEQuantidadeCadastrado().quantidade == 0) {
        JOptionPane.showMessageDialog(null,
            "Você ainda não cadastrou nenhum treino. Faça-o primeiro e retorne para cadastrar o usuário.",
            "Sem treinos",
            JOptionPane.WARNING_MESSAGE);
      } else if (qtdUsuariosCadastrados >= 30) {
        JOptionPane.showMessageDialog(null,
            "Você atingiu o máximo de 30 cadastros de usuários. Você deve editar ou excluir um registro.",
            "Limite atigido",
            JOptionPane.WARNING_MESSAGE);
      } else {
        Usuario usuario = usuarioService.cadastrarTreino(treinoController);
        String id = UUID.randomUUID().toString();
        usuario.id = id;
        usuarios[qtdUsuariosCadastrados] = usuario;

        JOptionPane.showMessageDialog(null,
            "Usuário cadastrado com sucesso.",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
      }
    }

    /**
     * controlador para editar um usuario
     */
    else if (operacao == 3) {
      if (qtdUsuariosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum usuário foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else if (treinoController.retornaTreinosEQuantidadeCadastrado().quantidade == 0) {
        JOptionPane.showMessageDialog(null,
            "Não encontramos nenhum treino cadastrado. Faça-o primeiro e retorne para editar o usuário.",
            "Sem treinos",
            JOptionPane.WARNING_MESSAGE);
      } else {
        UsuarioIndexDto selecionado = mostraESelecionaUsuarioDoArray("Selecione o usuário que deseja editar.",
            "Editar usuário");

        int resultado = JOptionPane.showConfirmDialog(null,
            "Deseja realmente editar esse usuário?", "Editar usuário",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          Usuario novoUsuario = usuarioService.editarUsuario(
              usuarios[selecionado.index],
              treinoController);
          usuarios[selecionado.index] = novoUsuario;

          JOptionPane.showMessageDialog(null,
              "Usuário editado com sucesso.",
              "Editar usuário",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }

    }

    /**
     * controlador para excluir um usuario
     */
    else if (operacao == 4) {
      if (qtdUsuariosCadastrados == 0) {
        JOptionPane.showMessageDialog(null,
            "Nenhum usuário foi cadastrado ainda.",
            "Sem dado",
            JOptionPane.WARNING_MESSAGE);
      } else {
        UsuarioIndexDto selecionado = mostraESelecionaUsuarioDoArray("Selecione o usuário deseja excluir.",
            "Excluir usuário");

        int resultado = JOptionPane.showConfirmDialog(null,
            "Deseja mesmo excluir esse usuário?",
            "Excluir usuário",
            JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
          usuarios = usuarioService.excluirUsuario(usuarios, selecionado.index);

          JOptionPane.showMessageDialog(null,
              "Usuário excluído com sucesso.",
              "Excluir usuário",
              JOptionPane.INFORMATION_MESSAGE);
        }
      }

      atualizaQtdUsuariosCadastrados();
    }

    /**
     * controlador para caso de opcao selecionada invalida
     */
    else {
      JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
    }
  }

  /**
   * metodo mostrar um JOptionPane.showInputDialog com uma lista
   * para que seja selecionado uma opcao dentre os usuarios
   * cadastrados e retornar o selecionado junto do indice dele no array
   * 
   * @param String message
   * @param String title
   * @return UsuarioIndexDto usuarioIndexDto
   */
  public UsuarioIndexDto mostraESelecionaUsuarioDoArray(String message, String title) {
    int indexNomes = 0;
    String[] nomeUsuarios = new String[30];
    for (Usuario usuario : usuarios) {
      if (usuario != null) {
        nomeUsuarios[indexNomes] = usuario.nome;
        indexNomes++;
      }
    }

    String nomeUsuarioSelecionado = (String) JOptionPane.showInputDialog(null,
        message,
        title, JOptionPane.QUESTION_MESSAGE, null, nomeUsuarios, nomeUsuarios[0]);

    Usuario usuarioSelecionado = new Usuario();
    int indexSelecionado = 0;
    for (Usuario usuario : usuarios) {
      if (usuario.nome == nomeUsuarioSelecionado) {
        usuarioSelecionado = usuario;
        break;
      }
      indexSelecionado++;
    }

    UsuarioIndexDto usuarioIndexDto = new UsuarioIndexDto(usuarioSelecionado, indexSelecionado);

    return usuarioIndexDto;
  }

  /**
   * metodo que atualiza a variavel de quantos usuarios foram cadastrados
   * 
   * @return void
   */
  public void atualizaQtdUsuariosCadastrados() {
    qtdUsuariosCadastrados = 0;

    for (Usuario usuario : usuarios) {
      if (usuario != null) {
        qtdUsuariosCadastrados++;
      }
    }
  }
}
