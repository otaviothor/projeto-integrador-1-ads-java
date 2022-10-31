package projetointegrador.services;

import javax.swing.JOptionPane;

import projetointegrador.controllers.TreinoController;
import projetointegrador.dto.TreinoIndexDto;
import projetointegrador.dto.UsuarioTreinoExerciciosDto;
import projetointegrador.models.Exercicio;
import projetointegrador.models.Usuario;

public class UsuarioService {

    /**
     * metodo que vai mostrar todas as informacoes do usuário
     * assim como do treino e exercicios selecionados para ele
     * 
     * @param UsuarioTreinoExerciciosDto usuarioTreinoExerciciosDto
     * @return void
     */
    public void mostrarUsuario(UsuarioTreinoExerciciosDto usuarioTreinoExerciciosDto) {
        String exerciciosMensagem = "";
        String treinoMensagem = "";
        int index = 1;

        for (Exercicio exercicio : usuarioTreinoExerciciosDto.exercicios) {
            if (exercicio != null) {
                exerciciosMensagem += "" + index + "º exercício\n"
                        + "ID: " + exercicio.id + "\n"
                        + "Nome: " + exercicio.nome + "\n"
                        + "Descrição: " + exercicio.descricao + "\n"
                        + "Músculo ativado: " + exercicio.musculo + "\n\n";
                index++;
            }
        }

        if (usuarioTreinoExerciciosDto.treino.id != null) {
            treinoMensagem = "Treino\n" + "ID: " + usuarioTreinoExerciciosDto.treino.id + "\n"
                    + "Nome: " + usuarioTreinoExerciciosDto.treino.nome + "\n"
                    + "Descrição: " + usuarioTreinoExerciciosDto.treino.descricao;
        }

        JOptionPane.showMessageDialog(null,
                "ID: " + usuarioTreinoExerciciosDto.usuario.id + "\n"
                        + "Nome: " + usuarioTreinoExerciciosDto.usuario.nome + "\n"
                        + "Data de nascimento: " + usuarioTreinoExerciciosDto.usuario.dataNascimento + "\n\n"
                        + treinoMensagem + "\n\n" + exerciciosMensagem,
                "Consultar usuário",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * metodo que vai cadastra um usuario preenchendo todas as suas propriedades
     * e validando se elas estao dentro do padrao
     * 
     * @param TreinoController treinoController
     * @return Usuario ssuario
     */
    public Usuario cadastrarTreino(TreinoController treinoController) {
        Usuario usuario = new Usuario();
        TreinoIndexDto treinoIndexDto;

        // captura o nome do usuario
        do {
            usuario.nome = JOptionPane.showInputDialog(null, "Informe o nome do usuário:", "Cadastrar usuário",
                    JOptionPane.QUESTION_MESSAGE);

            if (usuario.nome.length() < 3) {
                JOptionPane.showMessageDialog(null, "O nome deve ter no minímo 3 caracteres.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (usuario.nome.length() < 3);

        // captura a data de nascimento do usuario
        do {
            usuario.dataNascimento = JOptionPane.showInputDialog(null,
                    "Informe a data de nascimento do usuário (padrão 99/99/9999):",
                    "Cadastrar usuário",
                    JOptionPane.QUESTION_MESSAGE);

            if (usuario.dataNascimento.length() < 10) {
                JOptionPane.showMessageDialog(null, "A descrição deve ter no minímo 10 caracteres (padrão 99/99/9999).",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (usuario.dataNascimento.length() < 10);

        treinoIndexDto = treinoController.mostraESelecionaTreinoDoArray(
                "Selecione o do treino do usuário:",
                "Cadastrar usuário");

        usuario.idTreino = treinoIndexDto.treino.id;

        return usuario;
    }

    /**
     * metodo que vai editar um usuario que foi escolhido previamente,
     * validando se elas estao dentro do padrao assim como no cadastro
     * e vai retornar para que ele seja realocado na mesma posicao
     * 
     * @param Usuario          usuarioCadastrado
     * @param TreinoController treinoCadastrado
     * @return Usuario usuarioEditado
     */
    public Usuario editarUsuario(Usuario usuarioCadastrado, TreinoController treinoController) {
        Usuario usuarioEditado = new Usuario();
        TreinoIndexDto treinoIndexDto;
        usuarioEditado.id = usuarioCadastrado.id;

        // captura o nome do usuario
        do {
            usuarioEditado.nome = JOptionPane.showInputDialog(null,
                    "Nome atual do usuário: " + usuarioCadastrado.nome
                            + "\nInforme o novo nome do usuário (caso queira manter o mesmo, basta prosseguir):",
                    "Editar usuário",
                    JOptionPane.QUESTION_MESSAGE);

            if (usuarioEditado.nome.length() == 0) {
                usuarioEditado.nome = usuarioCadastrado.nome;
            } else if (usuarioEditado.nome.length() < 3) {
                JOptionPane.showMessageDialog(null, "O novo nome deve ter no minímo 3 caracteres.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (usuarioEditado.nome.length() < 3);

        // captura a data de nascimento do treino
        do {
            usuarioEditado.dataNascimento = JOptionPane.showInputDialog(null,
                    "Data de nascimento atual do usuário: " + usuarioCadastrado.dataNascimento
                            + "\nInforme a nova data de nascimento do usuário (padrão 99/99/9999) - (caso queira manter a mesma, basta prosseguir):",
                    "Editar usuário",
                    JOptionPane.QUESTION_MESSAGE);

            if (usuarioEditado.dataNascimento.length() == 0) {
                usuarioEditado.dataNascimento = usuarioCadastrado.dataNascimento;
            } else if (usuarioEditado.dataNascimento.length() < 10) {
                JOptionPane.showMessageDialog(null,
                        "A nova descrição deve ter no minímo 10 caracteres (padrão 99/99/9999).", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (usuarioEditado.dataNascimento.length() < 10);

        // captura o treino do usuario
        treinoIndexDto = treinoController.mostraESelecionaTreinoDoArray(
                "Selecione o do treino do usuário:",
                "Editar usuário");

        usuarioEditado.idTreino = treinoIndexDto.treino.id;

        return usuarioEditado;
    }

    /**
     * metodo que vai excluir um usuario do array e vai reordena-los
     * para nao deixar nenhuma posicao do array vazia
     * 
     * @param Usuario[] usuarios
     * @param int       index
     * @return Usuario[] novoUsuarios
     */
    public Usuario[] excluirUsuario(Usuario[] usuarios, int index) {
        Usuario[] novoUsuarios = new Usuario[usuarios.length - 1];

        for (int i = 0, k = 0; i < novoUsuarios.length; i++) {
            if (i == index) {
                continue;
            }
            novoUsuarios[k++] = usuarios[i];
        }

        return novoUsuarios;
    }
}
