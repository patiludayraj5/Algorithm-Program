import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    int deadline;
    int minutes;

    Task(int deadline, int minutes) {
        this.deadline = deadline;
        this.minutes = minutes;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tasks: ");
        int numTasks = scanner.nextInt();
        Task[] tasks = new Task[numTasks];

        for (int i = 0; i < numTasks; i++) {
            System.out.print("Enter deadline and minutes for task " + (i + 1) + ": ");
            int deadline = scanner.nextInt();
            int minutes = scanner.nextInt();
            tasks[i] = new Task(deadline, minutes);
        }

        Arrays.sort(tasks, Comparator.comparingInt(task -> task.deadline));

        int[] completionTimes = new int[numTasks];
        int totalCompletionTime = 0;

        for (int i = 0; i < numTasks; i++) {
            totalCompletionTime += tasks[i].minutes;
            completionTimes[i] = totalCompletionTime;
        }

        int[] overshoots = new int[numTasks];

        for (int i = 0; i < numTasks; i++) {
            overshoots[i] = Math.max(0, completionTimes[i] - tasks[i].deadline);
        }

        System.out.println("\nMaximum amount by which a task's completion time overshoots its deadline:");

        for (int i = 0; i < numTasks; i++) {
            System.out.println("Task " + (i + 1) + ": " + overshoots[i] + " minutes");
        }

        scanner.close();
    }
}
