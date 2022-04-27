import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TuringMachine {

    public static void main(String[] args) throws IOException{

        // file input STILL WIP!
        String file = "tm1.txt";
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null){
            lines.add(line);}

        int i = 0;

        reader.close();

        // hardcoded machine - works fine
        HashMap<String, State> states = new HashMap<String, State>();
        Transition[] t1 = {
            new Transition('0', "s1", '0', 'R')};
        State s0 = new State("s0", t1, false);
        states.put("s0", s0);


        Transition[] t2 = {};
        State s1 = new State("s1", t2, true);
        states.put("s1", s1);
        String input = "00";
        StateMachine stateMachine =  new StateMachine(s0, states);
        Tape tape = new Tape(input);

        // run machine
        while (!stateMachine.getCurrentState().isTerminalState()){
            if (stateMachine.nextStep(tape.read()) == 'R'){
                tape.moveRight();}
            else {
                tape.moveLeft();}
        }
        
        System.out.println(tape.getOutputString());
    }    
}


