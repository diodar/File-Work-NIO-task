package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileWriteService fw = new FileWriteService();
        FileReadService fr = new FileReadService();

        int data = getData();

        switch (data) {
            case 1 -> {
                System.out.println("Creating new file...in progress");
                System.out.println("Enter file name:");
                String fileName = sc.nextLine();
                fw.getOutput(fw.createFile(fileName));
            }
            case 2 -> {
                System.out.println("Enter file name:");
                String fileName = sc.nextLine();
                System.out.println("Enter file content: ");
                String content = sc.nextLine();
                fw.getOutput(fw.writeToFile(fileName, content));
            }
            case 3 -> {
                System.out.println("Opening a file...in progress");
                System.out.println("Enter file name:");
                String fileName = sc.nextLine();
                fr.getOutput(fr.readFromFile(fileName));
            }
            case 0 -> {
                System.out.println("The program was terminated by the User");
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + data);
        }
    }

    public static int getData() {

        Scanner sc = new Scanner(System.in);
        boolean isValidNum = false;
        int num = 0;

        while (!isValidNum) {
            System.out.println("""
                    What do you need to do? Type a number:
                    1 - create a new file
                    2 - write to already created file
                    3 - read already created file
                    0 - close the program""");

            try {
                num = sc.nextInt();

                if (num >= 0 && num <= 3) {
                    isValidNum = true;
                } else {
                    System.out.println("Wrong number. Try again." + '\n');
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a number. Try again." + '\n');
                sc.nextLine();
            }
        }
        return num;
    }
}