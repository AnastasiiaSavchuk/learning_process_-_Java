package java_enum;

import java_enum.enums.Month;
import java_enum.enums.Season;
import java_enum.exception.WrongInputParametersException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws WrongInputParametersException {

        Scanner scanner = new Scanner(System.in);
        int stop = 1;
        while (stop != 0) {
            menuOptions();

            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("        1. Перевірити чи такий місяць існує.");
                    System.out.println("Введіть місяць для перевірки : ");
                    String month = scanner.next();
                    getMonth(month);
                    break;
                case 2:
                    System.out.println("        2. Вивести всі місяці з такою ж порою року.");
                    System.out.println("Введіть місяць для перевірки : ");
                    String monthToCheck = scanner.next();
                    getMonthWithSeason(monthToCheck);
                    break;
                case 3:
                    System.out.println("        3. Вивести всі місяці які мають таку саму кількість днів.");
                    System.out.println("Введіть кількість днів у місяці : ");
                    int days = scanner.nextInt();
                    getDaysInYear(days);
                    break;
                case 4:
                    System.out.println("        4. Вивести на екран всі місяці які мають меншу кількість днів.");
                    System.out.println("Введіть кількість днів у місяці : ");
                    int days1 = scanner.nextInt();
                    getMonthLessDays(days1);
                    break;
                case 5:
                    System.out.println("        5. Вивести на екран всі місяці які мають більшу кількість днів.");
                    System.out.println("Введіть кількість днів у місяці : ");
                    int day2 = scanner.nextInt();
                    getMonthMoreDays(day2);
                    break;
                case 6:
                    System.out.println("        6. Вивести на екран наступну пору року.");
                    System.out.println("Введіть ваш сезон : ");
                    String season = scanner.next();
                    getNextSeason(season);
                    break;
                case 7:
                    System.out.println("        7. Вивести на екран попередню пору року.");
                    System.out.println("Введіть ваш сезон : ");
                    String season1 = scanner.next();
                    getPreviousSeason(season1);
                    break;
                case 8:
                    System.out.println("        8. Вивести на екран всі місяці які мають парну кількість днів.");
                    getMonthWithEvenNumberOfDays();
                    break;
                case 9:
                    System.out.println("        9. Вивести на екран всі місяці які мають непарну кількість днів.");
                    getMonthWithNotEvenNumberOfDays();
                    break;
                case 10:
                    System.out.println("        10. Вивести на екран чи введений з консолі місяць має парну кількість днів.");
                    System.out.println("Введіть місяць для перевірки : ");
                    String month2 = scanner.next();
                    getMonthWithNumberOfDays(month2);
                    break;
                case 11:
                    System.out.println("        11. Вихід!");
                    stop = 0;
                    break;
            }
        }
    }

    //10
    private static void getMonthWithNumberOfDays(String month2) throws WrongInputParametersException {
        checkMonthExists(month2);
        Month month = Month.valueOf(month2.toUpperCase());//спочатку отримуєм поточний місяць і підтягуєм його до верхнього реєстру
        if (month.getDays() % 2 == 0) {
            System.out.println("Ваш місяць " + month2 + " має парну кількість днів.");
        } else {
            System.out.println("Ваш місяць " + month2 + " має не парну кількість днів.");
        }
    }

    private static void checkMonthExists(String month2) throws WrongInputParametersException {
        boolean isExists = false;
        for (Month month1 : Month.values()) {
            if (month1.name().equalsIgnoreCase(month2)) {
                isExists = true;
                break;
            }
        }
        if (!isExists) throw new WrongInputParametersException("Такого місяця не існує!!!");
    }


    //9
    private static void getMonthWithNotEvenNumberOfDays() {
        for (Month month : Month.values()) {
            if (month.getDays() % 2 != 0) {
                System.out.println("Місяці які мають не парну кількість днів :\n" + month.toString());
            }
        }
    }

    //8
    private static void getMonthWithEvenNumberOfDays() {
        for (Month month : Month.values()) {
            if (month.getDays() % 2 == 0) {
                System.out.println("Місяці які мають парну кількість днів :\n" + month.toString());
            }
        }
    }

    //7   !!!!!!!!!!!!
    private static void getPreviousSeason(String season1) throws WrongInputParametersException {
        checkIfSeasonExists(season1);
        System.out.println("Попередній сезон : ");
        Season currentSeason = Season.valueOf(season1.toUpperCase());//спочатку отримуєм поточний сезон і пшдтягуєм його до верхнього реєстру
        int previousOrdinal = currentSeason.ordinal();//берем порядковий номер поточного сезону
        Season previousSeason;
        if (previousOrdinal == Season.values().length - 4) {//якщо порядковий номер поточного сезону == кількості елементів енума - 4
            previousSeason = Season.values()[3];            //виводим третій елемент
        } else {
            previousSeason = Season.values()[previousOrdinal - 1];//якщо ні то попередній
        }
        System.out.println(previousSeason);
    }

    //6
    private static void getNextSeason(String season) throws WrongInputParametersException {
        checkIfSeasonExists(season);
        System.out.println("Наступний сезон : ");
        Season currentSeason = Season.valueOf(season.toUpperCase());//спочатку отримуєм поточний сезон і пшдтягуєм його до верхнього реєстру
        int nextOrdinal = currentSeason.ordinal();//берем порядковий номер поточного сезону
        Season nextSeason;
        if (nextOrdinal == Season.values().length - 1) {//якщо порядковий номер поточного сезону == кількості елементів енума - 1
            nextSeason = Season.values()[0];            //виводим перший елемент
        } else {
            nextSeason = Season.values()[nextOrdinal + 1];//якщо ні то наступний за порядком
        }
        System.out.println(nextSeason);
    }

    private static void checkIfSeasonExists(String season) throws WrongInputParametersException {
        boolean isExists = false;
        for (Season value : Season.values()) {
            if (value.name().equalsIgnoreCase(season)) {
                isExists = true;
                break;
            }
        }
        if (!isExists) throw new WrongInputParametersException("Такого сезону не існує!!!");
    }

    //5
    private static void getMonthMoreDays(int days2) throws WrongInputParametersException {
        System.out.println("Місяці з більшою кількістю днів : ");
        checkMoreDaysExist(days2);
        for (Month month : Month.values()) {
            if (month.getDays() > days2) {
                System.out.println(month.toString());
            }
        }
    }

    private static void checkMoreDaysExist(int days2) throws WrongInputParametersException {
        if (days2 < 28) {
            throw new WrongInputParametersException("Такої кількості днів в місяці немає!!!");
        } else if (days2 == 31) {
            throw new WrongInputParametersException("Місяця з більшою кількістю днів немає!!!");
        }
    }


    //4
    private static void getMonthLessDays(int days1) throws WrongInputParametersException {
        System.out.println("Місяці з меньшою кількістю днів : ");
        checkLessDaysExist(days1);
        for (Month month : Month.values()) {
            if (month.getDays() < days1) {
                System.out.println(month.toString());
            }
        }
    }

    private static void checkLessDaysExist(int days1) throws WrongInputParametersException {
        if (days1 <= 28 || days1 > 31) {
            throw new WrongInputParametersException("Такої кількості днів в місяці немає!!!");
        } else if (days1 == 29) {
            throw new WrongInputParametersException("Місяця з меньшою кількістю днів немає!!!");
        }
    }

    //3
    private static void getDaysInYear(int days) throws WrongInputParametersException {
        System.out.println("З такою кількість днів є ще такі місяці :");
        checkDaysExist(days);
        for (Month value : Month.values()) {
            if (value.getDays() == days) {
                System.out.println(value.toString());
            }
        }
    }

    private static void checkDaysExist(int days) throws WrongInputParametersException {
        if (days < 28 || days > 31) {
            throw new WrongInputParametersException("Такої кількості днів в місяці немає!!!");
        } else if (days == 29) {
            System.out.println("Така кількість днів є в FEBRUARY раз в 4 роки!!!");
        }
    }


    //2
    private static void getMonthWithSeason(String monthToCheck) throws WrongInputParametersException {
        Season season = getSeason(monthToCheck);
        System.out.println("В даному сезоні є місяці :");
        for (Month value : Month.values()) {
            if (value.getSeason().equals(season)) {
                System.out.println(value.toString());
            }
        }
    }

    private static Season getSeason(String monthToCheck) throws WrongInputParametersException {
        checkMonthExists(monthToCheck);
        Season season = null;
        for (Month value : Month.values()) {
            if (value.name().equalsIgnoreCase(monthToCheck)) {
                season = value.getSeason();
            }
        }
        return season;
    }


    //1
    private static void getMonth(String month) throws WrongInputParametersException {
        checkIfMonthExists(month);
        for (Month value : Month.values()) {
            if (month.equalsIgnoreCase(value.name())) {
                System.out.println("Ваш місяць " + month + " існує.");
            }
        }
    }

    private static void checkIfMonthExists(String month) throws WrongInputParametersException {
        boolean isExists = false;
        for (Month month1 : Month.values()) {
            if (month1.name().equalsIgnoreCase(month)) {
                isExists = true;
                break;
            }
        }
        if (!isExists) throw new WrongInputParametersException("Такого місяця не існує!!!");
    }

    private static void menuOptions() {
        System.out.println("\n      Умови задачі : \n");
        System.out.println("1. Перевірити чи такий місяць існує.");
        System.out.println("2. Вивести всі місяці з такою ж порою року.");
        System.out.println("3. Вивести всі місяці які мають таку саму кількість днів.");
        System.out.println("4. Вивести на екран всі місяці які мають меншу кількість днів.");
        System.out.println("5. Вивести на екран всі місяці які мають більшу кількість днів.");
        System.out.println("6. Вивести на екран наступну пору року.");
        System.out.println("7. Вивести на екран попередню пору року.");
        System.out.println("8. Вивести на екран всі місяці які мають парну кількість днів.");
        System.out.println("9. Вивести на екран всі місяці які мають непарну кількість днів.");
        System.out.println("10. Вивести на екран чи введений з консолі місяць має парну кількість днів.");
        System.out.println("11. Вихід!\n");
        System.out.println("Ведіть номер : ");
    }
}
