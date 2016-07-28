package sst.sigillo.model;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Ordering;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import sst.sigillo.intrfc.JSONInterface;
import sst.sigillo.intrfc.XMLInterface;

public class SigilloModel {
    private static Logger logger = LoggerFactory.getLogger(SigilloModel.class);

    @Getter
    @Setter
    private SigilloData data = null;

    @Getter
    private static SigilloModel instance = null;
    @Getter
    private HashMap<String, Category> categoryList = new HashMap<>();

    static {
	instance = new SigilloModel();
	// XMLInterface.getTheOne().load();
	try {
	    JSONInterface.getTheOne().load();
	} catch (FileNotFoundException e) {
	    try {
		XMLInterface.getTheOne().load();
	    } catch (FileNotFoundException e1) {
		logger.error("Cannot load data", e);
		System.exit(-1);
	    }
	}
    }

    private SigilloModel() {
    }

    public void setBookmarksList(Collection<Bookmark> list) {
	for (Bookmark book : list) {
	    addBookmark(book);
	}
    }

    public void addBookmark(Bookmark bookmark) {
	data.getBookmarksList().add(bookmark);

	Category cat = bookmark.getCategory();
	if (null == categoryList.get(cat.getName())) {
	    // cat.addBookmark(bookmark);
	    categoryList.put(cat.getName(), cat);
	}
    }

    public ObservableList<Bookmark> getBookmarksObservableList() {
	return FXCollections.observableArrayList(data.getBookmarksList());
    }

    public Collection<Category> getOrderedCategoryList() {
	return data.getBookmarksList().stream().map(Bookmark::getCategory).distinct().sorted().collect(Collectors.toList());

	// Ordering<String> categoryOrdering = new Ordering<String>() {
	// public int compare(String left, String right) {
	// return left.toUpperCase().compareTo(right.toUpperCase());
	// }
	// };

	// return categoryOrdering.sortedCopy(categoryList.keySet());
    }

    public Collection<Bookmark> getOrderedBookmarkList() {
	Ordering<Bookmark> categoryOrdering = new Ordering<Bookmark>() {
	    @Override
	    public int compare(Bookmark left, Bookmark right) {
		if (0 == left.getCategory().compareTo(right.getCategory())) {
		    return left.getName().toUpperCase().compareTo(right.getName().toUpperCase());
		}
		return left.getCategory().compareTo(right.getCategory());
	    }
	};

	return categoryOrdering.sortedCopy(data.getBookmarksList());
    }

    public ObservableList<String> getCategoriesObservableList() {
	return FXCollections.observableArrayList(getOrderedCategoryList().stream().map(Category::getName).collect(Collectors.toList()));
    }

    public Category getCategoryByName(String categoryName) {
	Category cat = categoryList.get(categoryName);
	if (null == cat) {
	    cat = new Category(categoryName);
	    categoryList.put(categoryName, cat);
	}
	return cat;
    }
}
