public class Card {
    private String number;
    private Type type;

    public Card(String number, Type type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public Type getType() {
        return type;
    }
}

