import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TuringMachine {

    public static void main(String[] args) throws IOException{
        HashMap<String, State> states = new HashMap<String, State>();

        // Get File Input

        //file--> String list
        String file = "tm2s4s.txt";
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null){
            lines.add(line);}


        // Parse Lines
        // initial guaranteed lines of information
        String input = lines.get(0);
        String initial_state = lines.get(1);
        int num_states = Integer.parseInt(lines.get(2));
        int line_pos = 3;

        //repeat for number of states
        for (int j=0; j < num_states; j++){
            line = lines.get(line_pos);
            line_pos++;

            // get information for state
            String[] line_parts = line.split(" ");
            String state_name = line_parts[0];
            int num_transitions = Integer.parseInt(line_parts[1]);
            
            
            Transition[] transitions = new Transition[num_transitions];
            // parse through each transition for state
            if(num_transitions > 0){
                for(int i = 0; i < transitions.length; i++){
                    line = lines.get(line_pos);
                    line_pos++;

                    line_parts = line.split(" ");
                    transitions[i] = new Transition(line_parts[0].charAt(0), line_parts[1], line_parts[2].charAt(0), line_parts[3].charAt(0));
                }
            }

            // create state, add to hashmap
            State state = new State(state_name, transitions, (num_transitions == 0)? true : false);
            states.put(state_name, state);
        }

        reader.close();

        // Assembling and running machine

        // create StateMachine, Tape - instanstiating parts
        StateMachine stateMachine =  new StateMachine(initial_state, states);
        Tape tape = new Tape(input);

        // run machine
        while (!stateMachine.getCurrentState().isTerminalState()){
            char read;

            if (tape.getEndPos() < tape.getPos()) {
                read = '$';
            }
            else if (tape.getStartPos() > tape.getPos()){
                read = '$';
            }
            else {
                read = tape.read();
            }

            Transition transition = stateMachine.nextTransition(read, tape);
        
            if (transition == null){ // no transition found
                System.out.println("No transition found from state " + stateMachine.getCurrentState().getName() + " with input " + read + " at position " + tape.getPos());
                break;
            }

            tape.write(transition.getWriteChar());

            //move 
            stateMachine.nextStep(read, tape); // change current state in statemachine
            if (transition.getDirection() == 'R'){ //move tape
                tape.moveRight();}
            else {
                tape.moveLeft();}



        }

        System.out.println(tape.getOutputString()); //end


    }    
}


