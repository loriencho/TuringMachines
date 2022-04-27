import java.util.HashMap;
public class Tape{
    private HashMap<Integer, Character> tape;
    private int pos = 0;
    private int startPos = 0;

    public Tape(String input){
        HashMap<Integer, Character> tape = new HashMap<Integer, Character>();
        for(char ch : input.toCharArray()){
            tape.put(pos, ch);
            pos++;
        } 
        pos = 0;
        this.tape = tape;
    }

    public char read(){
        return tape.get(pos);
    }

    public char write(char ch){
        return tape.put(pos, ch);
    }

    public void moveLeft(){
        if (pos == 0)
            startPos = pos;
        pos--;
    }

    public void moveRight(){
        pos++;
    }

    public String toString(){
        return tape.toString();
    }
    public String getOutputString(){
        String str = "";
        int count = 0;
        int i = startPos;
        for(int j = 0; j< tape.size(); j++){
            char current = tape.get(i);
            str += current;
            if (current == '1') count++;
            i++;
        }

        String output = "Final Tape: " + str + "\n# of 1s: " + count;
        return output;
    }
}