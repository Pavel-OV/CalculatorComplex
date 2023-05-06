package calculator.actionLog;

import java.util.Stack;

public class Log {
    Stack<String> log;
    public Log() {
        this.log = new Stack<String>();
    }

    public void add(String comment){
        log.add(comment);
    }

    public String out(){
        StringBuilder lst = new StringBuilder();
        for (String comment:log) {
            lst
                    .append(comment)
                    .append("\n");
        }
        return lst.toString();
    }
}
