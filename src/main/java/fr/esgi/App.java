package fr.esgi;

import fr.esgi.interfaces.AppInterface;
import fr.esgi.menu.ConsoleActions;

import java.io.Console;
import java.util.Scanner;

public class App implements AppInterface {
    Scanner sc;
    boolean running;
    ConsoleActions menus = new ConsoleActions();

    public App(){}

    @Override
    public void start() {
        running = true;
        sc = new Scanner(System.in);
        System.out.println("Solid Library Kata");


        Integer choice = 0;

        while(running){
            System.out.println("Please select an action");
            menus.showActions();

            choice = sc.nextInt();

            switch (choice){

            }

        }
    }

    @Override
    public void readFileData() {

    }
}
