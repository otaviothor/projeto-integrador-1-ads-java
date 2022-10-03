package projetointegrador.models;

public class Endereco {
  public int id;
  public String logradouro;
  public String numero;
  public String complemento;
  public String bairro;
  public String cep;
  public String cidade;
  public String estado;
  public String pais;

  public Endereco(
      int id,
      String logradouro,
      String numero,
      String complemento,
      String bairro,
      String cep,
      String cidade,
      String estado,
      String pais) {
    this.id = id;
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cep = cep;
    this.cidade = cidade;
    this.estado = estado;
    this.pais = pais;
  }
}
