package pkg_imageviewer_mvp.apps;

import pkg_imageviewer_mvp.model.Image;
import pkg_imageviewer_mvp.view.ImageDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImagePanel extends JPanel implements ImageDisplay {

    private Image image;
    private Image image2;
    private Shift shift;
    private int x;

    public ImagePanel() {
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    @Override
    public void paint(Graphics g){
        if (this.image == null) return;
        BufferedImage image = load(this.image);
        g.drawImage(image, x, 0,null);
        if (x == 0) return;
        BufferedImage image2 = load(this.image2);
        int offset = x > 0 ? -(image2.getWidth()-x) : x+image.getWidth();
        g.drawImage(image2,offset , 0, null);
    }

    private BufferedImage load(Image image) {
        try{
            return ImageIO.read(new File(image.name()));
        }catch (IOException ex){
            Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void display(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public Image image() {
        return this.image;
    }

    @Override
    public void on(Shift shift) {
        this.shift = shift;
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {
        private int initial;

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.initial = e.getX();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (Math.abs(e.getX() - initial) > getWidth() / 2)  image = image2;
            x = 0;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX() - initial;
            repaint();
            if (x > 0) image2 = shift.right();
            if (x < 0) image2 = shift.left();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
