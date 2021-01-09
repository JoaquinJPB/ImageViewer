package pkg_imageviewer_mvc.apps.mockapp.swing;

import pkg_imageviewer_mvc.control.Command;
import pkg_imageviewer_mvc.control.NextImageCommand;
import pkg_imageviewer_mvc.control.PrevImageCommand;
import pkg_imageviewer_mvc.model.Image;
import pkg_imageviewer_mvc.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JFrame {

    private List<Image> images;
    private ImageDisplay imageDisplay;
    private Map<String, Command> commands = new HashMap<>();

    public static void main (String[] args){
        new Main().execute();
    }

    public Main(){
        this.setTitle("Image Viewer");
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(imagePanel());
        this.add(toolbar(),BorderLayout.SOUTH);
    }

    private JMenuBar toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.add(button("<"));
        toolbar.add(button(">"));
        return toolbar;
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
        });
        return button;
    }

    private void execute() {
        this.images = new FileImageLoader(new File("photos")).load();
        this.imageDisplay.display(images.get(0));
        this.commands.put("<",new PrevImageCommand(images, imageDisplay));
        this.commands.put(">",new NextImageCommand(images, imageDisplay));
        ;
        this.setVisible(true);
    }

    private JPanel imagePanel() {
        BlockPanel blockPanel = new BlockPanel();
        this.imageDisplay = blockPanel;
        return blockPanel;
    }

}
