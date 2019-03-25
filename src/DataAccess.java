import java.sql.*;


class DataAccess {
    static final String DB_URL = "jdbc:h2:~/test";
    private String password = "-";
    private Connection connection = null;


    void establish() {
        try {
            System.out.println("Trying to establish connection... ");
            String username = "root";
            connection = DriverManager.getConnection(DB_URL, username, password);

            System.out.println("\u001B[32m" + "Connection with database " + connection.getSchema() + " established Successful! " + "\u001B[0m");
        } catch (Exception e) {
            System.err.println("Cannot establish connection ! ");
            e.printStackTrace();
        }
    }

    void select(String querry) {
        try {
            System.out.println("Trying to execute query...");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet s = statement.executeQuery(querry);
            if (s != null) {
                System.out.println("\u001B[32m" + "Successful! " + "\u001B[0m");
                s.last();
                if (s.getRow() > 0) {
                    s.beforeFirst();
                    System.out.println("\u001B[32m" + "Result: " + "\u001B[0m");
                    while (s.next()) {
                        for (int i = 1; i <= s.getMetaData().getColumnCount(); i++) {
                            if (i == 1) {
                                System.out.println();
                            }
                            System.out.print(s.getString(i) + " ");
                        }

                    }
                    System.out.println("\n");
                } else {
                    System.out.println("\u001B[36m" + "Result is empty!" + "\u001B[0m");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    void insert(String querry) {
        System.out.println("Trying to insert data...");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(querry);
            System.out.println("\u001B[32m" + "Table Droped successful!" + "\u001B[0m");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void dropTable(String querry) {
        System.out.println("Trying to drop table...");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(querry);

            System.out.println("\u001B[32m" + "Table Droped successful!" + "\u001B[0m");
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

    }

    void createTable(String querry) {
        System.out.println("Trying to create table...");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(querry);
            System.out.println("\u001B[32m" + "Successful! " + "\u001B[0m");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void update(String querry) {
        System.out.println("Trying to update table...");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(querry);
            System.out.println("\u001B[32m" + "Table updated Successful! " + "\u001B[0m");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    void close() {
        try {
            System.out.println("Trying to close connection with " + connection.getSchema() + "...");
            if (connection != null) {
                connection.close();
                System.out.println("\u001B[32m" + "Connection with database closed Successful! " + "\u001B[0m");
                System.out.println("\u001B[37m" + "Goodbye!" + "\u001B[0m");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}