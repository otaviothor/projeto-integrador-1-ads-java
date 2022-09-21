# Projeto Integrador do curso tecnólogo em Análise e Desenvolvimento de Sistemas

O projeto interdisciplinar deste semestre tem como objetivo promover a integração das disciplinas de
Técnicas de Desenvolvimento de Algoritmos e Programação Orientada a Objetos e consiste na
construção de um sistema em Java que permita cadastro de itens, edições, consultas.

O grupo deverá desenvolver algoritmos e um programa em Java, com classes específicas
para resolver questões pertinentes ao seguinte sistema:

**Sistema de controle de treinos para academia.**

As classes criadas para resolução do problema deverão ter os atributos específicos ao elemento
denotado, e deverá conter todos os métodos get e set e construtores. Além de contemplar os
conceitos de Herança, Classes Abstratas e Polimorfismo e a definição de no mínimo 3 classes.

## Requisitos do sistema de controle de treinos para academia

### Programação orientada a objetos

O desenvolvimento deverá ser efetuado utilizando a
linguagem de programação Java, com as seguintes características:

- Construção dos diagramas UML;
- Utilizar os conceitos de POO;
- Criar pelo menos três classes com no mínimo dois métodos para cada classe.

### Técnicas de desenvolvimento de algoritmos

Utilizar os conceitos de variáveis, estruturas de
decisão, repetições, métodos e deverão criar algoritmos em pseudocódigo e/ou fluxogramas que
representem as diferentes funcionalidades do programa. Apresentar no relatório final todos os
pseudocódigos criados para o projeto.

## Fases do projeto

O projeto interdisciplinar será dividido em três etapas, consistindo na definição de
funcionalidades, desenvolvimento do software e apresentação final.

### Primeira fase – definição dos grupos de trabalho

Nesta fase os grupos deverão formar os grupos.

### Segunda fase – elaboração das funcionalidades

Construir os diagramas UML das classes e construir um esboço do sistema. Os
diagramas criados deverão ser apresentados no relatório final.

### Terceira fase – entrega do projeto

Deverão ser entregues até o prazo limite de 06/11/2022:

- O arquivo do sistema;
- O relatório conforme item 5 – Relatório.

Obs.: O projeto deve ser posto em uma pasta compactada (zipada) e entregar pelo Blackboard. Não serão aceitos trabalhos entregues fora do prazo e fora do Blackboard.

## Relatório

É requisito obrigatório que o grupo entregue, também, um relatório com a documentação do projeto, contendo:

- Descrição do sistema, finalidade, funcionalidades e como utilizar;
- Print de telas;
- Diagramas UML;
- pseudocódigos e/ou fluxogramas do sistema.

Obs.: O relatório deverá obrigatoriamente obedecer ao formato do template disponível no Blackboard da disciplina.

## Disposições gerais

O valor máximo da atividade é de 1,0 ponto, a ser computado na composição da avaliação
A2 de cada disciplina envolvida no projeto (TDA e POO). Para ser aprovado na
Disciplina de Projeto Interdisciplinar o aluno deverá obter média igual ou superior a
0,5.

Na hipótese da necessidade de alteração ou complementação das orientações previstas
neste documento, os alunos serão comunicados por meio da plataforma Blackboard.

## Integrantes

- Caio
- Cirilo
- Otávio
- Rivaldo

## Projeto em Java

O projeto que vai ser entregue está dentro do diretório [`projeto-academia`](/projeto-academia). Ele foi criado usando a estrutura básica em Java com o Maven, pra isso é necessário ter o Java e o Git instalado no seu computador.

Para rodar o projeto, basta abrir um `bash` no diretório do projeto e rodar o seguinte comando:

```sh
./mvnw compile exec:java -Dexec.mainClass="projetointegrador.ProjetoIntegrador"
```

Obs.: caso tenha alguma dificuldade em usar o Git, basta consultar essa [documentação](https://gist.github.com/leocomelli/2545add34e4fec21ec16).
