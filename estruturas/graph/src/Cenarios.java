public class Cenarios {
    public static void main(String[] args) {
//        Integer[][] matrizAdj = {
//                {0, null, null, 1, 1, null, null},
//                {null, 0, null, null, 1, 1, null},
//                {null, null, 0, null, null, 1, 1},
//                {1, null, null, 0, 1, null, null},
//                {1, 1, null, 1, 0, 1, null},
//                {null, 1, 1, null, 1, 0, 1},
//                {null, null, 1, null, null, 1, 0}};

//        Integer[][] matrizAdj = {
//          /*0*/  {0, 13, null, 17, null, null, 19, null, null, 19, null, 4},
//          /*1*/  {13, 0, 18, 9, null, null, null, null, 2, null, null, null},
//          /*2*/  {null, 18, 0, 20, 5, null, null, null, null, null, null, null},
//          /*3*/  {17, 9, 20, 0, null, null, null, null, null, null, null, null},
//          /*4*/  {null, null, 5, null, 0, 7, null, null, null, null, 20, 11},
//          /*5*/  {null, null, null, null, 7, 0, 4, null, null, null, null, 3},
//          /*6*/  {19, null, null, null, null, 4, 0, 8, null, null, null, 18},
//          /*7*/  {null, null, null, null, null, null, 8, 0, null, 3, 10, null},
//          /*8*/  {null, 2, null, null, null, null, null, null, 0, 16, 14, null},
//          /*9*/  {19, null, null, null, null, null, null, 3, 16, 0, 12, null},
//          /*10*/ {null, null, null, null, 20, null, null, 10, 14, 12, 0, null},
//          /*11*/ {4, null, null, null, 11, 3, 18, null, null, null, null, 0}};

        Integer[][] matrizAdj = {
         /*1*/  {0, 1, null, null, null, null},
         /*2*/  {null, 0, 1, null, 1, null},
         /*3*/  {1, null, 0, 1, null, null},
         /*4*/  {null, null, 1, 0, null, 1},
         /*5*/  {null, null, 1, 1, 0, null},
         /*6*/  {1, 1, 1, null, null, 0}};

//        System.out.println(Algoritmos.tipoDoGrafo(matrizAdj));
//        System.out.println(Algoritmos.arestasDoGrafo(matrizAdj));
//        System.out.println(Algoritmos.grausDoVertice(matrizAdj));
//        System.out.println(Algoritmos.dfs(matrizAdj));
//        System.out.println(Algoritmos.bfs(matrizAdj, 0));
//        System.out.println(Algoritmos.dijkstra(matrizAdj, 0));
//        System.out.println(Algoritmos.floydWarshall(matrizAdj));
//        System.out.println(Algoritmos.conjuntosDisjuntos(matrizAdj));
//        System.out.println(Algoritmos.fleury(matrizAdj));
//        System.out.println(Algoritmos.fleury(matrizAdj, 5));
//        System.out.println(Algoritmos.carteiroChines(matrizAdj));
        System.out.println(Algoritmos.robertsEFlores(matrizAdj));
    }
}