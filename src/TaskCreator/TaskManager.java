package TaskCreator;

import IdCreator.Id;
import TaskPackage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskManager {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public TaskManager() throws IOException, ParseException {
        while(true){
            System.out.println("1 - создание новой задачи \n2 - удаление существующей задачи" +
                    "\n3 - выгрузка списка задач в файл \n4 - выход из программы");
            String userInput = reader.readLine();
            if(userInput.equals("4")){
                reader.close();
                break;
            }
            switch (userInput){
                case "1":
                    createTask();
                    break;
                case "2":
                    deleteTask();
                    break;
                case "3":
                    uploadTasks();
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз");
                    break;
            }

        }
    }

    private void uploadTasks() throws IOException {
        TaskExport.getInstance().write(TaskList.getInstance().getList());
    }

    private void deleteTask() throws IOException {
        ArrayList<Task> tempList = TaskList.getInstance().getList();
        if(!tempList.isEmpty()) {
            System.out.println("Для удления задачи введите ее id:");
            TaskList.getInstance().showList();
            int userChoice = Integer.parseInt(reader.readLine());
            Task taskToDelete = null;
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).getId() == userChoice) {
                    taskToDelete = tempList.get(i);
                }
            }
            TaskList.getInstance().removeTask(taskToDelete);
        }
        else System.out.println("Планировщик дел пуст");
    }

    private void createTask() throws IOException, ParseException {
        System.out.println("Введите приоритет задачи: 1 - Высокий, 2 - Средний, 3 - Низкий: ");
        String userPriority = reader.readLine();
        System.out.println("Введите текст задачи: ");
        String userTaskDescription = reader.readLine();
        System.out.println("Введите дату исполнения в формате ДД.ММ.ГГГГ. :");
        String userDeadline = reader.readLine();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date userDate = format.parse(userDeadline);
        System.out.println("Введите исполнителя задачи: ");
        String userName = reader.readLine();
        Task localTask = null;
        switch (userPriority){
            case "1":
                localTask = new HighPriorityTask();
                break;
            case "2":
                localTask = new MediumPriorityTask();
                break;
            case "3":
                localTask = new LowPriorityTask();
                break;
        }
        localTask.setId(Id.getId());
        localTask.setTaskDescription(userTaskDescription);
        localTask.setCreateDate(new Date());
        localTask.setDeadline(userDate);
        localTask.setAuthor(userName);
        TaskList.getInstance().addTask(localTask);


    }
}
