package TaskCreator;

import TaskPackage.Task;

import java.io.*;
import java.util.ArrayList;

public class TaskExport {
    private static TaskExport instance;
    private TaskExport() throws IOException {
    }
    public static TaskExport getInstance() throws IOException {
        if(instance == null){
            instance = new TaskExport();
        }
        return instance;
    }
    File exportFile = new File("/Users/gazimkerimov/IdeaProjects/OOP_Seminar4/src/TaskCreator/tasktable.xml");
    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(exportFile, true));
    public void write(ArrayList<Task> list) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            fileWriter.write(list.get(i).toString());
        }
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Задания успешно выгружены в файл!");
    }
}
