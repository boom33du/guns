package cn.stylefeng.guns.modular;

import java.util.*;

public class Test {

    List<Long> l = new ArrayList<Long>();
    public static void main(String[] args)
    {
        //long end = new Test().FibonacciSequence(200);
        Test t = new Test();
        t.FibonacciSequence2();
        System.out.println("第100个数是："+t.l.get(99));
    }

    public void FibonacciSequence2()
    {
        long a = 1,b=1,c=0;
        l.add(a);
        l.add(b);
        for(long i=2;i<10000;i++)
        {
            a=l.get((int)(i-2));
            b=l.get((int)(i-1));
            l.add(a+b);
        }
    }

    public long FibonacciSequence(long n)
    {
        System.out.println("正在计算第"+n+"个数。");
        if(n == 1 || n == 2)
        {
            return 1;
        }else
        {
            return FibonacciSequence(n-1) + FibonacciSequence(n-2);
        }

    }

    public void findAllPrimeNumber()
    {
        long begin = System.currentTimeMillis();
        List<Integer> l = new ArrayList<Integer>();
        for(int i=2;i<1000000;i++)
        {
            System.out.println("---开始判断["+i+"]是不是质数---");
            int j = 0;
            for(j=2;j<i/2;j++)
            {
                if(i % j == 0)
                {
                    break;
                }
            }
            if(j>=i/2)
            {
                System.out.println("***["+i+"]是质数***\n");
                l.add(i);
            }else
            {
                System.out.println("***["+i+"]不是质数***\n");
            }
        }
        System.out.println("一百万以内的质数有：");
        for(int i=0;i<l.size();i++)
        {
            System.out.print(l.get(i)+",");
        }
        System.out.println("\n共"+l.size()+"个。");
        long end = System.currentTimeMillis();
        int secT = (int)((end - begin) / 1000);
        int minT = secT/60;
        int sec = secT % 60;
        System.out.println("共用时间["+minT+"]分钟["+sec+"]秒。");
    }
}
