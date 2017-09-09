
/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 03
 *
 *   Fábio Luiz Fischer
 *
 *     Implemente um programa que aponte a quantidade de árvores existem no grafo
 *
 **/

public class App {
    public static void main(String[] args) {
        int[][] matrizAdj = {
                {0, 3, 0, 0},
                {9, 0, 7, 0},
                {0, 0, 4, 2},
                {0, 0, 1, 0}};

        Grafo g = new Grafo(matrizAdj);

        System.out.println(g.toString());
    }
}