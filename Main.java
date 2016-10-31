import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to Card Games.");
        System.out.println("Please select your game");
        System.out.println("(1)(B)lackJack");
        System.out.println("(Q)uit");
        Boolean running = true;

        while(running){
            String input = reader.nextLine();
            if(input.length() == 0){
                
            }
            else if(input.charAt(0) == 'q' || input.charAt(0) == 'Q'){
                System.out.println("Thank you for playing!");
                break;
            } else if(input.charAt(0) == '1' || 
                      input.charAt(0) == 'b' || input.charAt(0) == 'B'){
                          BlackJack blackjack = new BlackJack();
                      }
        }
        //Deck test = new Deck("Standard");
    }
}