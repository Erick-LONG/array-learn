public class Main {

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

        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}