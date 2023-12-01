package controller;

import com.sun.tools.javac.Main;
import view.MainView;
import java.util.*;

public class LMSController {
    private static ModelController modelController = new ModelController();
    private static final MainView mainView = new MainView();

    /**
     * To collect user input
     * @return user input
     */
    public static String inputListener(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        while(true) {
            MainView.welcomePage();
            String input = inputListener();
            if (input.equals("U")){
                mainView.userLogin();
                while (true) {
                    System.out.println("Please enter userID:");
                    String u = inputListener();
                    if (!isInteger(u)) {
                        System.out.println("Invalid input, please enter again");
                        continue;
                    }
                    System.out.println("Please enter password: ");
                    String p = inputListener();
                    if (!isInteger(p)) {
                        System.out.println("Invalid input, please enter again");
                        continue;
                    }
                    modelController.setUsername(u);
                    modelController.setPassword(p);
                    break;
                }
                while (true){
                    MainView.mainPage();
                    String mainOption = inputListener();
                    if (mainOption.equals("V")){
                        //View All Items
                        //retrieves information from database
                        System.out.println("Prints catalogue");
                        MainView.lineBreak();
                        MainView.nextCommand();
                        String next = inputListener();
                    }
                    else if (mainOption.equals("I")) {
                        //Search if item exists - keyword of item(s)
                        System.out.println("What item you want to search :");
                        String searchOption = inputListener();
                        //search by id or search by name
                        //search if searchOption is in database
                        try{ //sample try, replace with database later
                            if(Objects.equals(searchOption, "ploy")){
                                MainView.empty();
                            }
                            else{
                                MainView.lineBreak();
                                MainView.heading();
                                //for()
                                System.out.println(searchOption);
                            }
                        }
                        catch(Exception e){
                            //print exception
                            e.printStackTrace();
                        }
                        System.out.println(searchOption);
                        MainView.nextCommand();
                        String next = inputListener();
                    }
                    else if (mainOption.equals("F")) {
                        //Select * from Table, where category = '' and price > ''
                        //Filter Items
                        System.out.println("What do want to filter by?");
                        MainView.filterList();
                        String searchOption = inputListener();
                        //complex filter + no results found
                        if (searchOption.equals("1")) {
                            //Price Range Input + must be an integer
                            while (true) {
                                System.out.println("What is the maximum price: ");
                                String maxPrice = inputListener();
                                if (!isInteger(maxPrice)) {
                                    MainView.errorPage();
                                    continue;
                                }
                                System.out.println("What is the minimum price: ");
                                String minPrice = inputListener();
                                if (!isInteger(minPrice) || (Integer.parseInt(minPrice) - Integer.parseInt(maxPrice) > 0)) {
                                    MainView.errorPage();
                                    continue;
                                }
                                //puts this into a WHERE formula + Search database + output results
                                if (Objects.equals(searchOption, "88")) { //if none is found (temp)
                                    MainView.empty();
                                } else {
                                    MainView.heading();
                                    System.out.println("Items between " + minPrice + " and " + maxPrice);
                                }
                                break;
                            }
                            MainView.nextCommand();
                            String next = inputListener();
                        } else if (searchOption.equals("2")) {
                            System.out.println("Here is a list of Category, input which Category you would like to see: ");
                            //database prints all Categories
                            String inputCategory = inputListener();
                            if (Objects.equals(inputCategory, "88")) {//if not valid Category
                                MainView.empty();
                            } else {
                                //DATABASE takes inputCategory and generates it out
                                MainView.heading();
                                System.out.println("All items in " + inputCategory + " Category");
                            }
                            MainView.nextCommand();
                            String next = inputListener();
                        } else if (searchOption.equals("3")) {
                            while (true) {
                                System.out.println("Type a number between 0 and 5, 0 being the lowest rating and 5 being the highest");
                                int inputRating = Integer.valueOf(inputListener());
                                //make sure that it is a number between 0 and 5
                                if (inputRating < 0 || inputRating > 5) {
                                    MainView.errorPage();
                                    continue;
                                }
                                //takes inputRating and find all with the Rating for given number
                                if (inputRating == 3) { //temp for no results
                                    MainView.empty();
                                } else {
                                    MainView.heading();
                                    System.out.println("All items in "+ inputRating + " rating");
                                }
                                break;
                            }
                            MainView.nextCommand();
                            String next = inputListener();
                        } else if (searchOption.equals("4")) {
                            System.out.println("Here is a list of brands. Input which Category you would like to see: ");
                            String inputBrand = inputListener();
                            if (Objects.equals(inputBrand, "88")) {//if not valid Category
                                MainView.empty();
                            } else {
                                MainView.heading();
                                System.out.println("All items in " + inputBrand);
                            }
                            MainView.nextCommand();
                            String next = inputListener();
                        } else if (searchOption.equals("Esc")) {
                            MainView.nextCommand();
                            String next = inputListener();
                        } else {
                            MainView.errorPage();
                        }
                    }
                    else if(mainOption.equals("A")){
                        while(true) {
                            System.out.println("Enter ID of item: (Enter [Esc] to return to table of contents)");
                            String addItem = inputListener();
                            if(addItem.equals("Esc")) break; //return to table of content
                            if(!isInteger(addItem)){
                                System.out.println("Item ID should be an integer.");
                                continue;
                            }
                            //System.out.print()
                            //checks if item exists
                            //if no then
                        }
                    }
                }
            }
        }
    }
}