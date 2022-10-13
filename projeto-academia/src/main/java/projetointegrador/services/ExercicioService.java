package projetointegrador.services;

import java.util.Scanner;

import javax.swing.JOptionPane;

import projetointegrador.models.Exercicio;

public class ExercicioService {
  Scanner scanner = new Scanner(System.in);

  public Exercicio editarEndereco(Exercicio endereco) {
    return endereco;
  }

  public Exercicio cadastrarExercicio() {
    Exercicio exercicio = new Exercicio();

    // captura o nome do exercicio
    do {
      exercicio.nome = JOptionPane.showInputDialog(null, "Informe o nome do exercício:", "Cadastro de novo exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicio.nome.length() < 5)
        JOptionPane.showMessageDialog(null, "O nome deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.nome.length() < 5);

    // captura a descricao do exercicio
    do {
      exercicio.descricao = JOptionPane.showInputDialog(null, "Informe a descrição do exercício:",
          "Cadastro de novo exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicio.descricao.length() < 5)
        JOptionPane.showMessageDialog(null, "A descrição deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.descricao.length() < 5);

    // captura o link do video do exercicio
    do {
      exercicio.video = JOptionPane.showInputDialog(null, "Informe o link do vídeo do exercício:",
          "Cadastro de novo exercício",
          JOptionPane.QUESTION_MESSAGE);

      if (exercicio.video.length() < 5)
        JOptionPane.showMessageDialog(null, "O link do vídeo deve ter no minímo 5 caracteres.", "Erro",
            JOptionPane.ERROR_MESSAGE);
    } while (exercicio.video.length() < 5);

    return exercicio;
  }
}
