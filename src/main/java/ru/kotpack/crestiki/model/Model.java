package ru.kotpack.crestiki.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kot on 03.04.17.
 */
public class Model {

    private Cletka[][] pole;

    private static final String WIN_O = "ooo";
    private static final String WIN_X = "xxx";
    private static final int RAZMER = 3;

    private boolean wasChanged;

    public boolean isWasChanged() {
        return wasChanged;
    }

    public Model(){
        this.pole = new Cletka[RAZMER][RAZMER];
        for (int i = 0; i < RAZMER; i++) {
            for (int j = 0; j < RAZMER; j++) {
                Cletka cletka =new Cletka();
                cletka.setY(j*100);
                cletka.setX(i*100);
                pole[i][j] = cletka;

            }
        }
    }


    public Cletka[][] getPole() {
        return pole;
    }

    public void reload(){
        for (int i = 0; i < RAZMER; i++) {
            for (int j = 0; j < RAZMER; j++) {
                pole[i][j].setZnachenie(null);
            }
        }
    }


    public boolean isGameEnd() {


//        List<Cletka> freeCells = getFreeCell();
        if(getFreeCell().isEmpty()){
            return true;
        }

        else {
            List<String> listSb = new ArrayList<String>();
            StringBuilder diag1 = new StringBuilder();
            StringBuilder diag2 = new StringBuilder();

            for (int i = 0; i < RAZMER; i++) {
                StringBuilder hor = new StringBuilder();
                StringBuilder vert = new StringBuilder();
                for (int j = 0; j < RAZMER; j++) {
                    hor.append(pole[i][j].getZnachenie());
                    vert.append(pole[j][i].getZnachenie());
                    if (i == j) {
                        diag1.append(pole[i][j].getZnachenie());
                    }

                    if (i + j == RAZMER-1 || Math.abs(i - j) == RAZMER-1) {
                        diag2.append(pole[i][j].getZnachenie());
                    }
                }


                listSb.add(hor.toString());
                listSb.add(vert.toString());
            }
                listSb.add(diag1.toString());
                listSb.add(diag2.toString());

                if(listSb.contains(WIN_O) || listSb.contains(WIN_X)){
                    return true;
                }

        }
        return false;
    }


    public List<Cletka> getFreeCell(){
        List<Cletka> res = new ArrayList<Cletka>();
//        List<Cletka> allCells = getAllCells();
//        for(Cletka cletka:allCells){
//            if(cletka.getZnachenie()==null){
//                res.add(cletka);
//            }
//        }
        for(int i = 0; i<RAZMER ; i++){
            for(int j = 0; j<RAZMER; j++){
                if(pole[i][j].getZnachenie()==null){
                    res.add(pole[i][j]);
                }
            }
        }
        return res;
    }


//    public   List<Cletka> getAllCels(){
//        List<Cletka> res = new ArrayList<Cletka>();
//        for(int i = 0; i<3 ; i++){
//            for(int j = 0; j<3; j++){
//                    res.add(pole[i][j]);
//
//            }
//        }
//        return res;
//    }




    public void hodCompa(){


        List<Cletka> freeCell = getFreeCell();
            int computerAnswer = getRandomFreeCell(freeCell);
            Cletka cletka = freeCell.get(computerAnswer);
            cletka.setZnachenie("o");
            freeCell.set(computerAnswer, cletka);

    }



    public static int getRandomFreeCell(List<Cletka> list){
        int res = (int) (Math.random()*list.size());
        return res;
    }

    public void hodIgroka(int x, int y) {

        if(!isGameEnd()) {
            for(int i=0; i<RAZMER; i++){
                for(int j=0; j<RAZMER; j++){

                    Cletka cletka = pole[i][j];
                    int cellX = cletka.getX();
                    int cellY = cletka.getY();
                    if (x > cellX && x < cellX + 100) {

                        if (y > cellY && y < cellY + 100) {
                            if (cletka.getZnachenie()==null) {
                                cletka.setZnachenie("x");
                                wasChanged=true;
                            }
                            else {
                                wasChanged=false;

                            }
                        }
                    }

                }
            }
        }
    }




}
