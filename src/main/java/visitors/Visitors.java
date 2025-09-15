package visitors;

import app.cotroller.MemberController;
import app.cotroller.TrainerController;
import app.domain.Member;
import app.domain.Trainer;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Visitors {

    private static final MemberController memberController = new MemberController();
    private static final TrainerController trainerController = new TrainerController();

    public static void main(String[] args) {
        System.out.println("=== Fitnessclub ===");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1) Добавить участника (Member)");
            System.out.println("2) Показать всех участников");
            System.out.println("3) Обновить имя участника");
            System.out.println("4) Удалить участника");
            System.out.println("5) Добавить тренера (Trainer)");
            System.out.println("6) Показать всех тренеров");
            System.out.println("7) Обновить имя тренера");
            System.out.println("8) Удалить тренера");
            System.out.println("0) Выход");
            System.out.print("Выбор: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1": {
                        System.out.print("Имя нового участника: ");
                        String name = sc.nextLine();
                        Optional<Member> m = memberController.save(name);
                        System.out.println("Создан: " + m);
                        break;
                    }
                    case "2": {
                        List<Member> list = memberController.getAll();
                        System.out.println("Всего участников: " + list.size());
                        list.forEach(System.out::println);
                        break;
                    }
                    case "3": {
                        System.out.print("ID участника: ");
                        Long id = Long.parseLong(sc.nextLine());
                        System.out.print("Новое имя: ");
                        String newName = sc.nextLine();
                        Optional<Member> m = memberController.update(id, newName);
                        System.out.println("Обновлён: " + m);
                        break;
                    }
                    case "4": {
                        System.out.print("ID участника: ");
                        Long id = Long.parseLong(sc.nextLine());
                        memberController.delete(id);
                        System.out.println("Удалён участник id=" + id);
                        break;
                    }
                    case "5": {
                        System.out.print("Имя нового тренера: ");
                        String name = sc.nextLine();
                        Optional<Trainer> t = trainerController.save(name);
                        System.out.println("Создан: " + t);
                        break;
                    }
                    case "6": {
                        List<Trainer> list = trainerController.getAll();
                        System.out.println("Всего тренеров: " + list.size());
                        list.forEach(System.out::println);
                        break;
                    }
                    case "7": {
                        System.out.print("ID тренера: ");
                        Long id = Long.parseLong(sc.nextLine());
                        System.out.print("Новое имя: ");
                        String newName = sc.nextLine();
                        Optional<Trainer> t = trainerController.update(id, newName);
                        System.out.println("Обновлён: " + t);
                        break;
                    }
                    case "8": {
                        System.out.print("ID тренера: ");
                        Long id = Long.parseLong(sc.nextLine());
                        trainerController.delete(id);
                        System.out.println("Удалён тренер id=" + id);
                        break;
                    }
                    case "0":
                        System.out.println("Пока!");
                        return;
                    default:
                        System.out.println("Неизвестный пункт меню");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}






