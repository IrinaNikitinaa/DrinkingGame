import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();
        char again = 'y'; //ADD
        Scanner scanner = new Scanner(System.in);

        while (again == 'y'){  // ADD
            System.out.println("What do You want to do?");
            System.out.println("p - play");
            System.out.println("r - read");

            char action = scanner.next().charAt(0);

            if (action == 'r') {
                try {
                    database.readData();
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (action == 'p') {

                try {
                    //Making an array
                    int min = 3;
                    int max = 9;
                    int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
                    System.out.println("Random value: " + random_int);

                    ArrayList<Integer> listOfRights2 = new ArrayList<Integer>();
                    listOfRights2 = makeAnArrayList(random_int);
                    //System.out.println(listOfRights2);

                    //Get a name of the player and add in class file
                    scanner = new Scanner(System.in);
                    ArrayList<Player> playerArrayList = new ArrayList<Player>();
                    for (int i = 1; i <= 2; i++) {
                        System.out.println("Enter player " + i + " name");
                        String name = scanner.nextLine();
                        playerArrayList.add(new Player(name, i));
                    }

                    //Get a number of the player and check who drinks
                    int currentPlayer = 0;
                    for (int i = 0; i <= listOfRights2.size(); i++) {

                        System.out.println(playerArrayList.get(currentPlayer).getName() + " enter the number:");
                        int number = scanner.nextInt();

                        if (number != listOfRights2.get(i)) {
                            playerArrayList.get(currentPlayer).add();
                            System.out.println(playerArrayList.get(currentPlayer).getName() + " drinks");
                            System.out.println("Right number suppose to be: " + listOfRights2.get(i));
                        }
                        if (playerArrayList.get(currentPlayer).getWrong() == 5) {

                            System.out.println(playerArrayList.get(currentPlayer).getName() + " drinked " + playerArrayList.get(currentPlayer).getWrong() + " times");
                            System.out.println(playerArrayList.get(currentPlayer).getName() + " is drunk");
                            if (currentPlayer == 0) {
                                System.out.println(playerArrayList.get(1).getName() + " is winner!");
                                database.insertData(playerArrayList.get(0).getName(),playerArrayList.get(1).getName(),playerArrayList.get(0).getWrong(),playerArrayList.get(1).getWrong());
                            } else {
                                System.out.println(playerArrayList.get(0).getName() + " is winner!");
                                database.insertData(playerArrayList.get(0).getName(),playerArrayList.get(1).getName(),playerArrayList.get(0).getWrong(),playerArrayList.get(1).getWrong());
                            }
                            break;
                        }
                        if (currentPlayer == 0) {
                            currentPlayer = 1;
                        } else {
                            currentPlayer = 0;
                        }
                        //Insert results in database
                        //database.insertData(playerArrayList.get(currentPlayer=0).getName(), playerArrayList.get(currentPlayer=1).getName(), playerArrayList.get(currentPlayer=0).getWrong(), playerArrayList.get(currentPlayer=1).getWrong());
                    }

                } catch (Exception e) {
                    System.out.println("Something went wrong" + e);
                }
            }
            System.out.println("Do you want to do something more? y/n"); //ADD
            again = scanner.next().charAt(0);  //ADD
        }
    }

    //Method for making a list based of random number as an exception
    public static ArrayList<Integer> makeAnArrayList ( int random){
        ArrayList<Integer> listOfRights = new ArrayList();
        for (int i = 1; i <= 500; i++) {
            if (!ifContains(i, random) && i % random != 0) {
                listOfRights.add(i);
            }
        }
        return listOfRights;
    }

    //Method for checking if the number contains the random number
    public static boolean ifContains ( int large, int small){
        String one = String.valueOf(large);
        String two = String.valueOf(small);
        if (one.contains(two)) {
            return true;
        } else {
            return false;
        }
    }
}