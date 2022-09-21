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

## classe treino

- nome: string
- descricao: string

## classe exercicio

- nome: string
- vídeo: string
- descricao: string

## tabela treino_exercicio

- id_usuario
- id_treino
- id_exercicio
- qtd_repeticao
- qtd_series
- tempo_descanso
