package sst.sigillo.model;

import lombok.Getter;

public class Category implements Comparable<Category> {
    @Getter
    private String name;

    // @Getter
    // private ArrayList<Bookmark> bookmarks = new ArrayList<>();

    Category(String name) {
	super();
	this.name = name;
    }

    // public int getBookmarksCount() {
    // return bookmarks.size();
    // }
    //
    // public void addBookmark(Bookmark bookmark) {
    // bookmarks.add(bookmark);
    // }

    @Override
    public int compareTo(Category o) {
	return name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
	return name;
    }
}
