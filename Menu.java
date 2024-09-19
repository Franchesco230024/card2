import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in); // Открываем Scanner один раз

    public void start() {
        Validator validator = new Validator();
        String cardNumber = getCardNumber();

        Card card = createCard(cardNumber, validator);

        if (validateCard(card, validator)) {
            System.out.println("Карта валидна.");
        } else {
            System.out.println("Карта невалидна.");
        }
    }

    private String getCardNumber() {
        System.out.println("Введите номер карты: ");
        return scanner.nextLine();
    }

    private Card createCard(String cardNumber, Validator validator) {
        return new Card(cardNumber, validator.getTypeOfCard(cardNumber));
    }

    private boolean validateCard(Card card, Validator validator) {
        // Объединение всех проверок в одну функцию
        if (!validator.isLengthValid(card.getNumber())) {
            System.out.println("Неверное количество цифр!");
            return false;
        }

        if (card.getType() == Type.INVALID) {
            System.out.println("Неверный тип карты.");
            return false;
        } else {
            System.out.println("Тип карты: " + card.getType());
        }

        if (!validator.isLuhnValid(card.getNumber())) {
            System.out.println("Карта не прошла проверку по алгоритму Луна.");
            return false;
        }

        return true;
    }
}
