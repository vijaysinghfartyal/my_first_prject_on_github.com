package beans;

public class Payment {
    private int id;
    private String cardNumber;
    private String cardHolderName;
    private double amount;
    
    // Constructor
    public Payment(int id, String cardNumber, String cardHolderName, double amount) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.amount = amount;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    
    public String getCardHolderName() { return cardHolderName; }
    public void setCardHolderName(String cardHolderName) { this.cardHolderName = cardHolderName; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}