package pkg_imageviewer_mvp.apps;

import pkg_imageviewer_mvp.control.ImagePresenter;
import pkg_imageviewer_mvp.model.Image;
import pkg_imageviewer_mvp.view.ImageDisplay;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    private ImageDisplay imageDisplay;
    private ImagePresenter imagePresenter;

    public static void main(String[] args){
        new Main().execute();
    }

    public Main(){
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);

        List<Image> list = new ArrayList<>();
        list.add(new Image("photos/fondo1.png"));
        list.add(new Image("photos/fondo2.png"));
        list.add(new Image("photos/fondo3.png"));

        this.getContentPane().add(createImagePanel());

        this.imageDisplay.display(list.get(0));
        this.imagePresenter = new ImagePresenter(list, imageDisplay);
    }

    private JPanel createImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;
    }

    private void execute() {
        this.setVisible(true);
    }
}
