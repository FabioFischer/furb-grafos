import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 02
 *
 *   Fábio Luiz Fischer
 *
 *   Mania de par (https://www.urionlinejudge.com.br/judge/pt/problems/view/1931)
 *
 *   Patrícia é uma ótima desenvolvedora de software. No entanto, como quase toda pessoa brilhante, ela tem algumas manias estranhas, e uma delas é que tudo que ela faz tem que ser em número par.
 * Muitas vezes essa mania não atrapalha, apesar de causar estranhamento nos outros. Alguns exemplos: ela tem que fazer diariamente um número par de refeições;
 * no café da manhã toma duas xícaras de	café, duas torradas e duas fatias de queijo; sempre que vai ao cinema compra dois bilhetes de entrada (felizmente sempre tem um amigo ou amiga lhe acompanhando);
 * e toma dois banhos por dia (ou quatro, ou seis...).
 * Mas algumas vezes essa mania de Patrícia atrapalha. Por exemplo, ninguém gosta de viajar de carro com ela, pois se no trajeto ela tem que pagar pedágios, o número de pedágios que ela paga tem que ser par.
 *
 *   Patrícia mora em um país em que todas as estradas são bidirecionais e têm exatamente um pedágio. Ela precisa ir visitar um cliente em uma outra cidade,
 * e deseja calcular o mínimo valor total de pedágios que ela tem que pagar, para ir da sua cidade à cidade do cliente, obedecendo à sua estranha mania de que o número de pedágios pagos tem que ser par.
 *
 *
 * Entrada
 *
 *    A entrada consiste de diversas linhas. A primeira linha contém 2 inteiros C e V, o número total de cidades e o número de estradas (2 ≤ C ≤ 104 e 0 ≤ V ≤ 50000).
 *  As cidades são identificadas por inteiros de 1 a C. Cada estrada liga duas cidades distintas, e há no máximo uma estrada entre cada par de cidades.
 *  Cada uma das V linhas seguintes contém três inteiros C1, C2 e G, indicando que o valor do pedágio da estrada que liga as cidades C1 e C2 é G (1 ≤ C1, C2 ≤ C e 1 ≤ G ≤ 104).
 *  Patrícia está atualmente na cidade 1 e a cidade do cliente é C.
 *
 *
 * Saída
 *
 *    Uma única linha deve ser impressa, contendo um único inteiro, o custo total de pedágios para Patrícia ir da cidade 1 à cidade C, pagando um número par de pedágios, ou, se isso não for possível, o valor −1.
 *
 **/

public class App {

    public static boolean validaC(int c) {
        return c >= 2 && c <= 10000;
    }

    public static boolean validaV(int v) {
        return v >= 0 && v <= 50000;
    }

    public static boolean validaC1(int c1) {
        return c1 >= 1;
    }

    public static boolean validaC2(int c2) {
        return c2 >= 1;
    }

    public static boolean validaG(int g) {
        return g >= 1 && g <= 104;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("[Num de cidades][espaço][Num de estradas]");
            String cabecalho = br.readLine();

            int c = Integer.parseInt(cabecalho.split("\\s+")[0]), v = Integer.parseInt(cabecalho.split("\\s+")[1]);

            if (validaC(c) && validaV(v)) {
                Grafo grafo = new Grafo();
                System.out.println("\n[origem][espaço][destino][espaço][qtd pedagios]   " + v + " linhas");

                for (int i = 0; i < v; i++) {
                    String adj = br.readLine();

                    int c1 = Integer.parseInt(adj.split("\\s+")[0]), c2 = Integer.parseInt(adj.split("\\s+")[1]), g = Integer.parseInt(adj.split("\\s+")[2]);

                    if (validaC1(c1) && validaC2(c2) && validaG(g)) {
                        // Grafo é bidirecional
                        grafo.addAresta(g, c1, c2);
                        grafo.addAresta(g, c2, c1);
                    } else {
                        break;
                    }
                }

                System.out.println(grafo.toString());
                // Patrícia está atualmente na cidade 1 e a cidade do cliente é C
                System.out.println("Qtd de pedágios: " + grafo.qtdPedagios(1, c));
            } else {
                System.out.println("Input inválido!");
            }
        } catch (IOException e) {
            System.out.println("Erro ao receber inputs! " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Formato de input inválido! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}