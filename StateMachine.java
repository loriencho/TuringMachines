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

    public char nextStep(char input){
        Transition transition = nextTransition(input);
        currentState = nextState(transition);
        return transition.getDirection();
    }

    private Transition nextTransition(char input) {
        Transition[] currentTransitions = currentState.getTransitions();
        Transition nextTransition = null;
        for (int i = 0; i < currentTransitions.length; i++){
            if (input == currentTransitions[i].getTapeSymbol())
                nextTransition = currentTransitions[i];
        }
        return nextTransition;
    }

    private State nextState(Transition transition){
        if (transition == null){
            currentState.setTerminalState(true);
            return currentState;
        }
        else { 
            return getState(transition.getNextState());
        }
    }
}