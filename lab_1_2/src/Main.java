import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        createUsersList(users);

        while(true) {
            System.out.print("\nChose act from menu:\n\t1. sort users by last name;\n\t2. sort users by age;\n\t3. check users are older than 7;\n\t4. get average age of users;\n\t5. count amount of users in every country;\n\t6. Exit\n");
            Scanner in = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1:
                    sortByLastName(users);
                    break;
                case 2:
                    sortByAge(users);
                    break;
                case 3:
                    checkAge(users);
                    break;
                case 4:
                    getAverageAge(users);
                    break;
                case 5:
                    countryCount(users);
                    break;
                case 6:
                    return;
                default:
                    System.out.print("Please, input option from menu!\n");
            }
        }
    }

    public static void createUsersList(List<User> users) {
        int amount;
        do {
            System.out.print("Input amount of users: ");
            Scanner in = new Scanner(System.in);
            amount = in.nextInt();
        } while(amount <= 0);

        String[] firstNames = new String[]{"Alice", "Don", "Robin", "William", "Max", "Maria", "Anna", "John", "Jack", "Andrea"};
        String[] lastNames = new String[]{"Don", "Smith", "Brett", "Rodrigos", "Lee", "Felk", "Ditter", "Klark", "Hoffman"};
        String[] countries = new String[]{"Canada", "Germany", "Russia", "France", "Sweden", "Italy", "Spain", "UK", "Iceland", "Georgia"};

        for(int i = 0; i < amount; ++i) {
            Random rand = new Random();
            String fName = firstNames[rand.nextInt(9)];
            String lName = lastNames[rand.nextInt(9)];
            String country = countries[rand.nextInt(9)];
            users.add(new User(fName, lName, rand.nextInt(10000) + 999, rand.nextInt(100) + 1, country));
        }

    }

    public static void sortByLastName(List<User> users) {
        users.stream().sorted(Comparator.comparing(User::getLastName)).forEach((user) -> user.print());
    }

    public static void sortByAge(List<User> users) {
        users.stream().sorted(Comparator.comparing(User::getAge)).forEach((user) -> user.print());
    }

    public static void checkAge(List<User> users) {
        if (users.stream().allMatch((user) -> user.getAge() > 7)) {
            System.out.print("All users are older than 7");
        } else {
            System.out.print("Some users are younger than seven");
        }

    }

    public static void getAverageAge(List<User> users) {
        System.out.printf("The average age of users is: %.1f",
                 users.stream().mapToInt(User::getAge)
                        .average().orElse(0.0));
    }

    public static void countryCount(List<User> users) {
        List<Statistic> stats = new ArrayList();

        for(User user : users) {
            if (stats.stream().noneMatch((stat) -> stat.getCountry().equals(user.getCountry()))) {
                long amount = users.stream().filter((userArr) -> userArr.getCountry().equals(user.getCountry())).count();
                stats.add(new Statistic(user.getCountry(), amount));
            }
        }

        stats.forEach((stat) -> stat.print());
    }
}
