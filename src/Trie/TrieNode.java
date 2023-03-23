package Trie;

import java.util.HashMap;

/*
* For Trie use case:
* string or sequence typed elements
* fast worst case search/add/delete
* grouping common prefix, both for time/space efficiency
* problems related to prefix/matching
* */
public class TrieNode {
    //maps a character to its crosponding child
    HashMap<Character, TrieNode> children;
    //int[] children -> but this must be lower case 26 char
    int val;
    boolean isWord;
    TrieNode root;
    int count;
}
