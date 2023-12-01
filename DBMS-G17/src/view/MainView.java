package view;

public class MainView {

    public static void welcomePage(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("        COMP2411 Group 17 Online Shopping System (OSS)");
        System.out.println();
        System.out.println("[U] User Login");
        System.out.println("[A] Admin Login");
        System.out.println("[R] Register");
        System.out.println("[Esc] Exit");
        System.out.println("Please select the above options X in [X]: ");
    }

    public void userLogin(){
        System.out.println("------------------------Welcome User---------------------------");
        //System.out.println("Please insert username: ");
    }
    public static void mainPage(){
        //will be printing statements first, later will try to connect to database
        System.out.println("--------------------Table of Contents---------------------------");
        System.out.println("[V] View All Items");
        System.out.println("[I] Search Item"); //it exists or not
        System.out.println("[F] Filter Items"); //user gives criteria, items sorted based on criteria and criteria is shown
        System.out.println("------------Cart------------");
        System.out.println("[A] Add to Cart");
        System.out.println("[R] Remove from Cart");
        System.out.println("[S] View Shopping Cart");
        System.out.println("----------------------------");
        System.out.println("[O] Check Out");
        System.out.println("[P] View Purchase History");
        System.out.println("[W] Write a Review");
        System.out.println("[U] View User Preferences"); //includes shipping address, making payment
        System.out.println("[Esc] Exit");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Please select the above options X in [X]: ");
    }

    public static void lineBreak(){
        System.out.println("----------------------------------------------------------------");
    }
    public static void nextCommand(){
        System.out.println("Press Enter to continue: ");
    }
    public static void empty(){
        System.out.println("No items exist.");
    }
    public static void heading(){
        System.out.println("Results: ");
    }
    public static void filterList(){
        System.out.println("[1] Price Range");
        System.out.println("[2] Category");
        System.out.println("[3] Review Rating");
        System.out.println("[4] Brand");
        System.out.println("[Esc] Return to Table of Contents");
        System.out.println("Please select the above options X in [X]: ");
    }
    public static void errorPage(){
        System.out.println("Invalid input, please try again.");
    }
}