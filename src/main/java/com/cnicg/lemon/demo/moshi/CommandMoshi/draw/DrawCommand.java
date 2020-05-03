package com.cnicg.lemon.demo.moshi.CommandMoshi.draw;

import com.cnicg.lemon.demo.moshi.CommandMoshi.command.Command;

import java.awt.*;

public class DrawCommand implements Command {

    protected Drawable drawable;
    private Point point;

    @Override
    public void execute() {
        drawable.draw(point.x, point.y);
    }

    public DrawCommand(Drawable drawable, Point point){
        this.drawable = drawable;
        this.point = point;
    }
}
