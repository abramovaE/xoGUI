package ru.kotpack.crestiki.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kot on 03.04.17.
 */
public class Model {

    private Cletka[][] pole;
    public Model(){
        reload();
    }


    public void reload(){
        this.pole = new Cletka[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cletka cletka =new Cletka();
                cletka.setY(j*100);
                cletka.setX(i*100);
                pole[i][j] = cletka;

            }
        }
    }


    public boolean isGameEnd() {
        List<Cletka> freeCells = getFreeCell();
        if(freeCells.isEmpty()){
            return true;
        }

        else {
            String winConditionO = "ooo";
            String winConditionX = "xxx";

            StringBuilder diag1 = new StringBuilder();
            StringBuilder diag2 = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                StringBuilder hor = new StringBuilder();
                StringBuilder vert = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    hor.append(pole[i][j].getZnachenie());
                    vert.append(pole[j][i].getZnachenie());
                    if (i == j) {
                        diag1.append(pole[i][j].getZnachenie());
                    }

                    if (i + j == 2 || Math.abs(i - j) == 2) {
                        diag2.append(pole[i][j].getZnachenie());
                    }
                }

                List<String> listSb = new ArrayList<String>();
                listSb.add(hor.toString());
                listSb.add(vert.toString());
                listSb.add(diag1.toString());
                listSb.add(diag2.toString());

                if(listSb.contains(winConditionO) || listSb.contains(winConditionX)){
                    return true;
                }
            }
        }
        return false;
    }


    public List<Cletka> getFreeCell(){
        List<Cletka> res = new ArrayList<Cletka>();
        for(int i = 0; i<3 ; i++){
            for(int j = 0; j<3; j++){
                if(pole[i][j].getZnachenie()==null){
                    res.add(pole[i][j]);
                }
            }
        }
        return res;
    }


    public   List<Cletka> getAllCells(){
        List<Cletka> res = new ArrayList<Cletka>();
        for(int i = 0; i<3 ; i++){
            for(int j = 0; j<3; j++){
                    res.add(pole[i][j]);

            }
        }
        return res;
    }




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
}
