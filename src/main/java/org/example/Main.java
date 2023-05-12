package org.example;

import view.MainMenu;
import view.SignupMenuAndLoginMenu;

public class Main {
    public static void main(String[] args) {
        SignupMenuAndLoginMenu signupMenuAndLoginMenu=new SignupMenuAndLoginMenu();
        MainMenu mainMenu=new MainMenu();
        signupMenuAndLoginMenu.run();
        mainMenu.run();
    }
}