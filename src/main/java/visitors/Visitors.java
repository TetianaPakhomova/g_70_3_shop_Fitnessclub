package visitors;

import app.cotroller.MemberController;
import app.cotroller.TrainerController;


import java.util.Scanner;

public class Visitors {
    private static MemberController memberController;
    private static TrainerController trainerController;
    private static Scanner scanner;

    public static void main(String[] args) {

        try {
            // Создаём объекты контроллеров для взаимодействия с приложением
            memberController = new MemberController();
            trainerController = new TrainerController();
            scanner = new Scanner(System.in);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        while (true) {
            System.out.println("Выберите желаемую операцию:");
            System.out.println("1 - операции с пользователем");
            System.out.println("2 - операции с тренером");
            System.out.println("0 - выход");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    memberOperations();
                    break;
                case "2":
                    trainerOperations();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }

    private static void trainerOperations() {

        while (true) {
            try {
                System.out.println("Выберите желаемую операцию с тренером:");
                System.out.println("1 - сохранить тренера");
                System.out.println("2 - получить всех тренеров");
                System.out.println("3 - получить тренера по идентификатору");
                System.out.println("4 - поменять тренера");
                System.out.println("5 - удалить тренера по идентификатору");
                System.out.println("6 - удалить тренера по имени");
                System.out.println("7 - восстановить тренера по идентификатору");
                System.out.println("8 - получить количество тренеров");
                System.out.println("9 - получить суммарную стоимость всех услуг");
                System.out.println("10 - получить среднюю стоимость услуг");
                System.out.println("0 - выход");

                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Введите название тренерских услуг");
                        String title = scanner.nextLine();
                        System.out.println("Введите цену услуги");
                        double price = Double.parseDouble(scanner.nextLine());
                        Long id = null;
                        String name = " ";
                        System.out.println(trainerController.save(id, name));
                        break;
                    case "2":
                        trainerController.getAll().forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("Введите идентификатор тренера");
                        id = Long.parseLong(scanner.nextLine());
                        System.out.println(trainerController.getById(id));
                        break;
                    case "4":
                        System.out.println("Введите идентификатор тренера");
                        id = Long.parseLong(scanner.nextLine());
                        System.out.println("Введите новую услугу трнера");
                        price = Double.parseDouble(scanner.nextLine());
                        trainerController.update(id, price);
                        break;
                    case "5":
                        System.out.println("Введите идентификатор тренера");
                        id = Long.parseLong(scanner.nextLine());
                        trainerController.deleteById(id);
                        break;
                    case "6":
                        System.out.println("Введите имя тренера");
                        title = scanner.nextLine();
                        trainerController.deleteByTitle(title);
                        break;
                    case "7":
                        System.out.println("Введите идентификатор тренера");
                        id = Long.parseLong(scanner.nextLine());
                        trainerController.restoreById(id);
                        break;
                    case "8":
                        System.out.println("Количество услуг - " + trainerController.getTrainersName());
                        break;
                    case "9":

                        System.out.println("Суммарная стоимость услуг - " +
                                trainerController.getTrainersTotalCost());
                        break;
                    case "10":
                        System.out.println("Средняя стоимость услуг - " +
                                trainerController.getTrainersAveragePrice());
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static <MemberCredentialsCache> void memberOperations() {
        while (true) {
            try {
                System.out.println("Выберите желаемую операцию с пользователем:");
                System.out.println("1 - сохранить пользователя");
                System.out.println("2 - получить всех пользователей");
                System.out.println("3 - получить пользователя по идентификатору");
                System.out.println("4 - изменить пользователя");
                System.out.println("5 - удалить пользователя по идентификатору");
                System.out.println("6 - удалить пользователя по имени");
                System.out.println("7 - восстановить пользователя по идентификатору");
                System.out.println("8 - получить количество пользователей");
                System.out.println("9 - получить стоимость услуг пользователя");
                System.out.println("10 - получить среднюю стоимость услуг  пользователя");
                System.out.println("11 - добавить услугу пользователя");
                System.out.println("12 - удалить услугу  пользователя");
                System.out.println("13 - очистить все услуги пользователя");
                System.out.println("0 - выход");

                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Введите имя пользователя");
                        String name = scanner.nextLine();
                        MemberCredentialsCache memberName = null;
                        System.out.println();
                        break;
                    case "2":
                        memberController.getAll().forEach(System.out::println);
                        break;
                    case "3":
                        System.out.println("Введите идентификатор");
                        Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(memberController.getById(id));
                        break;
                    case "4":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        System.out.println("Введите новое имя пользователя");
                        name = scanner.nextLine();
                        memberController.update(id, name);
                        break;
                    case "5":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        memberController.deleteById(id);
                        break;
                    case "6":
                        System.out.println("Введите имя пользователя");
                        name = scanner.nextLine();
                        memberController.deleteByName(name);
                        break;
                    case "7":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        memberController.restoreById(id);
                        break;
                    case "8":
                        System.out.println("Количество пользователей - " + memberController.getMemberNumber());
                        break;
                    case "9":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        System.out.println("Стоимость услуг пользователя - " +
                                memberController.getMembersCartTotalCost(id));
                        break;
                    case "10":
                        System.out.println("Введите идентификатор");
                        id = Long.parseLong(scanner.nextLine());
                        System.out.println("Средняя цена всех услуг - " +
                                memberController.getMemberCartAveragePrice(id));
                        break;
                    case "11":
                        System.out.println("Введите идентификатор пользователя");
                        Long customerId = Long.parseLong(scanner.nextLine());
                        System.out.println("Введите идентификатор тренера");
                        Long productId = Long.parseLong(scanner.nextLine());
                        Long trainerId = 0L;
                        memberController.addTrainerToMembersCart(customerId, trainerId);
                        break;
                    case "12":
                        System.out.println("Введите идентификатор пользователя");
                        customerId = Long.parseLong(scanner.nextLine());
                        System.out.println("Введите идентификатор тренера");
                        productId = Long.parseLong(scanner.nextLine());
                        Object memberId = null;
                        memberController.removerTrainerFromMembersCart();
                        break;
                    case "13":
                        System.out.println("Введите идентификатор пользователя");
                        id = Long.parseLong(scanner.nextLine());
                        memberController.clearMembersCart(id);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}



