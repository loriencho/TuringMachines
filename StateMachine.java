public class StateMachine {
    private State currentState; 
    private State[] states; 

    public State getCurrentState() {
        return currentState; 
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
            if (input == currentTransitions[i].getInput())
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
            return transition.getNextState();
        }
    }

}