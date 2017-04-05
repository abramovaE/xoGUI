package ru.kotpack.crestiki.controller;



import ru.kotpack.crestiki.model.Cletka;
import ru.kotpack.crestiki.model.Model;
import ru.kotpack.crestiki.view.View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
        List<Cletka> list = new ArrayList<Cletka>();
        Cletka[][] cletkas = model.getPole();


        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {

                list.add(cletkas[i][j]);
            }
        }



        return list;
    }
//    public List<Cletka> getFreeCells(){return model.getFreeCell();}


    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicked(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        model.hodIgroka(x, y);


        if(model.isWasChanged()){




//
//if(model.isGameEnd()==false) {


//    List<Cletka> cells = getAllCells();
//    for (Cletka cletka : cells) {
//
//
//        int cellX = cletka.getX();
//        int cellY = cletka.getY();
//
//        if (x > cellX && x < cellX + 100) {
//
//            if (y > cellY && y < cellY + 100) {
//                if (cletka.getZnachenie().equals("-")) {
//
//                    cletka.setZnachenie("x");
//                } else {
//                    mouseClicked(e);
//                }
//
//
//            }
//        }
//    }
//}
            reaint();
//    view.repaint();

            if (view.isGameEnd()) {
                gameEnd();
            } else {
                model.hodCompa();
                reaint();
//        view.repaint();
                if (view.isGameEnd()) {
                    gameEnd();

                }
            }



        }





    }


    private void gameEnd(){
        int i = JOptionPane.showConfirmDialog(view, "the game is end. One more game?");
        if(i==JOptionPane.OK_OPTION){
            view.setGameEnd(false);
            model.reload();
            view.repaint();
        }
    }

    private void reaint(){
        if(model.isGameEnd()){
            view.setGameEnd(true);
        }

        view.repaint();
    }


}
