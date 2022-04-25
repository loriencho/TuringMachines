import java.util.HashMap;
public class Tape{
    public HashMap<Integer, Character> tape;
    private int pos = 0;
    private int startPos = 0;

    public Tape(String input){
        HashMap<Integer, Character> tape = new HashMap<Integer, Character>();
        for(char ch : input.toCharArray()){
            tape.put(pos, ch);
            pos++;
        } 
    }

    public char read(){
        return tape.get(pos);
    }

    public void moveLeft(){
        if (pos == 0)
            startPos = pos;
        pos--;
    }

    public void moveRight(){
        pos++;
    }

    public String getOutputString(){
        String str = "";
        int count = 0;
        int i = startPos;
        for(int j = 0; j< tape.size(); j++){
            char current = tape.get(i);
            str += current;
            
            if (current == '1') count++;
        }

        String output = "Final Tape: " + str + "\n # of 1s: " + count;
        return output;
    }
}