## Pessoa

- id: integer
- nome: string
- dataNascimento: string
- altura: float
- peso: float
- cpf: string
- email: string
- telefone: string

---

- Pessoa(): void
- Pessoa(nome: string, dataNascimento: string, altura: float, peso: float, cpf: string, email: string, telefone: string): void
- cadastrarPessoa(pessoa: Pessoa): boolean
- consultarPessoa(id: integer): Pessoa

## Endereco

- logradouro: string
- numero: string
- complemento: string
- bairro: string
- cep: string
- cidade: string
- estado: string
- pais: string

---

- Endereco()
- Endereco(logradouro: string, numero: string, complemento: string, bairro: string, cep: string, cidade: string, estado: string, pais: string)
- cadastrarEndereco(pessoa: Pessoa)
- consultarEndereco(id: integer)
- consultarEndereco(id: integer)

## Treino

- nome: string
- descricao: string

## Exercicio

- nome: string
- vídeo: string
- descricao: string
