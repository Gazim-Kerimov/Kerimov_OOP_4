package TaskPackage;

import java.util.Date;

public abstract class Task {
    private int id;
    private Date createDate;
    private Date deadline;
    private String author;
    private Priority priority;

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    private String taskDescription;

    protected Task() {
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getAuthor() {
        return author;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public String toString() {
        String result = "ID:" + this.getId() + " | PRIORITY:" + this.getPriority() + " | TASK:" +
                this.getTaskDescription() + " | DEADLINE: " + this.getDeadline() + " | AUTHOR:" +
                this.getAuthor() + " | ADDED AT:" + this.getCreateDate() + "\n";
        return result;
    }
}
