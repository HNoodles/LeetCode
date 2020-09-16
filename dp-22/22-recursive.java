import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answers = new ArrayList<>();

        // first must be left parenthesis
        gen(answers, 1, n - 1, "(");

        return answers;
    }

    private void gen(List<String> answers, int left, int n, String ans) {
        // boundary condition, no remaining left parenthesis, no remaining n
        if (left == 0 && n == 0) {
            answers.add(ans);
            return;
        }

        // no dangling left parenthesis that have already been output
        // output a new left parenthesis
        if (left == 0) {
            gen(answers, left + 1, n - 1, ans + "(");
            return;
        }

        // can only output right parenthesis
        if (n == 0) {
            gen(answers, left - 1, n, ans + ")");
            return;
        }

        // can either have left or right parenthesis
        gen(answers, left + 1, n - 1, ans + "("); // left
        gen(answers, left - 1, n, ans + ")"); // right
        return;
    }
}