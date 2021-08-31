package org.datastructure.java.tries.triesImplementation;

public class TrieNode {
    char data;
    int dec;
    boolean isTerminal;
    TrieNode children[];

    public TrieNode(char data, int dec) {
        this.data = data;
        this.dec = dec;
        this.isTerminal = false;
        this.children = new TrieNode[127-31]; ////allow(s) to include only chars from DEC 32 to 127.
                                              ////REFER: ASCII.pdf in this directory location
    }
}
