import java.util.Scanner;

public class Menu {
    public void start() {

        Validator validator = new Validator();

        String cardNumber = getCardNumber();

        Card card = createCard(cardNumber, validator);

        if (!isLengthValid(card, validator)) {
            return;
        }

        if (!getCardType(card)) {
            return;
        }

        isLuhnValid(card, validator);
    }

    private String getCardNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер карты: ");
        String cardNumber = scanner.nextLine();
        scanner.close();

        return cardNumber;
    }

    private Card createCard(String cardNumber, Validator validator) {

        return new Card(cardNumber, validator.getTypeOfCard(cardNumber));
    }

    private boolean isLengthValid(Card card, Validator validator) {

        if (!validator.isLengthValid(card.number)) {
            System.out.println("Неверное количество цифр!");
            return false;
        }

        return true;
    }

    private boolean getCardType(Card card) {
        if (card.type == Type.INVALID) {
            System.out.println("Неверный тип карты");
            return false;
        } else {
            System.out.println(card.type);
            return true;
        }
    }

    private boolean isLuhnValid(Card card, Validator validator) {


        if (validator.isLuhnValid(card.number)) {
            System.out.println("Карта валидна");
            return true;
        }
        else {
            System.out.println("Карта невалидна");
            return false;
        }
    }
}