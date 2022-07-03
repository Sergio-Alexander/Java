package tests.console.week02;

import utils.MyQueue;
import java.util.Stack;
import utils.MyStack;

public class MyStackTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("=====================================================");
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t S T A C K    T E S T    P R O G R A M");
        System.out.println();
        System.out.println("=====================================================");
        System.out.println();
        System.out.println();
    }


    public static void libraryVersionTest(){
        System.out.println();
        System.out.println("<------- \t L I B R A R Y \t\t S T A C K \t ------->");
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();

        System.out.println();
        System.out.println();

        //test push
        System.out.println("************\t Test push \t**************");
        System.out.println(stack.push("Red"));
        System.out.println(stack.push("Orange"));
        System.out.println(stack.push("Yellow"));
        System.out.println(stack.push("Green"));
        System.out.println(stack.push("Blue"));
        System.out.println(stack.push("Indigo"));
        System.out.println(stack.push("Violet"));
        System.out.println(stack);
        System.out.println();
        System.out.println();
        System.out.println();


        // test pop
        System.out.println("************\t Test pop \t**************");
        System.out.println();
        System.out.println("----------original-----------");
        System.out.println("size: " + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------1st pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------2nd pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------3rd pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------4th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------5th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------6th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------7th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println();

        //test peek
        System.out.println("************\t Test peek \t **************");
        stack1.push("Red");
        stack1.push("Orange");
        stack1.push("Yellow");
        System.out.println(stack1);
        System.out.println("peek element: " + stack1.peek());
        System.out.println();
        System.out.println();
    }


    public static void myVersionTest(){
        System.out.println();
        System.out.println("==========  M Y   S T A C K  ==========");
        MyStack<String> stack = new MyStack<>();
        System.out.println();
        System.out.println();

        //test push
        System.out.println("************\t Test push \t**************");
        System.out.println(stack.push("Red"));
        System.out.println(stack.push("Orange"));
        System.out.println(stack.push("Yellow"));
        System.out.println(stack.push("Green"));
        System.out.println(stack.push("Blue"));
        System.out.println(stack.push("Indigo"));
        System.out.println(stack.push("Violet"));
        System.out.println(stack);
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public static void myVersionTestS(){
        System.out.println();
        System.out.println("==========  M Y   S T A C K  ==========");
        MyStack<String> stack = new MyStack<>();
        System.out.println();
        System.out.println();

        //test push
        System.out.println("************\t Test Stack \t**************");
        stack.push("Red");
        stack.push("Orange");
        stack.push("Yellow");
        stack.push("Green");
        stack.push("Blue");
        stack.push("Indigo");
        stack.push("Violet");
        System.out.println(stack);
        System.out.println();
        System.out.println();
        System.out.println();

    }


    public static void myVersionTestQ(){ // Testing Queues
        System.out.println();
        System.out.println("==========  M Y   Q U E U E  ==========");
        MyQueue<String> queues = new MyQueue<>();
        System.out.println();
        System.out.println();

        //test push
        System.out.println("************\t Test Queue \t**************");
        queues.add("Red");
        queues.add("Orange");
        queues.add("Yellow");
        queues.add("Green");
        queues.add("Blue");
        queues.add("Indigo");
        queues.add("Violet");
        System.out.println(queues);
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public static int removeMin(MyStack <Integer> stack){
        MyQueue<Integer> queue = new MyQueue<>();
        stackToQueue(stack, queue); // changing stack to queue
        int min_num = queue.remove(); // initializing the minimum number to the removed queue data
        stack.push(min_num); // stack adding the removed queue data

        while(!queue.isEmpty()){ // while queue is not empty
            if(queue.peek() < min_num){ // if the queue data is less than the queue removed
                min_num = queue.peek(); // queue removed will equal to the queue peeked
                stack.push(queue.remove()); // stack will add the removed number
            }else{
                stack.push(queue.remove()); // stack will add the removed number
            }
        }
        while(!stack.isEmpty()){ // while stack is not empty
            if(stack.peek() == min_num){ // the stack data will equal to the queue removed
                stack.pop(); // stack remove
            }else{
                queue.add(stack.pop()); // queue will add the removed stack number
            }
        }
        queueToStack(queue,stack); // changing queue to stack
        System.out.println("The smallest number is " + min_num);
        return min_num;
    }

    public static void removeMinTest(){
        System.out.println();
        System.out.println("============  R E M O V E   M I N  =============");

        MyStack<Integer> stacks = new MyStack<>();

        stacks.push(24);
        stacks.push(-10);
        stacks.push(15);
        stacks.push(38);
        stacks.push(4);
        stacks.push(11);
        stacks.push(6);
        stacks.push(18);
        stacks.push(12);
        stacks.push(-10);

        System.out.println("Original Stack is " + stacks);

        removeMin(stacks);

        System.out.println("Stacks after the min number has been removed is " + stacks);
    }

    public static void queueToStack(MyQueue<Integer> queue, MyStack<Integer> stack){
        while(!queue.isEmpty()){ // while queue is not empty
            stack.push(queue.remove()); // adding the queue to the stack that is being removed
        }
    }

    public static void stackToQueue(MyStack<Integer> stack, MyQueue<Integer> queue){
        while(!stack.isEmpty()){ // while stack is not empty
            queue.add(stack.pop()); // adding the stack to the queue that is being removed
        }
    }

    public static void testingQtoSandViceVersa(){

        System.out.println();
        System.out.println("============  T E S T I N G  F U N C T I O N S  =============");

        MyStack<Integer> stack = new MyStack<>();
        MyQueue<Integer> queue = new MyQueue<>();

        stack.push(24);
        stack.push(-10);
        stack.push(15);
        stack.push(38);
        stack.push(4);
        stack.push(11);
        stack.push(6);
        stack.push(18);
        stack.push(12);
        stack.push(-10);

        System.out.println("Stack is " + stack);
        stackToQueue(stack, queue);
        System.out.println("Queue is " + queue);
        System.out.println("Stack is " + stack);
        queueToStack(queue, stack);
        System.out.println("Stack is " + stack);
        System.out.println("Queue is " + queue);

    }

    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();

        myVersionTestQ();
        myVersionTestS();
        testingQtoSandViceVersa();
        removeMinTest();
    }
}