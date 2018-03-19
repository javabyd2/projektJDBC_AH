package com.sdabyd2.programowanie;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection connection = DBConnector.getConnection();
        try {
            Statement statement = connection.createStatement();
            switchMethods switchMethods = new switchMethods();
            Scanner scanner = new Scanner(System.in);
            int n = 0;
            String menu = ("1. Dodaj klienta\n" +
                "2. Wyświetl klientów\n" +"3. Edytuj klienta\n" + "4. Wyjście");

            System.out.println(menu);
            n = scanner.nextInt();
            while(n!=4) {
                switch (n) {
                    case 1:
                        switchMethods.addCustomer(connection, scanner);
                        System.out.println("Dodano nowego klienta.");
                        System.out.println(menu);
                        n = scanner.nextInt();
                        break;
                    case 2:
                        switchMethods.viewListOfCustomers(statement);
                        System.out.println(menu);
                        n = scanner.nextInt();
                        break;
                    case 3:
                        switchMethods.editCustomer(scanner,connection,statement);
                        System.out.println("Zmieniono dane klienta.");
                        System.out.println(menu);
                        n = scanner.nextInt();
                        break;
                    default:
                        System.out.println("Nie wybrałeś żadnej dostępnej opcji :-(\n" +
                                "Spróbuj ponownie lub wcisnij 4 aby wyjść z programu.");
                        System.out.println(menu);
                        n = scanner.nextInt();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Zamknięto program.");
            //DBConnector.closeConnection();
        }
    }
}

