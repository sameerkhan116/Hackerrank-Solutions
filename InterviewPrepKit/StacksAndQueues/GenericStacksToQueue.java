import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<T> {
    Stack<T> st1;
    Stack<T> st2;
    
    public MyQueue() {
        st1 = new Stack<T>();
        st2 = new Stack<T>();
    }

    public void enqueue(T n) {
        st1.push(n);
    }

    public void dequeue() {
        if(!st2.isEmpty()) {
            st2.pop();
        } else {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            st2.pop();
        }
    }

    public T peek() {
        if(!st2.isEmpty()) {
            return st2.peek();
        }
        else {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            return st2.peek();
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

