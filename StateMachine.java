import java.util.HashMap;
public class StateMachine {
    private State currentState; 
    private HashMap<String, State> states; 

    public StateMachine(String currentState, HashMap<String, State> states){
        this.currentState = states.get(currentState);
        this.states = states;
    }

    public State getCurrentState() {
        return currentState; 
    }

    public void addState(String name, State state){
        states.put(name, state);
    }

    public State getState(String name){
        if (name == null)
            return null; 
        return states.get(name);
    }

    public void nextStep(char input, Tape tape){
        Transition transition = nextTransition(input, tape);
        currentState = nextState(transition);
    }

    public Transition nextTransition(char input, Tape tape) {
        Transition[] currentTransitions = currentState.getTransitions();

        // find transition that matches input character
        for (int i = 0; i < currentTransitions.length; i++){
            if (input == currentTransitions[i].getTapeSymbol()){
                if(input == '$' 
                    && currentTransitions[i].getDirection() == 'R') {
                        return currentTransitions[i];
                    }
                else if(input == '$' 
                    && currentTransitions[i].getDirection() == 'L') { 
                    return currentTransitions[i];
                }
                return currentTransitions[i];}
        }
        return null;
    }

    public State nextState(Transition transition){
        return getState(transition.getNextState());
    }
}