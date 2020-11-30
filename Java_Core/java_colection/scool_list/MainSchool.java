package java_colection.scool_list;

import java_colection.scool_list.dto.enums.KindOfWorks;
import java_colection.scool_list.service.impl.StatisticServesImpl;

import java.util.Scanner;

public class MainSchool {

    private static Scanner sc = new Scanner(System.in);
    private static StatisticServesImpl statisticServes = new StatisticServesImpl();

    public static void main(String[] args) {

        int stop = 0;
        do {
            System.out.println("Choose option : \n" +
                    "1 - Check teachers by Email.\n" +
                    "2 - Add new employee. \n" +
                    "3 - Do Email validation by regEx. \n" +
                    "4 - How many teachers what subject are taught. \n" +
                    "5 - Who worked the most hours \n" +
                    "6 - See all employee \n" +
                    "7 - Exit!");

            int serves = sc.nextInt();
            switch (serves) {
                case 1:
                    statisticServes.checkEmployeeByEmail();
                    break;
                case 2:
                    statisticServes.addNewEmployee();
                    statisticServes.getAllEmployee();
                    break;
                case 3:
                    statisticServes.emailValidator();
                    break;
                case 4:
                    System.out.println("Number of teachers per subject : ");
                    for (KindOfWorks works : KindOfWorks.values()) {
                        int count = statisticServes.getCountEmployeesOfLessons(works);
                        System.out.println("In this kind of works : " + works + " there are " + count + " employee.");
                    }
                    break;
                case 5:
                    statisticServes.getCountMaxHour();
                    break;
                case 6:
                    statisticServes.getAllEmployee();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }
            System.out.println("Exit - 0, continue - any number!");
            stop = sc.nextInt();
        } while (stop != 0);
    }
}
