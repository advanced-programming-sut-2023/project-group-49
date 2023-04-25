package view;

import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public void removeCotation(String string){
        if(string.matches("(\".+\")")){
            String result = string.substring(1,string.length()-1);
            string = result;
        }
    }
}
