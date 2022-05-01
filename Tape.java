import java.util.HashMap;
public class Tape{
    private HashMap<Integer, Character> tape;
    private int pos = 0;
    private int startPos = 0; 
    private int endPos = 0; 

    public int getPos(){
        return pos;
    }
    public int getStartPos(){
        return startPos;
    }

    public int getEndPos(){
        return endPos;
    }

    public Tape(String input){
        HashMap<Integer, Character> tape = new HashMap<Integer, Character>();
        for(char ch : input.toCharArray()){
            tape.put(pos, ch);
            pos++;
            endPos++;
        } 
        pos = 0;
        this.tape = tape;
    }

    public char read(){
        return tape.get(pos);
    }

    public void write(char ch){
        tape.put(pos, ch);
    }

    public void moveLeft(){
        pos--;
        if (pos < startPos){
            write('$');
            startPos--;
        }
    }

    public void moveRight(){
        pos++;
        if (pos == endPos){
            write('$');
            endPos++;
        }
    }

    public String toString(){
        return tape.toString();
    }
    public String getOutputString(){
        String str = "";
        int count = 0;
        for(int j = startPos; j< endPos; j++){
            char current = tape.get(j);
            str += current;
        }
        String output = "Final Tape: " + str + "\n# of 1s: " + count1s();
        return output;
    }

    public int count1s(){
        int count = 0;
        for(int i = startPos; i<endPos; i++){
            if (tape.get(i) == '1')
                count++;
        }
        return count;
    }
}