package nl.schoonewille.utils.menu;

import nl.schoonewille.interfaces.FunctionCaller;

public class MenuItem {
    private char key;
    private String display;
    private FunctionCaller function;

    public MenuItem(char key, String display, FunctionCaller function) {
        this.key = key;
        this.display = key + " - " + display;
        this.function = function;
    }

    public char getKey() {
        return key;
    }

    public String getDisplay() {
        return display;
    }

    public void execute() {
        function.execute();
    }
}
