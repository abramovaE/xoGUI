package ru.kotpack.crestiki;

import ru.kotpack.crestiki.controller.Controller;
import ru.kotpack.crestiki.model.Model;

import javax.swing.*;
import java.awt.*;

public class MainClass {

    public static void main(String[] args) {





        Model model = new Model();
        Controller controller = new Controller(model);

        JFrame frame = new JFrame();

        frame.setTitle("Krestiki-noliki");
        frame.setSize(307,330);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(controller.getView());
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
