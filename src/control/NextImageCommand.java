package control;

import model.Image;
import view.ImageDisplay;

import java.util.List;

public class NextImageCommand implements Command {
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public NextImageCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute(){
        imageDisplay.display(next());
    }

    private Image next() {
        return images.get(next(getIndex()));
    }
    private int next(int index) {
        return (index+1) % images.size();
    }
    private int getIndex() {
        return images.indexOf(imageDisplay.getImage());
    }
}

