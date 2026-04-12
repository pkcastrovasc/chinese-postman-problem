# Trabalho Prático 3 - Problema do Carteiro Chinês em Dígrafos Ponderados

Este repositório contém a solução para o Trabalho Prático 3 da disciplina de Resolução de Problemas com Grafos (UNIFOR). O objetivo é encontrar um **circuito euleriano** de custo mínimo em um dígrafo ponderado, modelando o Problema do Carteiro Chinês.

A implementação utiliza **Java** e as bases da biblioteca **algs4**, aplicando o **Método de Hierholzer** em um grafo previamente eulerizado (balanceado) de forma manual.

---

## 🛠️ Explicação da Eulerização (Parte Manual)

O grafo original (fornecido na Figura 1) não possuía um circuito euleriano por conter vértices **desbalanceados** (grau de entrada diferente do grau de saída). 

Após o cálculo manual dos graus de cada vértice, identificamos os seguintes desbalanceamentos:
* **Vértices com excesso de saída:** `[Citar os vértices. Ex: 0 (a) e 4 (e)]`
* **Vértices com falta de saída (excesso de entrada):** `[Citar os vértices. Ex: 1 (b) e 5 (f)]`

**Justificativa das inserções:**
Para eulerizar o grafo, atuamos manualmente simulando o resultado de algoritmos de emparelhamento e caminhos mínimos. Adicionamos arestas "fantasmas" (que representam a reutilização de ruas) conectando os vértices que tinham sobra de saída aos que precisavam de entrada, buscando o menor custo possível.

As seguintes arestas/caminhos foram duplicadas e acrescentadas no arquivo `dados/entrada_eulerizada.txt`:
* Caminho de `[Vértice Origem]` para `[Vértice Destino]` (Custo: `[Valor]`)
* Caminho de `[Vértice Origem]` para `[Vértice Destino]` (Custo: `[Valor]`)

Com essas adições, garantimos que todos os vértices passassem a ter `indegree(v) == outdegree(v)`, satisfazendo a condição necessária para a existência do circuito.

---

## ▶️ Instruções de Execução

O projeto foi desenvolvido em **Java** e pode ser executado através de IDEs como IntelliJ IDEA ou Eclipse.

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/pkcastrovasc/chinese-postman-problem
2. **Abra o projeto na sua IDE:**

* Certifique-se de que o arquivo `pom.xml` foi carregado para gerenciar a dependência da biblioteca algs4.

3. **Arquivos de Entrada:**

* Os arquivos que representam o grafo estão na pasta dados/. O programa lerá por padrão o grafo já balanceado em dados/entrada_eulerizada.txt.

4. **Execução:**

* Navegue até o diretório `src/` e abra o arquivo principal (`Main.java`).

* Execute a classe `Main`.

5. **Saídas no Console:**

* O programa fará a verificação e confirmará o balanceamento dos vértices.

* Em seguida, imprimirá a sequência exata de vértices que formam o Circuito Euleriano utilizando o algoritmo de Hierholzer.

* Por fim, exibirá o Custo Total da rota do carteiro.

## 🎥 Vídeo Explicativo
Abaixo está o link para o vídeo explicativo da dupla/aluno, detalhando a eulerização manual, a implementação do método de Hierholzer e a demonstração da execução do código:

🔗 [Clique aqui para assistir ao vídeo explicativo](https://youtu.be/_sT-CEHFG4Y)
