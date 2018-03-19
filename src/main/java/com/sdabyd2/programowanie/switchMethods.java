package com.sdabyd2.programowanie;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class switchMethods {

    public static void addCustomer(Connection connection, Scanner scanner) throws SQLException {
            System.out.println("Podaj dane klienta wypożyczalni samochodów:");

            System.out.println("Podaj imię");
            String fist_name = scanner.nextLine();
            System.out.println("Podaj nazwisko");
            String last_name = scanner.nextLine();
            System.out.println("Podaj adres");
            String address = scanner.nextLine();
            System.out.println("Podaj kod pocztowy");
            String postal_code = scanner.nextLine();
            System.out.println("Podaj adres email");
            String email = scanner.nextLine();
            if (fist_name.isEmpty() || last_name.isEmpty() || address.isEmpty() || postal_code.isEmpty()){
                System.out.println("Nie podałeś wymaganych danych, dodawanie klienta zakończone niepowodzeniem.");
                throw new IllegalArgumentException();
            }else if (email.isEmpty()){
                email=null;
            }
        String sql1 = "insert into customer(fist_name, last_name,address,postal_code,email) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, fist_name);
        preparedStatement.setString(2, last_name);
        preparedStatement.setString(3, address);
        preparedStatement.setString(4, postal_code);
        preparedStatement.setString(5, email);
        preparedStatement.executeUpdate();

    }
    public static void viewListOfCustomers(Statement statement) throws SQLException {
        System.out.println("Lista klientów wypożyczalni:\n");
        String sql2="select * from customer";
        ResultSet resultSet = statement.executeQuery(sql2);
        while (resultSet.next()){
            System.out.println(resultSet.getInt("cust_id") + "|"
                    + resultSet.getString("fist_name").toUpperCase() + "|"
                    + resultSet.getString("last_name").toUpperCase()
                    + "|" + resultSet.getString("address").toUpperCase() + "|"
                    + resultSet.getString("postal_code").toUpperCase());
        }
    }
    public static void editCustomer(Scanner scanner, Connection connection, Statement statement)throws SQLException{
        System.out.println("Podaj id klienta którego dane chcesz zmodyfikować.");
        int cust_id = scanner.nextInt();
        System.out.println("Czy chcesz zmienić imię ?");
        String choose = scanner.nextLine().toLowerCase();
        if (choose.contains("t")){
            System.out.println("Podaj imię");
            String fist_name = scanner.nextLine();
            String sql3 = "update customer set fist_name = ? where cust_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1,fist_name);
            preparedStatement.setInt(2,cust_id);
            preparedStatement.executeUpdate();
        }
        System.out.println("Czy chcesz zmienić nazwisko ?");
        choose = scanner.nextLine().toLowerCase();
        if (choose.contains("t")){
            System.out.println("Podaj nazwisko");
            String last_name = scanner.nextLine();
            String sql3 = "update customer set last_name = ? where cust_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1,last_name);
            preparedStatement.setInt(2,cust_id);
            preparedStatement.executeUpdate();
        }
        System.out.println("Czy chcesz zmienić adres zamieszkania ?");
        choose = scanner.nextLine().toLowerCase();
        if (choose.contains("t")){
            System.out.println("Podaj adres");
            String address = scanner.nextLine();
            String sql3 = "update customer set address = ? where cust_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1,address);
            preparedStatement.setInt(2,cust_id);
            preparedStatement.executeUpdate();
        }
        System.out.println("Czy chcesz zmienić kod pocztowy ?");
        choose = scanner.nextLine().toLowerCase();
        if (choose.contains("t")){
            System.out.println("Podaj kod pocztowy");
            String postal_code = scanner.nextLine();
            String sql3 = "update customer set postal_code = ? where cust_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1,postal_code);
            preparedStatement.setInt(2,cust_id);
            preparedStatement.executeUpdate();
        }
        System.out.println("Czy chcesz zmienić email ?");
        choose = scanner.nextLine().toLowerCase();
        if (choose.contains("t")){
            System.out.println("Podaj adres email");
            String email = scanner.nextLine();
            String sql3 = "update customer set email = ? where cust_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1,email);
            preparedStatement.setInt(2,cust_id);
            preparedStatement.executeUpdate();
        }
    }
}
