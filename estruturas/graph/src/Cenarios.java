public class Cenarios {
    public static void main(String[] args) {
        Integer[][] matrizAdj = {
                {0, null, null, 1, 1, null, null},
                {null, 0, null, null, 1, 1, null},
                {null, null, 0, null, null, 1, 1},
                {1, null, null, 0, 1, null, null},
                {1, 1, null, 1, 0, 1, null},
                {null, 1, 1, null, 1, 0, 1},
                {null, null, 1, null, null, 1, 0}};


//        System.out.println(Algoritmos.tipoDoGrafo(matrizAdj));
//        System.out.println(Algoritmos.arestasDoGrafo(matrizAdj));
//        System.out.println(Algoritmos.grausDoVertice(matrizAdj));
//        System.out.println(Algoritmos.dfs(matrizAdj));
//        System.out.println(Algoritmos.bfs(matrizAdj, 0));
//        System.out.println(Algoritmos.dijkstra(matrizAdj, 0));
//        System.out.println(Algoritmos.floydWarshall(matrizAdj));
//        System.out.println(Algoritmos.conjuntosDisjuntos(matrizAdj));
//        System.out.println(Algoritmos.fleury(matrizAdj));
        System.out.println(Algoritmos.fleury(matrizAdj, 5));
    }
}