package control;

import model.Image;
import view.ImageDisplay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitCommand implements Command {
    private final ImageDisplay imageDisplay;
    private final List <Image> images;
    private final Map<String, Command> commands;

    public InitCommand(List <Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
        this.commands = new HashMap();
    }

    public Map <String, Command> getCommands() {
        return commands;
    }

    @Override
    public void execute() {
        imageDisplay.display(images.get(0));
        createCommands();
    }

    private void createCommands() {
        commands.put("N", new NextImageCommand(images, imageDisplay));
        commands.put("P", new PrevImageCommand(images, imageDisplay));
        commands.put("Q", new ExitCommand());
    }
}