# Seleção 2019

Estamos buscando candidatos para fazer parte do nosso time, então criamos este pequeno desafio para melhor conhecer as qualidade de cada um.

Neste desafio será avaliado os conhecimento em:
- Linguagens de programação;
- Testes automatizados;
- Análise e modelagem de dados;
- Arquitetura REST
- GIT
- Arquitetura de software
- Padrões de projeto

### Objetivo

Criar um microsserviço utilizando arquitetura REST em linguagem de programação orientada a objetos e utilizando banco de dados

### Requisitos

- Utilizar uma linguagem de programação orientada a objetos (como Java ou Python)
- Criar um modelo de dados para a representação das seguintes entidades Pessoa e Endereço;
- Utilizar um banco de dados SQL embutido (SQLite por exemplo) (caso desejável utilizar *também* uma base NoSQL - MongoDB por exemplo); 
- Criar uma API REST para lidar com obtenção, criação e exclusão de Pessoas e seus endereços;
- Criar testes unitários;

### Desejável

- Ter especificação da API testável, com o swagger por exemplo;
- Ter testes funcionais para a API;

## Como foi realizado:
- Utilizado o banco de dados H2.
- Os modelos de dados estão localizados em: `/src/main/model`
- Teste estão localizados em: `/src/test`
- Especificação da API com swagger (arquivo .yaml), localizado em: `/src/main/swagger` 
