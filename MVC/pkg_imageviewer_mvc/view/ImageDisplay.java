package pkg_imageviewer_mvc.view;

import pkg_imageviewer_mvc.model.Image;

public interface ImageDisplay {
    void display(Image image);
    Image getImage();
}
