public class Transition {
    private char tapeSymbol;
    private String nextState;
    private char writeChar;
    private char direction;

    public Transition(char tapeSymbol, String nextState, char writeChar, char direction){
        this.tapeSymbol = tapeSymbol;
        this.nextState = nextState;
        this.writeChar = writeChar;
        this.direction = direction; 
    }

    public char getTapeSymbol() {
        return tapeSymbol;
    }

    public String getNextState() {
        return nextState;
    }

    public char getWriteChar() {
        return writeChar;
    }

    public char getDirection() {
        return direction;
    }
    
}
