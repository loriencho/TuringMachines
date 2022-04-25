import java.util.ArrayList;
public class Tape{
    public ArrayList<Character> tape;
    private int pos = 0;

    public Tape(String input){
        ArrayList<Character> tape = new ArrayList<Character>();
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
        tape.add(null);
        pos++;
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