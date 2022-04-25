public class State{
    private String name;
    private Transition[] transitions;
    private boolean isTerminalState;

    public State(String name, Transition[] transitions, boolean isTerminalState)
        {
            this.name = name;
            this.transitions = transitions;
            this.isTerminalState = isTerminalState;
    }

    public String getName() {
        return name;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    public boolean isTerminalState() {
        return isTerminalState;
    }