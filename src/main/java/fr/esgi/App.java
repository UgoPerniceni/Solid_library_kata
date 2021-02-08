package fr.esgi;

import fr.esgi.data.SerializerBook;
import fr.esgi.data.SerializerUser;
import fr.esgi.enumeration.Role;
import fr.esgi.interfaces.AppInterface;
import fr.esgi.menu.ConsoleActions;
import fr.esgi.model.*;

import java.util.Scanner;

public class App implements AppInterface {
    Scanner sc;

    boolean running;
    boolean isConnected = false;

    UserList users = new UserList();
    Library library = new Library();

    User userConnected;

    public App(){}

    @Override
    public void start() {
        running = true;
        sc = new Scanner(System.in);
        System.out.println("Solid Library Kata");

        try {
            SerializerUser serializerUser = new SerializerUser();
            SerializerBook serializerBook = new SerializerBook();

            users.updateUsers(serializerUser.JsonToList());
            library.updateBooks(serializerBook.JsonToList());

            int choice = 0;

            // Je ne vois absolument pas comment découper proprement ce block désolé.

            while(running){

                while(!isConnected){
                    System.out.println("Please select an action");
                    ConsoleActions.showConnectedActions();
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch(choice){
                        case 1:
                            System.out.println("Please enter your login");
                            User user = new User(sc.nextLine());
                            if(users.contains(user)){
                                isConnected = true;
                                userConnected = users.getUser(user);
                                System.out.println("Connected !");
                            } else {
                                System.out.println("Wrong login");
                            }
                            break;
                        case 2:
                            System.out.println("Please enter a Username");
                            User newUser = new User(sc.nextLine());
                            if(users.contains(newUser)){
                                System.out.println("UserName already exist !");
                            } else {
                                users.addNewUser(newUser);
                                userConnected = newUser;
                                System.out.println("Connected !");
                                isConnected = true;
                            }
                            break;
                        case 3:
                            System.exit(0);
                            break;
                    }
                }

                System.out.println("Please select an action");
                ConsoleActions.showActions();
                choice = sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        if(!userConnected.getRole().equals(Role.Guest)){
                            System.out.println(library.toString()
                                    + "\nPlease Enter the book's name");

                            String bookTitle = sc.nextLine();

                            if(library.contains(bookTitle)){
                                Book book = library.getBookByTitle(bookTitle);
                                userConnected.borrowBook(library, book);
                            } else {
                                System.out.println("Book not found !");
                            }

                        } else {
                            System.out.println("You mustn't be a Guest !");
                        }
                        break;
                    case 2:
                        if(userConnected.getRole().equals(Role.Librarian)){
                            System.out.println("Please enter a Title");
                            String title = sc.nextLine();
                            System.out.println("Please enter an Author name");
                            String authorName = sc.nextLine();

                            library.addBook(new Book(title, new Author(authorName)));
                        } else {
                            System.out.println("You must be a Librarian to add a new book !");
                        }
                        break;
                    case 3:
                        serializerUser.ListToJson(users.getUsers());
                        serializerBook.ListToJson(library.getBooks());

                        System.out.println("Data saved to JSON (Users & Books)!");
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void readFileData() {

    }
}
