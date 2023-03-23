package Trie;

public class TrieImplement {
    TrieNode root;
    public  boolean search (String word){
        //start with null
        TrieNode cur = root;
        //check every char has next char
        for (int i = 0; i < word.length(); i++){
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null){
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }
    public boolean insert (String word){
        //如果字典里已经存在了这个单词, 直接return false
        if (search(word)){
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null){
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;
        }
        cur.isWord = true;
        return true;
    }
    public boolean delete (String word){
        if (!search(word)){ //如果不存在字典里，返回false
            return false;
        }
        //当前isword的node以下（包括自己），需要一个count检查下面有多少个isword
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            TrieNode next = cur.children.get(word.charAt(i));
            next.count--; //没往下走一层都count--
            if (next.count == 0){
                cur.children.remove(word.charAt(i));
                return true;
            }
            cur = next;
        }
        cur.isWord = false; //apples, 有可能会删除apple，把apple改成false，剩下s
        return true; //apple能被删除，所以返回true
    }

    public static void main(String[] args) {
        TrieImplement trie = new TrieImplement();
        String s = "lei";
        System.out.println(trie.search(s));

    }
}
