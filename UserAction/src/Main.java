package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAction[] userActions = new UserAction[]{
                new CircleSquare(scanner),
                new RectangleSquare(scanner),
                new TriangleSquare(scanner)
        };

        boolean exit = false;

        while (!exit) {
            for (int i = 0; i < userActions.length; i++) {
                System.out.println(i + 1 + " " + userActions[i].getName());
            }

            System.out.println("Выберите пункт меню или введите 0 для выхода:");
            int choice = scanner.nextInt();

            if (choice == 0) {
                exit = true;
                continue;
            }

            if (choice > 0 && choice <= userActions.length) {
                userActions[choice - 1].doAction();
            } else {
                System.out.println("Вы выбрали неверный пункт меню");
            }
        }
    }
}

abstract class UserAction {

    protected abstract void doAction();

    protected abstract String getName();
}

class CircleSquare extends UserAction {

    private final Scanner scanner;

    public CircleSquare(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    protected void doAction() {
        System.out.println("Введите радиус круга:");
        double radius = scanner.nextDouble();
        double square = Math.PI * Math.pow(radius, 2);
        System.out.println("Площадь круга равна: " + square);
    }

    @Override
    protected String getName() {
        return "Посчитать площадь круга";
    }
}

class RectangleSquare extends UserAction {

    private final Scanner scanner;

    public RectangleSquare(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    protected void doAction() {
        System.out.println("Введите длину прямоугольника:");
        int length = scanner.nextInt();
        System.out.println("Введите ширину прямоугольника:");
        int width = scanner.nextInt();
        int square = length * width;
        System.out.println("Площадь прямоугольника равна: " + square);
    }

    @Override
    protected String getName() {
        return "Посчитать площадь прямоугольника";
    }
}

class TriangleSquare extends UserAction {

    private final Scanner scanner;

    public TriangleSquare(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    protected void doAction() {
        System.out.println("Введите длину основания треугольника:");
        double base = scanner.nextDouble();
        System.out.println("Введите высоту треугольника:");
        double height = scanner.nextDouble();
        double square = 0.5 * base * height;
        System.out.println("Площадь треугольника равна: " + square);
    }

    @Override
    protected String getName() {
        return "Посчитать площадь треугольника";
    }
}