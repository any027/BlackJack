//The Base Card Class
public class Card {
    
    //private string variables for name and suites
    private String rank;
    private String suite;

    public Card() {
        this.rank = "UNDEFINED";
        this.suite = "UNDEFINED";
    }
    
    public Card(String Rank, String Suite){
        this.rank = Rank;
        this.suite = Suite;
    }


    // accessors and mutators.
    // There shouldn't ever be a need to change the name nor suite, so I 
    // omit those mutators.
    public String getRank(){
        return this.rank;
    }
    
    public String getSuite() {
        return this.suite;
    }
    
    public Card getCard() {
        return this;
    }
    
    public void getCardInfo(){
        System.out.println("Card Rank is " + this.rank);
        System.out.println("Card Suite is " + this.suite);
    }
}
