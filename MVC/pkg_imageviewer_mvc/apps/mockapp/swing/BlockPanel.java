package pkg_imageviewer_mvc.apps.mockapp.swing;

import pkg_imageviewer_mvc.model.Image;
import pkg_imageviewer_mvc.view.ImageDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BlockPanel extends JPanel implements ImageDisplay {

    private pkg_imageviewer_mvc.model.Image image;
    private BufferedImage bufferedImage;

    public BlockPanel(){}

     @Override
    public void paint(Graphics g){
        Box box = new Box(bufferedImage);
        g.drawImage(bufferedImage, box.x, box.y, box.width, box.height, null);
     }

    private BufferedImage load(String name) {
        try {
            return ImageIO.read(new File(name));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void display(pkg_imageviewer_mvc.model.Image image) {
        this.image = image;
        this.bufferedImage = load(image.getName());
        repaint();
    }

    @Override
    public Image getImage() {
        return image;
    }

    private class Box {
        final int x;
        final int y;
        final int width;
        final int height;
        private final int px;
        private final int py;

        public Box(BufferedImage image) {
            this.px = getWidth();
            this.py = getHeight();
            this.width = calculateWidth(image.getWidth(), image.getHeight());
            this.height = calculateHeight(image.getWidth(),image.getHeight());
            this.x = (px - width)/2;
            this.y = (py - height)/2;
        }

        private int calculateWidth(double ix, double iy) {
            double pr = (double) px / py;
            double ir = ix / iy;
            return ir > pr ? px : (int) (ix * py /iy);
        }

        private int calculateHeight(double ix, double iy) {
            double pr = (double) px / py;
            double ir = ix / iy;
            return ir > pr ? (int) (iy * px /ix) : py;
        }
    }
}
