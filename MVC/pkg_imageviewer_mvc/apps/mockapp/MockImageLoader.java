package pkg_imageviewer_mvc.apps.mockapp;

import pkg_imageviewer_mvc.model.Image;
import pkg_imageviewer_mvc.view.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MockImageLoader implements ImageLoader {
    @Override
    public List<Image> load() {
        List<Image> list = new ArrayList<>();
        list.add(new Image("1"));
        list.add(new Image("2"));
        list.add(new Image("3"));
        return list;
    }
}
