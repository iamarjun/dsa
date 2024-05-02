package strings;

public class ReverseWordsInASentence {

    public static void main(String[] args) {

        String a = "Today is a good day";
        reverseWords(a);
        var b = reverseRecursive(a);
        System.out.println(b);
    }

    private static String reverseWords(String s) {
        String a = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                temp = temp + s.charAt(i);
            } else {
                a = temp + s.charAt(i) + a;
                temp = "";
            }
        }
        return a;
    }

    private static String reverseRecursive(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int i = s.indexOf(' ');
        if (i == -1) {
            return s;
        }
        var ww = s.substring(0, i);
        var w = reverseRecursive(s.substring(i + 1, s.length()));
        return w + " " + ww;
    }
}
