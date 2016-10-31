import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class BlackJack{
    
    private Deck deck = new Deck();
    private Stack<Card> gameDeck = new Stack<Card>();
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int handValue;
    public BlackJack(){
        System.out.println("Welcome to BlackJack!");
        System.out.println("To begin playing, press any button and enter");
        System.out.println("To exit, at any point of the game please enter Q.");
        promptUser();
        //at some point, i would like to do more than one player.
        //for this project, i will assume only one player.
        //if we were to do more than one player, we would have to be able to
        //save the states of the player, so possibly an array that saves the
        //states of the player? This array would probably be an array of
        //a class called "State", which holds a players hand and such.      
    }
    
    public void promptUser(){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        Boolean running = true;
        while(running){
            if(input.length() == 0){
                gameStart();
                running = false;
            }
            else if(input.charAt(0) == 'q' || input.charAt(0) == 'Q'){
                System.out.println("Thank you for playing BlackJack!");
                //implement choices to go back to the main menu later.
                System.exit(0);
            }else{
                gameStart();
                running = false;
            }
            
        }

    }
    public void gameStart(){
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        Boolean running = true;
        //created a new deck
        deck = new Deck("standard");
        Card[] deckToStack = deck.getDeck();
        for(int i = 0; i < deckToStack.length ; i++){
            gameDeck.push(deckToStack[i]);
        }
        //game deck is a stack of cards.
        
        //draw 2 cards.
        drawCard();
        drawCard();
        
        checkHand();
        boolean choice = false;
        while(running){
            if(choice == false){
                System.out.println("Would you like to (h)it or (s)tay?");
                System.out.println("You may also press 1 or 2");
                input = reader.nextLine();
                if(input.length() == 0 ){
                    continue;
                }else if(input.charAt(0) == 'q' || input.charAt(0) == 'Q'){
                       gameOver();
                }else if(input.charAt(0) == '1' ||
                    input.charAt(0) == 'h' || input.charAt(0) == 'H'){
                       drawCard();
                       checkHand();
                       calculateHand();
                       
                       if(didBlow()){
                            choice = true;
                            gameOver();
                       }
                } else if(input.charAt(0) == '2' ||
                   input.charAt(0) == 's' || input.charAt(0) == 'S'){
                       checkHand();
                       choice = true;
                       gameOver();
                   } else {
                       System.out.println("Please put in a valid input");
                   }
            }
        }
        
    }
    
    //This method causes the gameover sequence.
    public void gameOver() {
        System.out.println("Would you like to (p)lay again? or (q)uit?");
        System.out.println("You may also press 1 or 2");
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        if(input.length() == 0){
        } else if(input.charAt(0) == '1' ||
           input.charAt(0) == 'p' || input.charAt(0) == 'P'){
               BlackJack blackjack = new BlackJack();
        } else if(input.charAt(0) == '2' ||
           input.charAt(0) == 'q' || input.charAt(0) == 'Q'){
                System.out.println("Thank you for playing BlackJack!");
                //implement choices to go back to the main menu later.
                System.exit(0);
        } else {
            System.out.println("Please put in a valid input");
        }

        
        
    }
    
    //This method draws a card and adds it to the hand
    public void drawCard() {
        
        if(gameDeck.isEmpty()){
            System.out.println("Out of Cards!");
        }else{
            Card drawnCard = gameDeck.pop();
            hand.add(drawnCard);
        }
    }
    
    //This method shows the users hand.
    public void checkHand(){
        if(hand.isEmpty()){
            System.out.println("You don't have any cards!");
        }
        for(Card card: hand){
            card.getCardInfo();
        }
    }
    
    //This method checks whether or not the hand is over 21
    public boolean didBlow() {
        if(handValue > 21){
            return true;
        }
        return false;
    }
    
    //This method calculates the value of your hand in blackjack
    public void calculateHand(){
        int value = 0;
        for(Card card : hand){
            if(card.getRank().equals("Ace")){
                value += 1;
            }else if(card.getRank().equals("Jack") ||
                     card.getRank().equals("Queen") ||
                     card.getRank().equals("King") ){
                        value += 10;
            } else {
             int value2 = Integer.parseInt(card.getRank()); 
             value += value2;
             }
        }
        handValue = value;
    }
}