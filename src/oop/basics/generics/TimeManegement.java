package oop.basics.generics;

import java.util.LinkedList;
import java.util.Queue;

public class TimeManegement {
    public static void main(String[] args) {
        Queue<Employe> employes = new LinkedList<>();
//        employes.peek();
//        employes.poll();
//        employes.offer(null);

        employes.add(new Employe("Jarmil", 60, 30));
        employes.add(new Employe("David", 60, 30));
        employes.add(new Employe("Chose", 600, 30));
        employes.add(new Employe("Jarmil2", 60, 30));

        Queue<Task> tasks = new LinkedList<>();
        tasks.add(new Task("Exchange cables", 60));
        tasks.add(new Task("Update OS", 45));
        tasks.add(new Task("Install antivirus", 30));
        tasks.add(new Task("Replace hard drive", 120));
        tasks.add(new Task("Clean workstation", 20));
        tasks.add(new Task("Configure network", 90));
        tasks.add(new Task("Test hardware", 50));
        tasks.add(new Task("Set up printer", 25));
        tasks.add(new Task("Troubleshoot Wi-Fi", 35));
        tasks.add(new Task("Backup files", 75));
        tasks.add(new Task("Assemble PC", 150));
        tasks.add(new Task("Optimize performance", 40));
        tasks.add(new Task("Create user accounts", 15));
        tasks.add(new Task("Train new staff", 180));
        tasks.add(new Task("Remove malware", 55));
        tasks.add(new Task("Upgrade RAM", 25));
        tasks.add(new Task("Set up email client", 20));
        tasks.add(new Task("Reset passwords", 10));
        tasks.add(new Task("Patch security vulnerabilities", 80));
        tasks.add(new Task("Calibrate display", 30));


        while (!tasks.isEmpty() && !employes.isEmpty()) {
            Employe top = employes.peek();
            Task currentTask = tasks.peek();

            if(top.freeTime >= currentTask.completeTime){
                top.freeTime -= currentTask.completeTime;
                tasks.poll();
            }
            else{
                employes.poll();
            }
        }
    }
}
class Employe {
    String name;
    int freeTime;
    double shoeSize;

    public Employe(String name, int freeTime, double shoeSize) {
        this.name = name;
        this.freeTime = freeTime;
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return name + "free time left: " + freeTime;
    }
}
class Task{
    String taskName;
    int completeTime;

    public Task(String taskName, int completeTime) {
        this.taskName = taskName;
        this.completeTime = completeTime;
    }
}


