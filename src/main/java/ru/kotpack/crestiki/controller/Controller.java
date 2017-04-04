package ru.kotpack.crestiki.controller;



import ru.kotpack.crestiki.model.Cletka;
import ru.kotpack.crestiki.model.Model;
import ru.kotpack.crestiki.view.View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


/**
 * Created by kot on 03.04.17.
 */
public class Controller extends MouseAdapter {

    private View view;
    private Model model;


    public void reload(){
        model.reload();
    }

    public Controller(Model model) {
        this.model=model;
        this.view=new View(this);

    }

    public View getView() {
        return view;
    }

    public List<Cletka> getAllCells(){
        return model.getAllCells();
    }
//    public List<Cletka> getFreeCells(){return model.getFreeCell();}



    @Override
    public void mouseClicked(MouseEvent e) {

if(model.isGameEnd()==false) {

    int x = e.getX();
    int y = e.getY();
    List<Cletka> cells = getAllCells();
    for (Cletka cletka : cells) {



        int cellX = cletka.getX();
        int cellY = cletka.getY();

        if (x > cellX && x < cellX + 100) {

            if (y > cellY && y < cellY + 100) {
                if (cletka.getZnachenie() == null) {

                    cletka.setZnachenie("x");
                }

                else {
                    mouseClicked(e);
                }


            }
        }
    }
    reaint();
    view.repaint();

    if (view.isGameEnd()) {
        JOptionPane.showMessageDialog(view, "the game is end");
    } else {
        model.hodCompa();
        reaint();
        view.repaint();
        if (view.isGameEnd()) {
            JOptionPane.showMessageDialog(view, "the game is end");
        }
    }

}







    }

    private void reaint(){
        if(model.isGameEnd()){
            view.setGameEnd(true);
        }

//        view.repaint();
    }


}
