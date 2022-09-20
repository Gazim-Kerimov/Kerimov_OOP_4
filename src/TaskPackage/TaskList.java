package TaskPackage;

import java.util.ArrayList;

public class TaskList{
    private static TaskList instance;
    private ArrayList<Task> list;
    private TaskList(){
        list = new ArrayList<>();
    }
    public static TaskList getInstance(){
        if(instance == null){
            instance = new TaskList();
        }
        return instance;
    }
    public void addTask(Task task){
        list.add(task);
        System.out.println("Задача успешно добавлена!");
        sortByPriority();
    }
    public void removeTask(Task task){
        if (list.contains(task)) {
            list.remove(list.indexOf(task));
            System.out.println("Задача успешно удалена!");
        }
        else System.out.println("Задача не найдена в списке планировщика");
    }
    private void sortByPriority() {
        ArrayList<Task> sorted = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Task temp = list.get(i);
            if (temp.getPriority().equals(Priority.HIGH)) {
                sorted.add(temp);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Task temp = list.get(i);
            if (temp.getPriority().equals(Priority.MEDIUM)) {
                sorted.add(temp);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Task temp = list.get(i);
            if (temp.getPriority().equals(Priority.LOW)) {
                sorted.add(temp);
            }
        }
        list = sorted;
        showList();
    }

    public ArrayList<Task> getList() {
        return list;
    }
    public void showList(){
        for (int i = 0; i < list.size(); i++) {
            Task perm = this.list.get(i);
            System.out.println(perm.toString());
        }
    }
}
