package com.cnicg.lemon.demo.moshi.CommandMoshi.command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
    private Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()){
            iterator.next().execute();
        }
    }

    public void append(Command command){
        if(command != this){
            commands.push(command);
        }
    }

    public void undo(){
        if(!commands.isEmpty()){
            commands.pop();
        }
    }

    public void clear(){
        commands.clear();
    }

}

