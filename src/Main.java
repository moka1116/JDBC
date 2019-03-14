public class Main {
    public static void main(String[] args) {
        DataAccess con = new DataAccess();
        con.establish();
        con.select("Select * from Customers");
        con.select("Select * from Events");
        con.dropTable("Drop table Customers");
        con.createTable("CREATE TABLE CUSTOMERS " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))");

        con.insert("Insert into EVENTS Values(3,22,3250,'Boston','BBCH')");
        con.update("UPDATE EVENTS SET PRICE = 5000 WHERE partyID = 2");
        con.close();


    }
}
