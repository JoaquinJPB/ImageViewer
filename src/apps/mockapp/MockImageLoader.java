package apps.mockapp;

import model.Image;
import view.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MockImageLoader implements ImageLoader {
    @Override
    public List<Image> load() {
        List<Image> list = new ArrayList<>();
        list.add(new Image("Hola"));
        list.add(new Image("mundo"));
        list.add(new Image("Bienvenido"));
        return list;
    }
}
