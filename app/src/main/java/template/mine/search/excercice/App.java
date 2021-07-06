package template.mine.search.excercice;

import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Integer boardSize = Integer.parseInt(args[0]);
        
        ArrayList<String> rowConfiguration = readConfigurationData(args, boardSize);
        
        Integer[][] initialBoard = new Integer[boardSize][boardSize];
        
        //This function can be omitted
        initializationForTests(initialBoard, boardSize);
        
        //TODO: Implement solution
        
        //No delete
        showInitialBoard(initialBoard, boardSize);
    }
    
    private static ArrayList<String> readConfigurationData(String[] args, Integer boardSize) {
        ArrayList<String> rowConfiguration = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            rowConfiguration.add(args[1 + i]);
        }
        return rowConfiguration;
    }

    private static void initializationForTests(Integer[][] initialBoard, Integer boardSize) {
        Integer value = 1;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                initialBoard[i][j] = value;
                value++;
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
