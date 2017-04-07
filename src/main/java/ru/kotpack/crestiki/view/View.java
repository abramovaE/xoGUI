package ru.kotpack.crestiki.view;

import ru.kotpack.crestiki.model.Cletka;
import ru.kotpack.crestiki.controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by kot on 03.04.17.
 */
public class View extends JPanel{

    private Controller controller;
    boolean isGameEnd;
    private BufferedImage bufferedImage;

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

        if(cletka.getZnachenie()!=null) {
            if (cletka.getZnachenie().equals("x")) {
                setImage(graphics,cletka, "/x.jpeg");
            }

            else if(cletka.getZnachenie().equals("o")){
                setImage(graphics, cletka, "/o.jpeg");
            }
        }

    }


    private void setImage(Graphics graphics, Cletka cletka, String filename){
        try {

            Image image = ImageIO.read(getClass().getResource(filename));
            graphics.drawImage(image, cletka.getX(), cletka.getY(), 98, 98, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
