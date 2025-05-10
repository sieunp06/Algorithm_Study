import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<Node> nodes = new ArrayList<>();
        for (String file : files) {
            nodes.add(separate(file));
        }
        
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                int headCompare = n1.head.toLowerCase().compareTo(n2.head.toLowerCase());
                if (headCompare != 0) return headCompare;
                return Integer.compare(n1.number, n2.number);
            }
        });
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = nodes.get(i).original;
        }

        return answer;
    }
    
    private Node separate(String text) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        
        int i = 0;
        while (i < text.length() && !Character.isDigit(text.charAt(i))) {
            head.append(text.charAt(i));
            i++;
        }

        while (i < text.length() && Character.isDigit(text.charAt(i)) && number.length() < 5) {
            number.append(text.charAt(i));
            i++;
        }
        
        return new Node(head.toString(), Integer.parseInt(number.toString()), text);
    }
}

class Node {
    String head, original;
    int number;
    
    Node(String head, int number, String original) {
        this.head = head;
        this.number = number;
        this.original = original;
    }
}