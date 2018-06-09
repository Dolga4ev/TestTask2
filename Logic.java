package test.task2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Logic {
    public List<Task> complete(List<Task> taskList, int index){
        for(int i = 0; i < taskList.size(); i++){
            Task task = taskList.get(i);
            if(task.getId().equals(Integer.toString(index))){
                task.setStatus(Status.DONE);
                task.setComplete(LocalDateTime.now().toLocalDate().toString());
            }
        }
        return taskList;
    }
    public List<Task> add(List<Task> taskList, Task newTask){
        taskList.add(newTask);
        return taskList;
    }
    public List<Task> edit(List<Task> taskList, int index){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the title (if you don't want to change, write '-')");
        String title = scan.nextLine();
        System.out.println("enter the description (if you don't want to change, write '-')");
        String description = scan.nextLine();
        System.out.println("enter the priority (if you don't want to change, write '-')");
        String priority = scan.nextLine();
        System.out.println("enter the deadline (if you don't want to change, write '-')");
        String deadline = scan.nextLine();
        for(int i = 0; i < taskList.size(); i++){
            Task task = taskList.get(i);
            if(task.getId().equals(Integer.toString(index))){
                if(!title.equals("-")){
                    task.setTitle(title);
                }
                if(!description.equals("-")){
                    task.setDescription(description);
                }
                if(!priority.equals("-")){
                    task.setPriority(priority);
                }
                if(!deadline.equals("-")){
                    task.setDeadline(deadline);
                }

            }
        }
        return taskList;
    }
    public List<Task> remove(List<Task> taskList, int index){
        for(int i = 0; i < taskList.size(); i++){
            Task task = taskList.get(i);
            if (task.getId().equals(Integer.toString(index))){
                taskList.remove(task);
            }
        }
        return taskList;
    }
    public Task createTask(int id){
        Scanner scan = new Scanner(System.in);
        Task newTask = new Task();
        int lastIndex =  id + 1;
        newTask.setId(Integer.toString(lastIndex));
        System.out.println("enter the new title");
        newTask.setTitle(scan.nextLine());
        System.out.println("enter the new description");
        newTask.setDescription(scan.nextLine());
        System.out.println("enter the new priority");
        newTask.setPriority(scan.nextLine());
        System.out.println("enter the new deadline");
        newTask.setDeadline(scan.nextLine());
        newTask.setStatus(Status.NEW);
        newTask.setComplete("-");
        return newTask;
    }

}
