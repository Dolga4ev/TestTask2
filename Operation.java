package test.task2;

import java.util.List;

public class Operation {
    XmlFile writer = new XmlFile();
    private Logic logic = new Logic();

    public void view(String NewDoneInProgress){
        XmlFile file = new XmlFile();
        List<Task> taskList = file.read();
        for (Task task:taskList){
            if(NewDoneInProgress.equals("all")) {
                System.out.println(task);
            }
            else{
                if (task.getStatus().toString().equals(NewDoneInProgress)){
                    System.out.println(task);
                }
            }
        }
    }
    public void complete(int index){
        XmlFile file = new XmlFile();
        List taskList = file.read();
        taskList = logic.complete(taskList, index);
        writer.write(taskList);
    }
    public void add(){
        XmlFile file = new XmlFile();
        List<Task> taskList = file.read();
        Task task = logic.createTask(Integer.parseInt(taskList.get(taskList.size() - 1).getId()));
        logic.add(taskList, task);
        writer.write(taskList);
    }
    public void edit(int index){
        XmlFile file = new XmlFile();
        List<Task> taskList = file.read();
        taskList = logic.edit(taskList, index);
        writer.write(taskList);
    }
    public void remove(int index){
        XmlFile file = new XmlFile();
        List<Task> taskList = file.read();
        taskList = logic.remove(taskList, index);
        writer.write(taskList);
    }
}
