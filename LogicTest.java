package test.task2;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LogicTest {
    @Test
    public void addTest() {
        Logic logic = new Logic();
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("1", "Title 1", "Description 1", "46", "2018-07-04", Status.NEW, "-"));
        taskList.add(new Task("2", "Title 2", "Description 2", "25", "2018-05-01", Status.DONE, "2018-06-08"));
        taskList.add(new Task("3", "Title 3", "Description 3", "47", "2018-03-02", Status.IN_PROGRESS, "-"));
        Task task = new Task("4", "Title 4", "Description 4", "1", "2018-06-08", Status.IN_PROGRESS, "-");
        logic.add(taskList, new Task("4", "Title 4", "Description 4", "1", "2018-06-08", Status.IN_PROGRESS, "-"));
        assertTrue(find(taskList, task));
    }

    public boolean find(List<Task> taskList, Task task) {
        for (Task taskCurrent:taskList){
            if(taskCurrent.equals(task)){
                return true;
            }
        }
        return false;
    }
}