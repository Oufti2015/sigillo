package sst.sigillo.model;

import lombok.Data;

@Data // NO_UCD (unused code)
public class Bookmark implements Comparable<Bookmark> {
    private String url;
    private String name;
    private Category category;
    private boolean important = false;

    public void setUrl(String url) {
	if (!url.startsWith("http") && !url.startsWith("file")) {
	    url = "http://" + url;
	}
	this.url = url;
    }

    public String getCategoryName() {
	return category.getName();
    }

    @Override
    public int compareTo(Bookmark o) {
	int compareTo = o.category.compareTo(category);
	if (0 == compareTo) {
	    compareTo = o.name.compareToIgnoreCase(name);
	}
	return compareTo;
    }
}
