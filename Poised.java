

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class Poised {
    //Define the attributes for the poised class
    //Define the methods of the class
    //Create getters and setters
    String project_name;
    int due_day;
    int due_month;
    String fee_paid;
    String contractor;
    String complete;
    String erf;
    String customer;
    String architect;

    public Poised(String project_name, int due_date, int due_month, String fee_paid, String customer,
                  String contractor, String architect, String complete, String erf) {
        this.project_name = project_name;
        this.due_day = due_date;
        this.due_month = due_month;
        this.fee_paid = fee_paid;
        this.customer = customer;
        this.contractor = contractor;
        this.architect = architect;
        this.complete = complete;
        this.erf = erf;
    }

    public String getProject_name() {
        return project_name;
    }

    public int getDue_day() {
        return due_day;
    }

    public int getDue_month() {
        return due_month;
    }

    public String getFee_paid() {
        return fee_paid;
    }

    public String getCustomer() {
        return customer;
    }

    public String getArchitect() {
        return architect;
    }

    public String getContractor() {
        return contractor;
    }

    public String getComplete() {
        return complete;
    }

    public String getErf() {
        return erf;
    }

    public void setDue_day(int due_day) {
        this.due_day = due_day;
    }

    public void setDue_month(int due_month) {
        this.due_month = due_month;
    }

    public void setFee_paid(String fee_paid) {
        this.fee_paid = fee_paid;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setArchitect(String architect) {
        this.architect = architect;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public void setErf(String erf) {
        this.erf = erf;
    }

    public String toString() {
        String output = "Project Name: " + project_name;
        output += "\nDue Date:" + due_day;
        output += "\nDue Month:" + due_month;
        output += "\nFee Paid: R " + fee_paid;
        output += "\nFee Paid: R " + customer;
        output += "\nContractor: " + contractor;
        output += "\nFee Paid: R " + architect;
        output += "\nComplete: " + complete;
        return output;
    }

    public static void main(String[] args) {
        //Initialize the class objects
        //this try block will check to see if the class exist if it does it will run the program
        Scanner d = new Scanner(System.in);
        String Tdate;
        System.out.print("Enter todays date i.e. YYYY-MM-DD: ");
        Tdate = d.nextLine();
        try {
            //Creating a few class constructors
            Poised pro = new Poised("Roofing", 22, 3, "2500000", "Thabo",
                    "Ron-Contractors", "Archiworld", "yes", "533");


            //
            Connection con = null;
            PreparedStatement p = null;
            ResultSet rs = null;
            String[][] Poised = new String[10][7];
            con = connector.connect();
            int k = 0;
            try {
                p = con.prepareStatement("select * from projects");
                rs = p.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getInt("ERF") + "\t" + rs.getString("name") + "\t" + rs.getString("contractor")
                            + "\t" + rs.getString("architect") + "\t" + rs.getString("customer")
                            + "\tR" + rs.getInt("fee") + "\t" + rs.getString("date") + "\t");

                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            System.out.print("\n---- --- ---------------------------- ---- -----\n");

            //
            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/poised",
                        "root",
                        "Sql2022@Sm"
                );
                Statement statement = connection.createStatement();
                ResultSet results;
                int rowsAffected;


                results = statement.executeQuery("select * from projects;");
                while (k < 100) {
                    //The while loop will run indefinitely
                    //The if statement will allow the user to use the functionality and select which option they'd like to do
                    ;

                    System.out.print("""
                            1-Add a new project
                            2-to change due date
                            3-update erf number
                            4-to change fee  paid
                            5-Display all Tables
                            6-Finalise projects
                            7-Add to incomplete/complete table
                            8-exit
                            :\s""");

                    Scanner s = new Scanner(System.in);
                    int choice = s.nextInt();
                    System.out.print("\n---- --- ---------------------------- ---- -----\n");

                    if (choice == 4) {
                        //Request user input for the ERF number
                        int Ofee, fee;
                        Scanner z = new Scanner(System.in);
                        System.out.print("Enter old Fee Paid :");
                        Ofee = z.nextInt();

                        Scanner q = new Scanner(System.in);
                        System.out.print("Enter new Fee Paid :");
                        fee = q.nextInt();

                        rowsAffected = statement.executeUpdate(
                                "UPDATE projects SET fee='" + fee + "' WHERE fee='" + Ofee + "'"

                        );
                        System.out.println("Query complete ," + rowsAffected + " row changed.\n");
                        printAllFromTable(statement);

                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                    } else if (choice == 2) {
                        //view the project data
                        //Then request the user input for old deadline and new deadline
                        String od, deadline;
                        Scanner a = new Scanner(System.in);
                        System.out.print("Enter the old deadline :");
                        od = a.nextLine();

                        Scanner d1 = new Scanner(System.in);
                        System.out.print("Enter the new deadline :");
                        deadline = d1.nextLine();
                        rowsAffected = statement.executeUpdate(
                                "UPDATE projects SET date='" + deadline + "' WHERE date='" + od + "'"
                        );

                        System.out.println("Query complete ," + rowsAffected + " row changed.\n");
                        printAllFromTable(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                    } else if (choice == 3) {
                        //Request user input for old erf(oerf) and erf number
                        int oerf, erf;
                        Scanner a = new Scanner(System.in);
                        System.out.print("Enter old ERF number :");
                        oerf = a.nextInt();

                        Scanner c = new Scanner(System.in);
                        System.out.print("Enter ERF number :");
                        erf = c.nextInt();

                        //SQL statement searches capstone for oerf and replaces it with erf
                        rowsAffected = statement.executeUpdate(
                                "UPDATE projects SET ERF='" + erf + "' WHERE ERF='" + oerf + "'"
                        );
                        System.out.println("Query complete ," + rowsAffected + " row changed.\n");
                        printAllFromTable(statement);
                        //

                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                    } else if (choice == 1) {
                        //Then request user input for each variable
                        String pro_name, pro_contractor, customer, architect, pro_duedate;
                        int fee_paid1, erf;
                        //This will create a List along with 5 string variables

                        // request user input for project name,due_day,due_month,fee_paid, contractor
                        // and if the project is complete
                        Scanner z0 = new Scanner(System.in);
                        System.out.print("Enter the project name :");
                        pro_name = z0.nextLine();

                        Scanner z1 = new Scanner(System.in);
                        System.out.print("Enter the duedate i.e. yyyy-mm-dd:");
                        pro_duedate = z1.nextLine();

                        Scanner z2 = new Scanner(System.in);
                        System.out.print("Enter the fee paid :");
                        fee_paid1 = z2.nextInt();

                        Scanner z3 = new Scanner(System.in);
                        System.out.print("Enter the customer :");
                        customer = z3.nextLine();

                        Scanner z4 = new Scanner(System.in);
                        System.out.print("Enter the contractor :");
                        pro_contractor = z4.nextLine();

                        Scanner z5 = new Scanner(System.in);
                        System.out.print("Enter the Architect :");
                        architect = z5.nextLine();

                        Scanner z6 = new Scanner(System.in);
                        System.out.print("Enter the erf number :");
                        erf = z6.nextInt();

                        //This allows the user to finalise a project while inputting all its details
                        rowsAffected = statement.executeUpdate(
                                "INSERT INTO projects VALUES('" + erf + "','" + pro_name + "','"
                                        + pro_contractor + "','" + architect + "','" + customer + "','"
                                        + fee_paid1 + "','" + pro_duedate + "')"
                        );
                        //
                        System.out.println("Query complete ," + rowsAffected + " rows added.\n");
                        printAllFromTable(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");
                        k++;
                    } else if (choice == 5) {
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");
                        //display the tables from the database
                        results = statement.executeQuery(
                                "SELECT ERF FROM projects WHERE ERF>0"
                        );
                        System.out.println("Table of projects");
                        printAllFromTable(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                        results = statement.executeQuery(
                                "SELECT completion_date FROM finalised WHERE completion_date>'0000-00-00'"
                        );
                        System.out.println("Table of Finalised projects");
                        printAllFromTable1(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                        results = statement.executeQuery(
                                "SELECT ERF FROM incomplete WHERE ERF>0"
                        );
                        System.out.println("Table of Incomplete projects");
                        printAllFromTable2(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                        results = statement.executeQuery(
                                "SELECT ERF FROM overdue WHERE ERF>0"
                        );
                        System.out.println("Table of Overdue projects");
                        printAllFromTable3(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");


                    } else if (choice == 6) {
                        //Here the user finalizes the chosen project
                        //Request user input for erf number
                        //Then display the data in the database
                        int erf;
                        String name, date;
                        Scanner a = new Scanner(System.in);
                        System.out.print("Enter ERF number :");
                        erf = a.nextInt();

                        results = statement.executeQuery(
                                "SELECT ERF FROM projects WHERE ERF='" + erf + "'"
                        );

                        printAllFromTable(statement);
                        //request user input for project name and date of completion
                        Scanner r = new Scanner(System.in);
                        System.out.print("Enter project name :");
                        name = r.nextLine();
                        System.out.print("Enter the completion date :");
                        date = r.nextLine();

                        //Insert the data into the finalised table database
                        //display the finalised table
                        rowsAffected = statement.executeUpdate(
                                "INSERT INTO finalised VALUES('" + name + "','" + date + "','finalised')"
                        );
                        System.out.println("Query complete ," + rowsAffected + " rows added.\n");
                        printAllFromTable1(statement);

                        //Using the erf delete thr row with matching erf from the projects table
                        //display table
                        rowsAffected = statement.executeUpdate(
                                "DELETE FROM projects WHERE ERF='" + erf + "'"
                        );
                        System.out.println("Query complete ," + rowsAffected + " rows removed.\n");
                        printAllFromTable(statement);

                        System.out.print("\n---- --- ---------------------------- ---- -----\n");
                        //Request user input to determine whether to generate invoice
                        System.out.print("\nDid customer pay full amount:");
                        Scanner scanne = new Scanner(System.in);
                        String choise;
                        choise = scanne.next();


                        //The if statement will generate an invoice if the client has't paid the total fee
                        if ((Objects.equals(choise, "no") || Objects.equals(choise, "No"))) {
                            int total, remain, paid;
                            //Request user input for total, remain and paid fee
                            System.out.print("Enter the total fee of the project");
                            Scanner scanner = new Scanner(System.in);
                            total = scanner.nextInt();

                            System.out.print("Enter the fee paid of the project");
                            Scanner scaner = new Scanner(System.in);
                            paid = scaner.nextInt();

                            //Request user input for Cdetails and customer
                            String Cdetails, cust;

                            System.out.print("Enter the customer name");
                            cust = scaner.next();
                            System.out.print("Enter the customer contact details");
                            Cdetails = scanner.next();

                            //calculate the remaining fee
                            remain = total - paid;
                            //Print the invoice
                            System.out.print("\n****INVOICE****\n");
                            System.out.print("Customer : " + cust +
                                    "\nContact details :" + Cdetails +
                                    "\nRemaining fee: R" + remain);
                            System.out.print("\n---- --- ---------------------------- ---- -----\n");

                        } else {
                            System.out.print("Customer has settled the account");
                            System.out.print("\n---- --- ---------------------------- ---- -----\n");

                        }
                    } else if (choice == 7) {
                        //This adds overdue data to the overdue/incomplete table
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                        System.out.print("Incomplete Table");
                        rowsAffected = statement.executeUpdate(
                                "INSERT INTO incomplete SELECT * FROM projects WHERE date>'" + Tdate + "'"
                        );
                        System.out.println("Query complete ," + rowsAffected + " rows added.\n");
                        printAllFromTable2(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                        System.out.print("Overdue Table");
                        rowsAffected = statement.executeUpdate(
                                "INSERT INTO overdue SELECT * FROM projects WHERE date<'" + Tdate + "'"
                        );
                        System.out.println("Query complete ," + rowsAffected + " rows added.\n");
                        printAllFromTable3(statement);
                        System.out.print("\n---- --- ---------------------------- ---- -----\n");

                    } else {
                        break;
                    }
                    //Creates a file for the data in poised
                    //Then writes the class data in the file

                }
                results.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    static int find(String[] arr, String old, String neew) {
        //This code will use the for loop to replace the old element with the new element from list arr
        //Its similar to the stackoverflow code however mine returns and x value
        //https://stackoverflow.com/questions/3250405/replace-in-array
        int x = 0;

        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], old)) {
                arr[i] = neew;
            }
        }
        return x;
    }

    public static void printAllFromTable(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery("SELECT * from projects");
        while (results.next()) {
            System.out.println(
                    results.getInt("ERF") + " | "
                            + results.getString("name") + " | "
                            + results.getString("contractor") + " |  "
                            + results.getString("architect") + " | "
                            + results.getString("customer") + " | "
                            + results.getInt("fee") + " | "
                            + results.getString("date")
            );
        }
    }

    public static void printAllFromTable1(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery("SELECT * from finalised");
        while (results.next()) {
            System.out.println(
                    results.getString("project_name") + " | "
                            + results.getString("completion_date") + " |  "
                            + results.getString("final")
            );
        }
    }

    public static void printAllFromTable2(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery("SELECT * from incomplete");
        while (results.next()) {
            System.out.println(
                    results.getInt("ERF") + " | "
                            + results.getString("name") + " | "
                            + results.getString("contractor") + " |  "
                            + results.getString("architect") + " | "
                            + results.getString("customer") + " | "
                            + results.getInt("fee") + " | "
                            + results.getString("date")
            );
        }
    }

    public static void printAllFromTable3(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery("SELECT * from overdue");
        while (results.next()) {
            System.out.println(
                    results.getInt("ERF") + " | "
                            + results.getString("name") + " | "
                            + results.getString("contractor") + " |  "
                            + results.getString("architect") + " | "
                            + results.getString("customer") + " | "
                            + results.getInt("fee") + " | "
                            + results.getString("date")
            );
        }
    }

}

class connector {
    static Connection con = null;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poised",
                    "root",
                    "Sql2022@Sm"
            );
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}


