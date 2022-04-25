import java.util.HashMap;
public class TuringMachine {
    public static void main(String[] args) {
        HashMap<String, State> states = new HashMap<String, State>();

        Transition t1 = new Transition('0', '0', "s1", '0', 'R');
        String name = "s0";
        // CREATE STATE
        states.put("s0", state);

        String input = "";
        StateMachine stateMachine =  new StateMachine();
        Tape tape = new Tape(input);

        while (!stateMachine.getCurrentState().isTerminalState()){
            if (stateMachine.nextStep(tape.read()) == 'R'){
                tape.moveRight();}
            else {
                tape.moveLeft();}
        }
        
        tape.getOutputString();
    }    
}


