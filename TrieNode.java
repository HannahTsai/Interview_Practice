import java.util.*;

public class TrieNode{
    char val;
    boolean isWord;
    String str;
    TrieNode[] children;

    public TrieNode(){}
    public TrieNode(char val){
        this.val = val;
        this.isWord = false;
        this.str = null;
        this.children = new TrieNode[26];
    }
}