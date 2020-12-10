package apps.mockapp;

import model.Image;
import view.ImageDisplay;

public class MockImageDisplay implements ImageDisplay {

    private Image image;

    @Override
    public void display(Image image) {
        this.image = image;
        System.out.println(image.getName());
    }

    @Override
    public Image getImage() {
        return null;
    }

}
