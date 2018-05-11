import java.util.TreeMap;
public class Trie {
    public class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    //获得Trie中的存储的单词数量
    public int getSize(){
        return size;
    }

    //向trie中添加一个新单词word
    public void add(String word){
        Node cur = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (cur.next.get(c)==null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord =true;
            size++;
        }

    }
}