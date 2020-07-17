import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> answers = new ArrayList<>();

        int count = 0; // used to store the state of letter counts
        int[] states = new int[s.length()]; // use to store the state of every bit of string s

        // build up states
        for (int i = 0; i < s.length(); i++) {
            // bit xor to store the odd/even information
            count ^= (1 << ((char)s.charAt(i) - 'a'));
            states[i] = count;
        }

        // go through queries to find answers
        for (int i = 0; i < queries.length; i++) {
            // string starts from, end with
            int sstate = queries[i][0] == 0 ? 0 : states[queries[i][0] - 1];
            int estate = states[queries[i][1]];
            
            // use bit xor to get the odd and even status in the string
            int state = sstate ^ estate;

            // count odds
            int odds = 0;
            while (state != 0) {
                if ((state & 0x1) > 0) {
                    odds++;
                }
                state >>= 1;
            }

            answers.add((odds / 2) <= queries[i][2]);
        }

        return answers;
    }
}