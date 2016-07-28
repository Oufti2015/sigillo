package sst.sigillo.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class SigilloData {
    @Getter
    @Setter
    private String headerColor = "#000032";
    @Getter
    @Setter
    private String bookmarkColor = "#FFFF32";
    @Getter
    @Setter
    private ArrayList<Bookmark> bookmarksList = new ArrayList<>();
}
