public class Student {
    private String name;
    private int score;

    public Student(String studentName,int studentScore){
        name=studentName;
        score = studentScore;
    }

    @Override
    public String toString(){
        return String.format("Student(name:%s，score:%d)",name,score);
    }

    public static void main(String[] args){
        Array<Student> arr =new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("bob",19));
        arr.addLast(new Student("chare",10));
        arr.addLast(new Student("dave",22));
        System.out.println(arr);
    }
}
