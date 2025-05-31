import java.util.*;
class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;
    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
class HuffmanCoding {
    static class NodeComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode n1, HuffmanNode n2) {
            return n1.freq - n2.freq;
        }
    }
    static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodeMap) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            huffmanCodeMap.put(root.ch, code);
            return;
        }
        generateCodes(root.left, code + "0", huffmanCodeMap);
        generateCodes(root.right, code + "1", huffmanCodeMap);
    }
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        int[] freq = {3, 4, 2, 1};
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new NodeComparator());
        for (int i = 0; i < chars.length; i++) {
            pq.add(new HuffmanNode(chars[i], freq[i]));
        }
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode merged = new HuffmanNode('-', left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            pq.add(merged);
        }
        HuffmanNode root = pq.poll();

        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
