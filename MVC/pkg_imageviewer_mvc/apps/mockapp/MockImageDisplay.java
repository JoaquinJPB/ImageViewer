package pkg_imageviewer_mvc.apps.mockapp;

import pkg_imageviewer_mvc.model.Image;
import pkg_imageviewer_mvc.view.ImageDisplay;

public class MockImageDisplay implements ImageDisplay {

    private Image image;

    @Override
    public void display(Image image) {
        this.image = image;
        System.out.println(image.getName());
    }

    @Override
    public Image getImage() { return null; }

}
