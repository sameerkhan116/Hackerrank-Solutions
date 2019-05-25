import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        public int size;

        public void putIfChildAbsent(char ch) {
            children.putIfAbsent(ch, new TrieNode());
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }
    } 

    static class Trie {
        TrieNode root = new TrieNode();

        public void add(String s) {
            TrieNode curr = root;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                curr.putIfChildAbsent(ch);
                curr = curr.getChild(ch);
                curr.size++;
            }
        }

        public int find(String s) {
            TrieNode curr = root;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                curr = curr.getChild(ch);
                if(curr == null) return 0;
            }
            return curr.size;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Trie trie = new Trie();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");
            if(opContact[0].equals("add")) {
                trie.add(opContact[1]);
            }
            else if(opContact[0].equals("find")) {
                bufferedWriter.write(String.valueOf(trie.find(opContact[1])));
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.close();
        scanner.close();
    }
}
