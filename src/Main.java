import java.util.Random;
public class Main {
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
//    private static double testQueue(Queue<Integer> q, int opCount){
//
//        long startTime = System.nanoTime();
//
//        Random random = new Random();
//        for(int i = 0 ; i < opCount ; i ++)
//            q.enqueue(random.nextInt(Integer.MAX_VALUE));
//        for(int i = 0 ; i < opCount ; i ++)
//            q.dequeue();
//
//        long endTime = System.nanoTime();
//
//        return (endTime - startTime) / 1000000000.0;
//    }
    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {

//        int[] arr = new int[10];
//        for(int i =0;i<arr.length;i++)
//            arr[i]=i;
//
//        int [] score = new int[]{100,99,66};
//        for(int i =0;i<score.length; i++)
//            System.out.println(score[i]);
//
//        for(int score1:score)
//            System.out.println(score1);
//
//        score[0] = 98;
//        for(int i =0;i<score.length; i++)
//            System.out.println(score[i]);
//    }
//        Array<Integer> arr = new Array<>();
//        for(int i=0;i<10;i++)
//            arr.addLast(i);
//        System.out.println(arr);
//
//        arr.add(1,100);
//        System.out.println(arr);
//
//        arr.addFist(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.remveFirst();
//        System.out.println(arr);

//        ArrayStack<Integer> stack = new ArrayStack<>();
//        for(int i=0;i<5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//        stack.pop();
//        System.out.println(stack);
//        int opCount = 100000;
//
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue, time: " + time1 + " s");
//
//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//        double time2 = testQueue(loopQueue, opCount);
//        System.out.println("LoopQueue, time: " + time2 + " s");

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        // 其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
    }

}