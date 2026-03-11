package com.njx.TanXin;

import java.util.*;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int a = sc.nextInt();
            int e = sc.nextInt();
            students[i] = new Student(s,a,e);
        }
        Arrays.sort(students, (x, y) -> (2*(x.s+x.a)+x.e) - (2*(y.s+y.a)+y.e));
        long cur = 0;
        long sum=0;
        for (int i = 0; i < n; i++) {
            //发消息的时间 = 进入时刻 + s + a
            long t = cur + students[i].s + students[i].a;
            sum += t;
            // 离开时刻 = 发消息时刻 + e（累计）
            cur = t + students[i].e;
        }
        System.out.println(sum);
    }
    static class Student{
        int s;
        int a;
        int e;

        public Student(int s, int a, int e) {
            this.s = s;
            this.a = a;
            this.e = e;
        }
    }

}
/*
有 n 位同学同时找老师答疑。每位同学都预先估计了自己答疑的时间。
老师可以安排答疑的顺序，同学们要依次进入老师办公室答疑。一位同学答疑的过程如下：
1. 首先进入办公室，编号为 的同学需要 s 毫秒的时间。
2. 然后同学问问题老师解答，编号为的同学需要α毫秒的
时间。
3.答疑完成后，同学很高兴，会在课程群里面发一条消息，需要的时间可以忽略。
4.最后同学收拾东西离开办公室，需要 é毫秒的时间。一般需要 10 秒、20 秒或 30 秒，即 e; 取值为 10000，20000或30000。
一位同学离开办公室后，紧接着下一位同学就可以进入办公室了。
答疑从0时刻开始。老师想合理的安排答疑的顺序，使得同学们在课程群里面发消息的时刻之和最小。
输入描述
输入第一行包含一个整数n，表示同学的数量。
接下来 n 行，描述每位同学的时间。其中第 行包含三个整数S,a,é，意义如上所述。
其中有，1≤n≤ 1000，1≤ ≤ 60000，1≤α ≤10°, e ∈ 10000,20000,30000,即 e一定是
10000、20000、30000 之一。
输出描述
输出一个整数，表示同学们在课程群里面发消息的时刻之和最小是多少。
 */