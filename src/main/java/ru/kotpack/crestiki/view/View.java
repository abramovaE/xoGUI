package ru.kotpack.crestiki.view;

import ru.kotpack.crestiki.model.Cletka;
import ru.kotpack.crestiki.controller.Controller;

import javax.swing.*;
import java.awt.*;


/**
 * Created by kot on 03.04.17.
 */
public class View extends JPanel{

    private Controller controller;
    boolean isGameEnd;

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        isGameEnd = gameEnd;
    }

    public View(Controller controller){
        setFocusable(true);
        this.controller=controller;
        addMouseListener(controller);
    }



    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);

        for(Cletka cletka: controller.getAllCells()){
            drawCletka(graphics, cletka);
        }

//
//        if (isGameEnd) {
//            JOptionPane.showMessageDialog(this, "game is end");
////            switch (result){
////                case JOptionPane.YES_OPTION:controller.reload();break;
////                case JOptionPane.NO_OPTION:break;
////
////            }

//        }
    }

    public void drawCletka(Graphics graphics, Cletka cletka){

        graphics.drawRect(cletka.getX(),cletka.getY(),98,98);
        graphics.fillRect(cletka.getX(),cletka.getY(),98,98);

        if(cletka.getZnachenie()!=null) {
            Color color = graphics.getColor();
            graphics.setColor(Color.GREEN);
            graphics.drawString(cletka.getZnachenie(), (cletka.getX()+50), (cletka.getY()+50));
            graphics.setColor(color);
        }

//        if(cletka.getZnachenie().equals("x")){
//
//            Im
//            graphics.drawImage()
//        }
    }
}
