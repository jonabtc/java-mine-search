package template.mine.search.excercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Integer boardSize = Integer.parseInt(args[0]);
        
        String[][] rowConfiguration = readConfigurationData(args, boardSize);

        Integer[][] initialBoard = new Integer[boardSize][boardSize];


        //This function can be omitted
        initializationForTests(initialBoard, boardSize);

        for (int i = 0; i < boardSize ; i++) {
            for (int j = 0; j < boardSize; j++){
                if(rowConfiguration[i][j].equalsIgnoreCase("true")) {

                    if (j + 1 < boardSize) {
                        initialBoard[i][j + 1] += 1;//right
                    }
                    if (j - 1 >= 0) {
                        initialBoard[i][j - 1] += 1;//left
                    }
                    if (i + 1 < boardSize) {
                        initialBoard[i + 1][j] += 1;//top
                    }
                    if (i - 1 >= 0) {
                        initialBoard[i - 1][j] += 1;//bottom}

                    }
                    if(i + 1 < boardSize && j + 1 < boardSize) {
                        initialBoard[i + 1][j + 1] += 1;//rigth-top
                    }
                    if(i + 1 < boardSize && j - 1 >= 0) {
                        initialBoard[i + 1][j - 1] += 1;//left-top
                    }
                    if(i - 1 >= 0 && j + 1 < boardSize) {
                        initialBoard[i - 1][j + 1] += 1;//rigth-bottom
                    }
                    if(i - 1 >= 0 && j - 1 >= 0) {
                        initialBoard[i - 1][j - 1] += 1;//left-bottom
                    }
                }
            }
        }

        //No delete
        showInitialBoard(initialBoard, boardSize);
    }
    
    private static String[][] readConfigurationData(String[] args, Integer boardSize) {
        String[][] rowConfiguration = new String[boardSize][];
        for (int i = 0; i < boardSize; i++) {
            String[] data = args[1 + i].split(",");
            rowConfiguration[i]=data;
        }
        return rowConfiguration;
    }

    private static void initializationForTests(Integer[][] initialBoard, Integer boardSize) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                initialBoard[i][j] = 0;
            }
        }
    }

    private static void showInitialBoard(Integer[][] initialBoard, Integer boardSize) {
        System.out.print("\nThe Minesweeper configuration is: ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print("[");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(initialBoard[i][j]);
                if (j < boardSize - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < boardSize - 1) {
                System.out.print(",");
            }
        }
    }
    
}
