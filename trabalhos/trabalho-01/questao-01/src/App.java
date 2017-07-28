
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Computação Gráfica
 **   Trabalho 01 - Questão 01
 **
 **   Fábio Luiz Fischer
 **
 **     Considere uma coleção de nomes de sites da web e seus respectivos links na Internet armazenados através de uma lista simplesmente encadeada.
 **     Escreva uma classe que contenha um método que, dado o nome de um site,
 **     busque o seu link correspondente na lista e ao mesmo tempo mova o nó que contém o nome buscado para o início da lista,
 **     de forma que ele possa ser encontrado mais rapidamente na próxima vez que for buscado.
 **
 **/

public class App {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("https://www.furb.br/dion/");
        list.add("https://github.com/");
        list.add("http://ava.furb.br/");
        list.add("http://www.furb.br/");
        list.add("https://www.google.com.br/");

        System.out.println(list.toString());

        System.out.println("\n\nBuscando " + list.get("http://ava.furb.br/"));
        System.out.println(list.toString());

        System.out.println("\n\nBuscando " + list.get("http://www.furb.br/"));
        System.out.println(list.toString());

        System.out.println("\n\nBuscando " + list.get("https://www.google.com.br/"));
        System.out.println(list.toString());

        System.out.println("\n\nBuscando " + list.get("http://ava.furb.br/"));
        System.out.println(list.toString());
    }
}
