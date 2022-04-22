import java.util.Deque;
import java.util.ArrayDeque;
public class Tape{
    public Deque<Character> tape;
    private int pos = 0;

    public Tape(String input){
        Deque<Character> tape = new ArrayDeque<Character>();
        for(char ch : input.toCharArray()){
            tape.add(ch);
        } 
    }

    public void goLeft(){
        if (pos == 0)
            tape.addFirst(null);
        else pos--;
    }

    public void goRight(){
        if (pos == (tape.size() - 1))
            tape.addLast(null);
            else pos++;
    }

    public String getOutputString(){
        String str = "";
        int count = 0;
        for(int i = 0; i< tape.size(); i++){
            char current = tape.removeFirst();
            str += current;
            
            if (current == '1') count++;
        }

        String output = "Final Tape: " + str + "\n # of 1s: " + count;
        return output;
    }
}