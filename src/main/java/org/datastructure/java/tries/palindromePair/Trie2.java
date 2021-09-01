package org.datastructure.java.tries.palindromePair;


import java.util.ArrayList;

//class TrieNode {
//    char data;
//    boolean isTerminating;
//    TrieNode children[];
//    int childCount;
//
//    public TrieNode(char data) {
//        this.data = data;
//        isTerminating = false;
//        children = new TrieNode[26];
//        childCount = 0;
//    }
//}

public class Trie2 {

    private TrieNode root;
    public int count;

    public Trie2() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        return search(child, word.substring(1));

    }

    public boolean search(String word) {
        return search(root, word);
    }

    private void print(TrieNode root, String word) {
        if (root == null) {
            return;
        }

        if (root.isTerminating) {
            System.out.println(word);
        }

        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }

    public void print() {
        print(this.root, "");
    }

    /*..................... Palindrome Pair................... */
    public boolean isPalindromePair(ArrayList<String> words) {
        //Your code goes here

        ///////////add words to the TRIE. FOr checking of palindrome add words in both default & reverse ordering.
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {
                if (checkItself(words.get(i))) return true;
                else addInDefaultNReverseOrder(words.get(i));
            } else {
                ///////check the existence of palindrome if-otherwise add the word in both default & reverse ordering.
                if (search(words.get(i))) return true;
                if (search(new StringBuffer(words.get(i)).reverse().toString())) return true;
                else {
                    if (checkItself(words.get(i))) return true;
                    if(checkInReverseOneByOne(words.get(i))) return true;
                    else addInDefaultNReverseOrder(words.get(i));
                    ///////add the word to the Trie in both the default & reverse ordering.
                }
            }
        }

        return false;
    }

    /////add the word in both the default & reverse ordering.
    private void addInDefaultNReverseOrder(String word) {
        add(word);/////adding word in default ordering
        final String reveredWord = new StringBuffer(word).reverse().toString();
        add(reveredWord);//////adding word in reverse ordering
    }
    /////check if the word is itself a Palindrome or not. If yes return true otherwise add both the default & reverse ordering into Tries.
    private boolean checkItself(String word) {
        /////first break word and check if this is Palindrome in itself.
        int midPoint = word.length() / 2;
        /////add partial char from 0th Index to midPoint
        add(word.substring(0, midPoint));
        /////now search for other half in tries.
        if (search(new StringBuffer(word.substring(word.length() - midPoint)).reverse().toString())) return true;
        else { ///////else add the complete word in tries in both default & reverse ordering.
            add(word);
            add(new StringBuffer(word).reverse().toString());
        }

        return false;
    }
    private boolean checkInReverseOneByOne(String word) {
        final String reveredWord = new StringBuffer(word).reverse().toString();
        ////////check from reversed word by iteration from length-1.
        for (int i = reveredWord.length()-1; i >1 ; i--) {
            //////check if the
            if(search(reveredWord.substring(0, i))) return true;
            else continue;
        }

        return false;
    }
}