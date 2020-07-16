class Solution {
    public String complexNumberMultiply(String a, String b) {
        // (m + ni) * (o + pi)
        int[] aNumbers = parseString(a);
        int[] bNumbers = parseString(b);

        int first = aNumbers[0] * bNumbers[0] - aNumbers[1] * bNumbers[1];
        int second = aNumbers[0] * bNumbers[1] + aNumbers[1] * bNumbers[0];

        return first + "+" + second + "i";
    }

    private int[] parseString(String expression) {
        int[] numbers = new int[2];

        // when you want to split +, you should use \\+ because + is a keyword
        String[] expressions = expression.split("\\+"); 
        
        numbers[0] = Integer.parseInt(expressions[0]);
        numbers[1] = Integer.parseInt(expressions[1].split("i")[0]);

        return numbers;
    }
}