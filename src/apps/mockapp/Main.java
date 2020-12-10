package apps.mockapp;

import control.*;
import model.Image;
import view.ImageDisplay;
import view.ImageLoader;

import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final Command NullCommand = new NullCommand();
    private final Map<String, Command> commands;


    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        InitCommand init = new InitCommand(loadImages(), createImageDisplay());
        init.execute();
        commands = init.getCommands();
    }

    private MockImageDisplay createImageDisplay() {
        return new Main.MockImageDisplay();
    }

    private List <Image> loadImages() {
        return new MockImageLoader().load();
    }

    private void execute() {
        while (true) commands.getOrDefault(input(), NullCommand).execute();
    }

    private String input() {
        return scanner.next().toUpperCase();
    }

    public static class MockImageDisplay implements ImageDisplay {
        private Image image;

        @Override
        public void display(Image image) {
            this.image = image;
            System.out.println(image.getName());
        }

        @Override
        public Image getImage() {
            return image;
        }
    }

    public static class MockImageLoader implements ImageLoader {
        @Override
        public List <Image> load() {
            List <Image> list = new ArrayList<>();
            list.add(new Image("Hola"));
            list.add(new Image("Mundo"));
            list.add(new Image ("Bienvenido"));
            return list;
        }
    }
}
