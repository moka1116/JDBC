public class Main {
    public static void main(String[] args) {
        DataAccess con = new DataAccess();
        con.establish();
        Thread thread1 = new Thread(con::close);
        Thread thread = new Thread(() ->
        {
            synchronized (con) {
                con.select("Select * from Customers");
                con.dropTable("Drop table Customers");
                con.select("Select * from Events");
                thread1.start();
            }

        });

        con.createTable("CREATE TABLE CUSTOMERS " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))");
        thread.start();


    }
}
