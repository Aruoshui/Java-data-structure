package 高级Java程序开发.第三作业.买票;
public class ConcertTicketSystem {
    // 门票数量
    private int ticketNum = 20;

    public static void main(String[] args) {

        ConcertTicketSystem ticketSystem = new ConcertTicketSystem();


        Thread ticketSeller1 = new Thread(ticketSystem.new TicketSeller(), "售票员1");
        Thread ticketSeller2 = new Thread(ticketSystem.new TicketSeller(), "售票员2");
        Thread ticketSeller3 = new Thread(ticketSystem.new TicketSeller(), "售票员3");


        ticketSeller1.start();
        ticketSeller2.start();
        ticketSeller3.start();
    }

    // 售票员类
    class TicketSeller implements Runnable {
        @Override
        public void run() {
            while (ticketNum > 0) {
                // 使用 synchronize 关键字对共享资源 ticketNum 进行加锁，以保证线程安全
                synchronized (ConcertTicketSystem.this) {
                    if (ticketNum > 0) {

                        String sellerName = Thread.currentThread().getName();


                        System.out.println(sellerName + "卖出了第" + ticketNum + "张门票，现在剩余门票数量为：" + (--ticketNum));

                        // 休眠一段时间，模拟售票过程
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(Thread.currentThread().getName()+"售票结束，没票了");
                        break;
                    }
                }
            }
        }
    }
}

