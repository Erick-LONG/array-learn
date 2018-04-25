public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for(int i =0;i<arr.length;i++)
            arr[i]=i;

        int [] score = new int[]{100,99,66};
        for(int i =0;i<score.length; i++)
            System.out.println(score[i]);

        for(int score1:score)
            System.out.println(score1);

        score[0] = 98;
        for(int i =0;i<score.length; i++)
            System.out.println(score[i]);
    }
}
