package test.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        Operation operation = new Operation();

        System.out.println("?help?");
        do {
            input = scan.nextLine();

            if(input.equals("help")){
                System.out.println("list, new, done, in progress, complete i, add, edit i, remove i, exit");
            }
            if(input.equals("list")){
                operation.view("all");
            }
            if(input.equals("new")){
                operation.view("NEW");
            }
            if(input.equals("done")){
                operation.view("DONE");
            }
            if(input.equals("in progress")){
                operation.view("IN_PROGRESS");
            }
            if(input.contains("complete")){
                String[] division = input.split("\\s");
                try {
                    operation.complete(Integer.parseInt(division[1]));
                }
                catch (Exception ei) {
                    System.out.println("Вы не ввели номер элемента");
                }
            }
            if(input.equals("add")){
                operation.add();
            }
            if(input.contains("edit")){
                String[] division = input.split("\\s");
                try {
                    operation.edit(Integer.parseInt(division[1]));
                }
                catch (Exception ei) {
                    System.out.println("Вы не ввели номер элемента");
                }
            }
            if(input.contains("remove")){
                String[] division = input.split("\\s");
                try {
                    operation.remove(Integer.parseInt(division[1]));
                }
                catch (Exception ei) {
                    System.out.println("Вы не ввели номер элемента");
                }
            }
            if(input.equals("exit")){
                System.out.println("see you soon");
            }

        }
        while (!input.equals("exit"));

    }
}

