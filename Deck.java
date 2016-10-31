import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
//This class is where I create decks.

public class Deck{
    
    private Card[] standardDeck = new Card[52];
    
    public Deck(){
        System.out.println("Empty Deck created");
    }
    
    //here i'll be making decks depending on the game.
    //For example, some games will or will not need jokers, I will
    //account for that later.
    public Deck(String format){
        
        if(format.toLowerCase().equals("standard")){
            System.out.println("Creating a deck....");
            this.standardDeck = standardDeckMaker();
            System.out.println("Deck created and shuffled.");
        }
    }
    
    public Card[] getDeck(){
        return this.standardDeck;
    }
    
    //this method creates a standard 52 card deck.
    public Card[] standardDeckMaker(){
        Card[] temp = new Card[52];
        //Calling the Spade card creator.
        Card[] spades = new Card[13];
        spades = createSpadeSuite();
        //Calling the Heart card creator.
        Card[] hearts = new Card[13];
        hearts = createHeartSuite();
        //Calling the Clover card creator.
        Card[] clovers = new Card[13];
        clovers = createCloverSuite();
        //Calling the Diamond card creator.
        Card[] diamonds = new Card[13];
        diamonds = createDiamondSuite();
        
        for(int i = 0; i < temp.length ; i++){
            if(i < 13){
                temp[i] = spades[i];
            }
            else if(i < 26){
                temp[i] = hearts[i%13];
            }else if(i < 39){
                temp[i] = clovers[i%13];
            }else if(i < 52){
                temp[i] = diamonds[i%13];
            }
        }
        
        //Shuffling the deck
        Card[] realDeck = new Card[52];
        realDeck = shuffleDeck(temp);
        return realDeck;
    }
    
    public Card[] createSpadeSuite(){
        Card[] tempSpades = new Card[13];
        for(int spadeCount = 0; spadeCount < tempSpades.length ; spadeCount++){
            if(spadeCount == 0){
                Card Spade = new Card("Ace", "Spade");
                tempSpades[spadeCount] = Spade;                
            }
            if(spadeCount > 0 && spadeCount < 10){
                //int spadeCountBoost = spadeCount-1;
                Card Spade = new Card(Integer.toString(spadeCount+1) , "Spade");
                tempSpades[spadeCount] = Spade;
            }
            if(spadeCount == 10){
                Card Spade = new Card("Jack", "Spade");
                tempSpades[spadeCount] = Spade;
            }
            if(spadeCount == 11){
                Card Spade = new Card("Queen", "Spade");
                tempSpades[spadeCount] = Spade;
            }  
            if(spadeCount == 12){
                Card Spade = new Card("King", "Spade");
                tempSpades[spadeCount] = Spade;  
            }
                       
            
        }
        
        
        return tempSpades;  
    }
    
    public Card[] createHeartSuite(){
        Card[] tempHearts = new Card[13];
        for(int heartCount = 0; heartCount < tempHearts.length ; heartCount++){
            if(heartCount == 0){
                Card Heart = new Card("Ace", "Heart");
                tempHearts[heartCount] = Heart;                
            }
            if(heartCount > 0 && heartCount < 10){
                Card Heart = new Card(Integer.toString(heartCount+1) , "Heart");
                tempHearts[heartCount] = Heart;
            }
            if(heartCount == 10){
                Card Heart = new Card("Jack", "Heart");
                tempHearts[heartCount] = Heart;
            }
            if(heartCount == 11){
                Card Heart = new Card("Queen", "Heart");
                tempHearts[heartCount] = Heart;
            }  
            if(heartCount == 12){
                Card Heart = new Card("King", "Heart");
                tempHearts[heartCount] = Heart;
            }

        }
      return tempHearts;  
    }
    
    public Card[] createCloverSuite(){
        Card[] tempClovers = new Card[13];
        for(int cloverCount = 0; cloverCount < tempClovers.length ; cloverCount++){
            if(cloverCount == 0){
                Card Clover = new Card("Ace", "Clover");
                tempClovers[cloverCount] = Clover;                
            }
            if(cloverCount > 0 && cloverCount < 10){
                Card Clover = new Card(Integer.toString(cloverCount+1) , "Clover");
                tempClovers[cloverCount] = Clover;
            }
            if(cloverCount == 10){
                Card Clover = new Card("Jack", "Clover");
                tempClovers[cloverCount] = Clover;
            }
            if(cloverCount == 11){
                Card Clover = new Card("Queen", "Clover");
                tempClovers[cloverCount] = Clover;
            }  
            if(cloverCount == 12){
                Card Clover = new Card("King", "Clover");
                tempClovers[cloverCount] = Clover;
            }
        }
 
      return tempClovers;  
    }

    public Card[] createDiamondSuite(){
        Card[] tempDiamonds = new Card[13];
        for(int diamondCount = 0; diamondCount < tempDiamonds.length  ; diamondCount++){
            if(diamondCount == 0){
                Card Diamond = new Card("Ace", "Diamond");
                tempDiamonds[diamondCount] = Diamond;                
            }
            if(diamondCount > 0 && diamondCount < 10){
                Card Diamond = new Card(Integer.toString(diamondCount+1) , "Diamond");
                tempDiamonds[diamondCount] = Diamond;
            }
            if(diamondCount == 10){
                Card Diamond = new Card("Jack", "Diamond");
                tempDiamonds[diamondCount] = Diamond;
            }
            if(diamondCount == 11){
                Card Diamond = new Card("Queen", "Diamond");
                tempDiamonds[diamondCount] = Diamond;
            }  
            if(diamondCount == 12){
                Card Clover = new Card("King", "Diamond");
                tempDiamonds[diamondCount] = Clover;
            }
        }

      return tempDiamonds;  
    }
   
   public Card[] shuffleDeck(Card[] deck){
    // Implementing Fisher–Yates shuffle
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = deck.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      Card a = deck[index];
      deck[index] = deck[i];
      deck[i] = a;
    }

    return deck;
   }   
    
}