package exceptions;

public class NoEmptySlotException extends Exception{
    public NoEmptySlotException() {
        super("No empty slot!");
    }
}
