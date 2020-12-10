package control;

import model.Image;
import view.ImageDisplay;

import java.util.List;

public class PrevImageCommand implements Command {
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public PrevImageCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute(){
        imageDisplay.display(prev());
    }

    private Image prev() {
        return images.get(prev(getIndex()));
    }
    private int prev(int index) {
        return (index - 1 + images.size()) % images.size();
    }
    private int getIndex() {
        return images.indexOf(imageDisplay.getImage());
    }
}
