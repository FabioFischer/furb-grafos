import java.util.ArrayList;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 03
 **
 **   Fábio Luiz Fischer
 **
 **     Escreva um método para determinar se uma cadeia  de  caracteres (string) é da forma: x C y,onde x e  y são cadeias de caracteres compostas por letras ‘A’ e/ou ‘B’,
 **     e y é o inverso de x. Isto é, se x = “ABABBA”, y deve equivaler a “ABBABA”. Em cada ponto, você só poderá ler o próximo caractere da cadeia. Use pilha.
 **     Exemplo de string válida: AAABBABABBACABBABABBAAA
 **
 **/

public class App {
    public static void main(String[] args) {
        ArrayList<Character> input;
        Stack<Character> stack;

        char separator = 'C';

        String[] cases = new String[]{
                "AAABBABABBACABBABABBAAA",
                "AAAABABAAAACABBABABBAAA",
                "",
                "AAA",
                "CCC",
                "aAbACAbAa",
                "ACa",
                "aca"};

        for (int i = 0; i < cases.length; i++) {
            input = new ArrayList<>();

            for (char c : cases[i].toCharArray()) {
                input.add(c);
            }

            // Popula pilha
            stack = new Stack<>(input);

            // Realiza verificação.
            // Define "C" como digito separador.
            System.out.println("Input " + cases[i] + ((stack.verifyInput(separator)) ? " é válido!" : " não é valido!"));
        }
    }
}
