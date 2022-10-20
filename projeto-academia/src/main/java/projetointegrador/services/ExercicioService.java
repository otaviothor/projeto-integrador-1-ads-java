package projetointegrador.services;

import javax.swing.JOptionPane;

import projetointegrador.models.Exercicio;

public class ExercicioService {

  /**
   * metodo que vai mostrar todas as informacoes do exercicio
   * 
   * @param Exercicio exercicio
   * @return void
   */
  public void mostrarExercicio(Exercicio exercicio) {
    JOptionPane.showMessageDialog(null,
        "ID: " + exercicio.id + "\n" +
            "Nome: " + exercicio.nome + "\n" +
            "Descrição: " + exercicio.descricao + "\n" +
            "Músculo ativado: " + exercicio.musculo,
        "Consultar exercício",
        JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * metodo que vai cadastra um exercicio preenchendo todas as suas propriedades
   * e validando se elas estao dentro do padrao
   * 
   * @return Exercicio exercicio
   */
  public Exercicio cadastrarExercicio() {
    Exercicio exercicio = new Exercicio();

    // captura o nome do exercicio
    do {
      exercicio.nome = JOptionPane.showInputDialog(null, "Informe o nome do exercício:", "Cadastrar exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicio.nome.length() < 5)
        JOptionPane.showMessageDialog(null, "O nome deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.nome.length() < 5);

    // captura a descricao do exercicio
    do {
      exercicio.descricao = JOptionPane.showInputDialog(null, "Informe a descrição do exercício:",
          "Cadastrar exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicio.descricao.length() < 5)
        JOptionPane.showMessageDialog(null, "A descrição deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.descricao.length() < 5);

    // captura musculo do exercicio
    do {
      String[] musculos = { "Costas", "Ombro", "Trapézio", "Bíceps", "Tríceps", "Antebraço", "Peito", "Abdómen",
          "Lombar", "Quadríceps", "Panturrilha" };
      exercicio.musculo = (String) JOptionPane.showInputDialog(null,
          "Selecione o músculo que esse exercício ativa:",
          "Cadastrar exercício", JOptionPane.QUESTION_MESSAGE, null, musculos, musculos[0]);

      if (exercicio.musculo.length() < 5)
        JOptionPane.showMessageDialog(null, "O músculo ativado deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.musculo.length() < 5);

    return exercicio;
  }

  /**
   * metodo que vai editar um exercicio que foi escolhido previamente
   * validando se elas estao dentro do padrao assim como no cadastro
   * e vai retornar para que ele seja realocado na mesma posicao
   * 
   * @param Exercicio exercicioCadastrado
   * @return Exercicio exercicioEditado
   */
  public Exercicio editarExercicio(Exercicio exercicioCadastrado) {
    Exercicio exercicioEditado = new Exercicio();
    exercicioEditado.id = exercicioCadastrado.id;

    // captura o nome do exercicio
    do {
      exercicioEditado.nome = JOptionPane.showInputDialog(null,
          "Nome atual do exercício: " + exercicioCadastrado.nome
              + "\nInforme o novo nome do exercício (caso queira manter o mesmo, basta prosseguir):",
          "Editar exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicioEditado.nome.length() == 0) {
        exercicioEditado.nome = exercicioCadastrado.nome;
      } else if (exercicioEditado.nome.length() < 5) {
        JOptionPane.showMessageDialog(null, "O novo nome deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (exercicioEditado.nome.length() < 5);

    // captura a descricao do exercicio
    do {
      exercicioEditado.descricao = JOptionPane.showInputDialog(null,
          "Descrição atual do exercício: " + exercicioCadastrado.descricao
              + "\nInforme a novo descrição exercício (caso queira manter a mesma, basta prosseguir):",
          "Editar exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicioEditado.descricao.length() == 0) {
        exercicioEditado.descricao = exercicioCadastrado.descricao;
      } else if (exercicioEditado.descricao.length() < 5) {
        JOptionPane.showMessageDialog(null, "A nova descrição deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (exercicioEditado.descricao.length() < 5);

    // captura musculo do exercicio
    do {
      String[] musculos = { "Costas", "Ombro", "Trapézio", "Bíceps", "Tríceps", "Antebraço", "Peito", "Abdómen",
          "Lombar", "Quadríceps", "Panturrilha" };
      exercicioEditado.musculo = (String) JOptionPane.showInputDialog(null,
          "Selecione o músculo que esse exercício ativa:",
          "Editar exercício", JOptionPane.QUESTION_MESSAGE, null, musculos, musculos[0]);

      if (exercicioEditado.musculo.length() < 5)
        JOptionPane.showMessageDialog(null, "O músculo ativado deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicioEditado.musculo.length() < 5);

    return exercicioEditado;
  }

  /**
   * metodo que vai excluir um exercicio do array e vai reordena-los
   * para nao deixar nenhuma posicao do array vazia
   * 
   * @param Exercicio[] exercicios
   * @param int         index
   * @return Exercicio[] novoExercicios
   */
  public Exercicio[] excluirExercicio(Exercicio[] exercicios, int index) {
    Exercicio[] novoExercicios = new Exercicio[exercicios.length - 1];

    for (int i = 0, k = 0; i < novoExercicios.length; i++) {
      if (i == index) {
        continue;
      }
      novoExercicios[k++] = exercicios[i];
    }

    return novoExercicios;
  }
}
