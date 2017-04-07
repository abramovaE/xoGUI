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


            reaint();

            if (view.isGameEnd()) {
                gameEnd();
            } else {
                model.hodCompa();
                reaint();

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
