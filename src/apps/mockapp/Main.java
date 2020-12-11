package apps.mockapp;

import control.*;
import model.Image;


import java.util.*;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final Command NullCommand = new Command.Null();
    private final Map<String, Command> commands;

    public static void main(String[] args) { new Main().execute(); }

    public Main() {
        InitCommand init = new InitCommand(loadImages(), createImageDisplay());
        init.execute();
        commands = init.getCommands();
    }

    private MockImageDisplay createImageDisplay() { return new MockImageDisplay(); }

    private List <Image> loadImages() { return new MockImageLoader().load(); }

    private void execute() { while (true) commands.getOrDefault(input(), NullCommand).execute(); }

    private String input() { return scanner.next().toUpperCase(); }

}
