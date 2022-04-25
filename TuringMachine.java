import java.util.ArrayList;
public class TuringMachine {
    public static void main(String[] args) {
        ArrayList<State> states = new ArrayList<State>();
        String input = "";
        StateMachine stateMachine =  new StateMachine();
        Tape tape = new Tape(input);

        while (!stateMachine.currentState.isTerminalState()){
            if (stateMachine.move(tape.read()).equals("right")){
                tape.moveRight();}
            else {
                tape.moveLeft();}
        }
        
        tape.getOutputString();
    }    
}
