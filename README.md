# Conversor de Moedas

O **Conversor de Moedas** é um programa Java simples que permite a conversão de valores monetários entre diversas moedas internacionais, utilizando taxas de câmbio em tempo real fornecidas por uma API pública.

## Funcionalidades
- Suporte para conversão entre mais de 30 moedas internacionais.
- Conexão com a API pública [Frankfurter](https://www.frankfurter.dev) para obter taxas de câmbio atualizadas.
- Disponível como um JAR executável, permitindo execução em qualquer sistema com Java instalado.

## Pré-requisitos
- **Java 17** ou superior.
- Nenhuma instalação adicional de Maven é necessária para executar o JAR final.

## Como usar sem o maven instalado
### 1. Usando o JAR executável
1. Baixe ou clone este repositório: git clone https://github.com/dedecode/Conversor-de-Moedas.git

2. Entre na pasta `target` do projeto e copie seu caminho.

3. Através do prompt de comando, caminhe até a pasta target onde o JAR está localizado.
   ```bash
   cd <caminho onde sua pasta target se encontra>
   ```

4. Execute o programa com o comando:
     ```bash
   java -jar conversordemoedas-1.0-SNAPSHOT.jar
   ```
      
5. Siga as instruções no terminal para realizar a conversão de moedas.

### 2. Usando com o maven 
1. Certifique-se de que o Maven está instalado no sistema.

2. Clone este repositório: git clone https://github.com/dedecode/Conversor-de-Moedas.git

3. Execute o projeto.

## Tecnologias utilizadas
- **Java 17**
- **Maven** para gerenciamento de dependências e empacotamento.
- **OkHttp** para requisições HTTP.
- **JSON** para manipulação de dados obtidos da API.

## API utilizada
- [Frankfurter API](https://www.frankfurter.dev): Fornece taxas de câmbio atualizadas entre diversas moedas globais.

