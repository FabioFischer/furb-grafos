
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 02
 **
 **   Fábio Luiz Fischer
 **
 **     Uma  estratégia  alternativa  para  a  remoção  de  elementos  em  uma  lista  é  chamada  de lazy  deletion.
 **     Nesta estratégia, para remover um elemento, ele simplesmente é marcado (usando um atributo extra).
 **     O número de elementos removidos e não removidos na lista é mantido como parte da estrutura de dados.
 **     Quando existirem tantos  elementos  removidos  quanto  não  removidos,  a  lista  inteira  é  percorrida
 **     executando  o  algoritmo  de remoção padrão nos elementos marcados. Faça as modificações necessárias
 **     na respectiva estrutura de dados e escreva as rotinas para implementar as operações usando listas encadeadas aplicando a estratégia lazy deletion.
 **
 **/

public class App {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(10);

        System.out.println("Objetos: " + list.toString());
        System.out.println("Objetos Não Marcados: " + list.toStringNonDeletedNodes());
        System.out.println("Objetos Marcados: " + list.toStringDeletedNodes());
        System.out.println("\n\nDeletar 3");

        list.delete(3);

        System.out.println("Objetos: " + list.toString());
        System.out.println("Objetos Não Marcados: " + list.toStringNonDeletedNodes());
        System.out.println("Objetos Marcados: " + list.toStringDeletedNodes());
        System.out.println("\n\nDeletar 4");

        list.delete(4);

        System.out.println("Objetos: " + list.toString());
        System.out.println("Objetos Não Marcados: " + list.toStringNonDeletedNodes());
        System.out.println("Objetos Marcados: " + list.toStringDeletedNodes());
        System.out.println("\n\nAdd 2");

        list.add(2);

        System.out.println("Objetos: " + list.toString());
        System.out.println("Objetos Não Marcados: " + list.toStringNonDeletedNodes());
        System.out.println("Objetos Marcados: " + list.toStringDeletedNodes());
        System.out.println("\n\nDeletar 2");

        list.delete(2);

        System.out.println("Objetos: " + list.toString());
        System.out.println("Objetos Não Marcados: " + list.toStringNonDeletedNodes());
        System.out.println("Objetos Marcados: " + list.toStringDeletedNodes());
        System.out.println("\n\nDeletar 10");

        list.delete(10);

        System.out.println("Objetos: " + list.toString());
        System.out.println("Objetos Não Marcados: " + list.toStringNonDeletedNodes());
        System.out.println("Objetos Marcados: " + list.toStringDeletedNodes());
    }
}
