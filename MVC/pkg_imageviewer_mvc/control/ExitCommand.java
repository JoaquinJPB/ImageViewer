package pkg_imageviewer_mvc.control;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
