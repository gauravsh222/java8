package ds;

import java.util.HashMap;
import java.util.Map;

class Node {
    char ch;
    boolean isWord;
    Map<Character, Node> map;

    public Node(char ch) {
        this.ch = ch;
        this.map = new HashMap<>();
    }
}

public class Trie {

    Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String data) {
        Node curr = root;
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if(!curr.map.containsKey(ch)) {
                Node node = new Node(ch);
                curr.map.put(ch, node);
            }
            curr = curr.map.get(ch);
        }
        curr.isWord=true;
    }

    public boolean search(String data) {
        Node curr = root;
        for (char ch : data.toCharArray()) {
            if(!curr.map.containsKey(ch)) {
                return false;
            }
            curr = curr.map.get(ch);
        }
        return curr.isWord;
    }


    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("solid");
        t.insert("sonu");
        t.insert("sofia");
        System.out.println(t.search("solid"));
        System.out.println(t.search("sonu"));
        System.out.println(t.search("sofi"));
    }
}
