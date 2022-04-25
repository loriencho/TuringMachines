import java.util.ArrayList;
public class TuringMachine {
    public static void main(String[] args) {
        ArrayList<State> states = new ArrayList<State>();
        states.add(
            new State("s0", new Transition[0], true));
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
