
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 05
 **
 **   Fábio Luiz Fischer
 **
 **     A natureza é muito inteligente e a quedas das folhas faz parte de uma estratégia das árvores no outono.
 **     Esta estratégia servepara se proteger do frio e reduzir o gasto com energia.Como os dias são mais curtos no outono e há uma menor incidência de luz solar,
 **     as árvores precisam mudar sua  características  para  se  manterem  vivas.  Com  menos  luz  solar  a  primeira  coisa  que  acontece é  parar  de produzir clorofila.
 **     Por isso, as folhas começam a ficar amareladas.Com  a  diminuição  da  clorofila  no  outono,  as  árvores  passam  a  produzir um  hormônio  chamado  ácido abscísico.
 **     Este hormônio se acumula na haste das folhas,  matando qualquer célula desta região. Com isso a haste se rompe e as folhas caem e se acumulam pelo chão.
 **     Se a mesma coisa acontecesse com árvores binárias, quão grande seria as pilhas de folhas acumuladas?
 **     Assumimos que cada nó em uma árvore binária "cai" um número  de  folhas  igual  ao  valor  inteiro  armazenado  nesse  nó.
 **     Também  assumimos  que  estas  folhas  caem verticalmente no chão (felizmente, não há vento para explodí-los ao redor).
 **     Finalmente, assumimos que osnós são posicionados na horizontal,
 **     de tal maneira que os filhos a esquerda e a direita de um nó é exatamente uma unidade para a esquerda e uma unidade para a direita, respectivamente, do seu pai.
 **     Considere a seguinte árvore:
 **
 **               Árvore:                       5
 **                                           /  \
 **                                          7   3
 **                                          \  /
 **                                           6
 **               Pilha:                  =========
 **                                        7-11-3
 **
 **      Os nós contendo 5 e 6 tem a mesma posição horizontal (com diferentes posições verticais, é claro).
 **      O nó que contém 7 é uma unidade para a esquerda daqueles contendo 5 e 6, e contendo o nó 3 é uma unidade para a sua direita.
 **      Sendo assim, três pilhas são criados: a mais à esquerda contém 7 folhas (a partir do nó mais à esquerda),
 **      o próximo contém 11 (a partir dos nós contendo 5 e 6), e a pilha mais à direita contém 3.
 **      Faça um programa que calcule/mostre o somatório de cada pilha.
 **
 **/

public class App {
    public static void main(String[] args) {
        BinaryTree t1 = new BinaryTree();
        Node n1 = new Node(5), n2 = new Node(7), n3 = new Node(3), n4 = new Node(6);

        // Insere raiz
        t1.add(n1);
        try {
            // Insere folha em relação ao pai e a direção
            t1.add(n1, n2, Node.NodeDirection.LEFT_NODE);
            t1.add(n1, n3, Node.NodeDirection.RIGHT_NODE);
            t1.add(n2, n4, Node.NodeDirection.RIGHT_NODE);
            t1.add(n3, n4, Node.NodeDirection.LEFT_NODE);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("============================================");
        System.out.println(t1.toStringInOrder());
        System.out.println("============================================");
        System.out.println(t1.printSum());
        System.out.println("\n============================================");
    }
}
