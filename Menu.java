import java.util.Scanner;

public class Menu {
    public void start() {
        Validator validator = new Validator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер карты: ");
        String cardNumber = scanner.nextLine();
        scanner.close();

        if (!validator.isLengthValid(cardNumber)) {
            System.out.println("Неверное количество цифр!");
            return;
        }

        Card card = new Card(cardNumber, validator.getTypeOfCard(cardNumber));

        if (card.type == Type.INVALID) {
            System.out.println("Неверный тип карты");
            return;
        } else {
            System.out.println(card.type);
        }

        if (validator.isLuhnValid(card.number)) {
            System.out.println("Карта валидна");
        } else {
            System.out.println("Карта невалидна");
            return;
        }
    }
}