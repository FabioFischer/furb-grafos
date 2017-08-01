import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Random;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 04
 **
 **   Fábio Luiz Fischer
 **
 **     O problema "Resta Um" descreve a seguinte situação: Um grupo de soldados está cercado e não há esperança de  vitória,
 **     porém  existe  somente  um  cavalo  disponível  para  escapar  e  buscar  por  reforços.
 **     Para  determinar qual soldado deve escapar para encontrar ajuda, eles formam um círculo e sorteiam um número de um chapéu.
 **     Começando  por  um  soldado  sorteado  aleatoriamente,uma  contagem  é  realizada  até  o  número  sorteado.
 **     Quando a contagem terminar, o soldado  em que a contagem parou é removido do círculo,
 **     um novo número é sorteado e a contagem recomeça no soldado seguinte ao que foi eliminado.
 **     A cada rodada, portanto, o círculo diminui em um, até que sobre apenas um soldado, sendo o escolhido para a tarefa.
 **     Utilizando um vetor de tamanho 10, sorteie números entre ‐9 e 9 a cada consulta ao chapéu e simule o processo,
 **     imprimindo o número do soldado eliminado a cada rodada e o número do soldado escolhido ao final.
 **     Valores negativos fazem a contagem andar para a esquerda, enquanto valores positivos andam para a direita.
 **     Considere que 0 é um valor inválido e realize um novo sorteio neste caso.
 **     Represente os soldados na estrutura de dados como um tipo capaz de armazenar um identificar único para cada individuo.
 **
 **/

public class App extends Application {

    public static final int RANDOM_THRESHOLD = 9;

    private static void showDialogMessage(String title, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CircularLinkedList<String> list = new CircularLinkedList<>();

        // Adiciona soldados para lista
        for (String soldier : new String[]{"João", "Roberto", "Patrick", "Bruna", "Hans", "Yuri", "Marina", "Teresa", "Victor", "Roussel"}) {
            list.add(soldier);
        }

        System.out.println(list.toString());

        Node<String> deleted;
        int lastPosition = 0;
        int rndNumber;

        do {
            do {
                rndNumber = randInt(-RANDOM_THRESHOLD, RANDOM_THRESHOLD);
            } while (rndNumber == 0);

            // Deleta soldado a partir da posição anterior + number aleatório
            deleted = list.delete(lastPosition + rndNumber);

            if (deleted != null) {
                System.out.println(
                        "\nSoldado sorteado: " + deleted.getKey() +
                        "\nNúmero sorteado: " + rndNumber +
                        "\nUltima posição: " + lastPosition +
                        "\n" + list.toString());

                showDialogMessage(
                        "Resta Um",
                        "Soldado eliminado: " + deleted.getKey() + "\nPosição do soldado: " + deleted.getIndex() + "\nNúmero sorteado: " + rndNumber + "\nPosição inicial: " + lastPosition,
                        "Soldados Restantes: " + list.getSize(),
                        Alert.AlertType.INFORMATION);

                lastPosition = deleted.getIndex();
            }
        } while (list.getSize() != 1);

        System.out.println(
                "\n=================================================================================" +
                "\nSoldado restante: " +  list.getFirst().getKey() +
                "\n=================================================================================");

        // Ultimo soldado
        showDialogMessage(
                "Resta Um",
                "Soldado restante: " + list.getFirst().getKey(),
                list.getFirst().getKey() + " foi o escolhido para realizar a tarefa.",
                Alert.AlertType.INFORMATION);
    }

    public static void main(String[] args) {
        try {
            launch();
        } catch (Exception ignored) {
        }
    }
}
