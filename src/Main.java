public class Main {
    public static void main(String[] args) {
        DataAccess con = new DataAccess();
        con.establish();
        con.select("Select * from Customers");
        con.select("Select * from Events");
        con.createTable("CREATE TABLE CUSTOMERS " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))");
        con.dropTable("Drop table Customers");
        con.close();


    }
}
