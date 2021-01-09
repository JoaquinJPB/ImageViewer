package pkg_imageviewer_mvp.view;

import pkg_imageviewer_mvp.model.Image;

public interface ImageDisplay {
    void display(Image image);
    Image image();
    void on(Shift shift);

    interface Shift {
        Image left();
        Image right();
    }
}
