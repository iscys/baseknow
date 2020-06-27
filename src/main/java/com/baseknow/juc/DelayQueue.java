package com.baseknow.juc;


import java.util.Random;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueue implements Delayed {

    private long expireTime;

    private long delayM;

    public DelayQueue (long delayM){

        this.delayM = delayM;
        this.expireTime = System.currentTimeMillis()+delayM;
    }

    public static void main(String[] args) throws Exception{
        java.util.concurrent.DelayQueue<DelayQueue> queue =new java.util.concurrent.DelayQueue();


        queue.offer(new DelayQueue(8000));
        queue.offer(new DelayQueue(9000));
        queue.offer(new DelayQueue(5000));
        queue.offer(new DelayQueue(5000));
        queue.offer(new DelayQueue(5000));


        for(;;){

            DelayQueue take = queue.take();
            final long delay = take.getDelayM();
            System.out.println(delay);

        }


    }

    @Override
    public long getDelay(TimeUnit unit) {

        long expireTime1 =this.expireTime -System.currentTimeMillis();
        return unit.convert(expireTime1,TimeUnit.MILLISECONDS);
    }


    @Override
    public int compareTo(Delayed o) {

        long d = (getDelay(TimeUnit.NANOSECONDS) -
                o.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    public long getDelayM(){
        return delayM;
    }

    public long getExpireTime(){
        return expireTime;
    }
}
