public class Transition {
    private char input;
    private char tapeSymbol;
    private String nextState;
    private char writeChar;
    private char direction;

    public Transition(char input, char tapeSymbol, String nextState, char writeChar, char direction){
        this.input = input;
        this.tapeSymbol = tapeSymbol;
        this.nextState = nextState;
        this.writeChar = writeChar;
        this.direction = direction; 
    }

    public char getInput() {
        return input;
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
