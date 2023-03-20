package 高级Java程序开发.第三作业.龟兔赛跑;
public class Race {
    public static void main(String[] args) {
        int totalDistance = 100; // 总距离
        int step = 10; // 步长
        Turtle turtle = new Turtle("乌龟", step, totalDistance);
        Rabbit rabbit = new Rabbit("兔子", step, totalDistance);
        turtle.setPriority(Thread.MAX_PRIORITY);  //设置乌龟进程的优先级最高
        rabbit.setPriority(Thread.MIN_PRIORITY);  //设置兔子进程的优先级最低
        turtle.start();
        rabbit.start();
    }
}

class Turtle extends Thread {
    private int step; // 步长
    private int totalDistance;

    public Turtle(String name, int step, int totalDistance) {
        super(name);
        this.step = step;
        this.totalDistance = totalDistance;
    }

    public void run() {
        int distance = 0; // 当前距离
        while (distance < totalDistance) {
            distance += step;
            System.out.println(Thread.currentThread().getName() + "跑了" + distance + "米");
            try {
                Thread.sleep(50); // 休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(distance == totalDistance){
            System.out.println("乌龟到达终点!!!!");
        }
    }
}

class Rabbit extends Thread {
    private int step; // 步长
    private int totalDistance;

    public Rabbit(String name, int step, int totalDistance) {
        super(name);
        this.step = step;
        this.totalDistance = totalDistance;
    }

    public void run() {
        int distance = 0; // 当前距离
        while (distance < totalDistance) {
            distance += step;
            System.out.println(Thread.currentThread().getName() + "跑了" + distance + "m");
            try {
                Thread.sleep(100); // 休眠100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if(distance == totalDistance){
            System.out.println("兔子到达终点!!!!");
        }
    }
}
