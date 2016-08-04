package sst.sigillo.main;

import java.io.File;
import java.io.IOException;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import sst.sigillo.intrfc.JSONInterface;
import sst.sigillo.intrfc.XMLInterface;
import sst.sigillo.model.Bookmark;
import sst.sigillo.model.SigilloModel;
import sst.sigillo.output.ExportEngine;

public class Sigillo extends Application { // NO_UCD (unused code)

    private static Logger logger = LoggerFactory.getLogger(Sigillo.class);

    private TextField urlTextField;
    private TextField nameTextField;
    private TextField categoryTextField;
    private Button createButton;
    // Web color value set as the currently selected color
    private ColorPicker colorPickerHeader = new ColorPicker(
	    Color.web(SigilloModel.getInstance().getData().getHeaderColor()));
    private ColorPicker colorPickerContent = new ColorPicker(
	    Color.web(SigilloModel.getInstance().getData().getBookmarkColor()));
    ComboBox<String> comboBox = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
	logger.info("-----------------------------------------------------------------------");
	logger.info("--- Sigillo - " + SigilloConstants.SIGILLO_TITLE);

	int windowWidth = 950;
	int windowHeight = 600;

	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(25, 25, 25, 25));

	Scene scene = new Scene(grid, windowWidth, windowHeight);
	primaryStage.setScene(scene);

	// set title
	primaryStage.setTitle(SigilloConstants.SIGILLO_TITLE);

	scene.getStylesheets().add(Sigillo.class.getResource("sigillo.css").toExternalForm());

	init(grid);

	primaryStage.show();
    }

    private void init(GridPane grid) {
	grid.add(createTable(), 0, 0, 2, 1);
	grid.add(createForm(), 0, 1);
	grid.add(createColorsButtons(), 1, 1);
    }

    private Node createColorsButtons() {
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(25, 25, 25, 25));

	Button saveButton = null;
	grid.add(new Label("Header Color"), 0, 0);
	grid.add(new Label("Bookmark Color"), 0, 1);

	grid.add(colorPickerHeader, 1, 0);
	grid.add(colorPickerContent, 1, 1);
	grid.add(saveButton = new Button("Save Files"), 0, 2);

	saveButton.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		saveFiles();
	    }
	});

	colorPickerHeader.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		setColor();
	    }

	    private void setColor() {
		SigilloModel.getInstance().getData().setHeaderColor(toRGBCode(colorPickerHeader.getValue()));
	    }
	});

	colorPickerContent.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		setColor();
	    }

	    private void setColor() {
		SigilloModel.getInstance().getData().setBookmarkColor(toRGBCode(colorPickerContent.getValue()));
	    }
	});

	return grid;
    }

    public static String toRGBCode(Color color) {
	return String.format("#%02X%02X%02X", (int) (color.getRed() * 255), (int) (color.getGreen() * 255),
		(int) (color.getBlue() * 255)).toUpperCase();
    }

    private Node createForm() {
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(25, 25, 25, 25));

	grid.add(new Label("URL"), 0, 0);
	grid.add(urlTextField = new TextField(), 1, 0, 3, 1);

	grid.add(new Label("Name"), 0, 1);
	grid.add(nameTextField = new TextField(), 1, 1);
	grid.add(new Label("Category"), 2, 1);
	grid.add(categoryTextField = new TextField(), 3, 1);

	grid.add(createButton = new Button("Create"), 0, 2);
	grid.add(comboBox = new ComboBox<>(), 3, 2);
	initComboBox();
	createButton.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		createNewBookmark();
	    }
	});

	return grid;
    }

    private void initComboBox() {
	comboBox.setItems(SigilloModel.getInstance().getCategoriesObservableList());
    }

    protected void createNewBookmark() {
	if (null == urlTextField.getText() || 0 == urlTextField.getText().length()) {
	    return;
	}
	if (null == nameTextField.getText() || 0 == nameTextField.getText().length()) {
	    return;
	}

	Bookmark bookmark = new Bookmark();
	bookmark.setUrl(urlTextField.getText());
	bookmark.setName(nameTextField.getText());
	if (categoryTextField.getText().length() > 0) {
	    bookmark.setCategory(SigilloModel.getInstance().getCategoryByName(categoryTextField.getText()));
	} else {
	    bookmark.setCategory(SigilloModel.getInstance().getCategoryByName(comboBox.getValue()));
	}

	SigilloModel.getInstance().addBookmark(bookmark);

	saveFiles();

	urlTextField.clear();
	nameTextField.clear();
	categoryTextField.clear();
	initComboBox();
    }

    private void saveFiles() {
	XMLInterface.getTheOne().save();
	JSONInterface.getTheOne().save();
	export2HTML();
    }

    public void export2HTML() {
	final Weld weld = new Weld();
	WeldContainer weldContainer = weld.initialize();

	final ExportEngine exportManager = weldContainer.instance().select(ExportEngine.class).get();
	try {
	    exportManager.getExport().export2HTML(new File("index.html"));
	} catch (IOException e) {
	    logger.error("Cannot export to HTML", e);
	}

	weld.shutdown();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private Node createTable() {
	int textWidth = 256, urlWidth = 512, categoryWidth = 128;

	TableColumn nameCol = new TableColumn();
	nameCol.setText("Name");
	nameCol.setMinWidth(textWidth);
	nameCol.setCellValueFactory(new PropertyValueFactory("name"));

	TableColumn urlCol = new TableColumn();
	urlCol.setText("URL");
	urlCol.setMinWidth(urlWidth);
	urlCol.setCellValueFactory(new PropertyValueFactory("url"));

	TableColumn categoryCol = new TableColumn();
	categoryCol.setText("Category");
	categoryCol.setMinWidth(categoryWidth);
	categoryCol.setCellValueFactory(new PropertyValueFactory("categoryName"));

	TableColumn importantCol = new TableColumn();
	importantCol.setText("Important");
	importantCol.setMinWidth(categoryWidth);
	importantCol.setCellValueFactory(new PropertyValueFactory("important"));

	TableView tableView = new TableView();
	tableView.setEditable(true);
	tableView.setItems(SigilloModel.getInstance().getBookmarksObservableList());

	nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	nameCol.setOnEditCommit(new EventHandler<CellEditEvent<Bookmark, String>>() {
	    @Override
	    public void handle(CellEditEvent<Bookmark, String> t) {
		Bookmark bookmark = t.getTableView().getItems().get(t.getTablePosition().getRow());
		logger.debug("Bookmark name updated from " + bookmark.getName() + " to " + t.getNewValue());
		bookmark.setName(t.getNewValue());
		saveFiles();
	    }
	});

	urlCol.setCellFactory(TextFieldTableCell.forTableColumn());
	urlCol.setOnEditCommit(new EventHandler<CellEditEvent<Bookmark, String>>() {
	    @Override
	    public void handle(CellEditEvent<Bookmark, String> t) {
		Bookmark bookmark = t.getTableView().getItems().get(t.getTablePosition().getRow());
		logger.debug("Bookmark URL updated from " + bookmark.getUrl() + " to " + t.getNewValue());
		bookmark.setUrl(t.getNewValue());
		saveFiles();
	    }
	});

	categoryCol.setCellFactory(TextFieldTableCell.forTableColumn());
	categoryCol.setOnEditCommit(new EventHandler<CellEditEvent<Bookmark, String>>() {
	    @Override
	    public void handle(CellEditEvent<Bookmark, String> t) {
		Bookmark bookmark = t.getTableView().getItems().get(t.getTablePosition().getRow());
		logger.debug("Bookmark Category updated from " + bookmark.getCategory() + " to " + t.getNewValue());
		bookmark.setCategory(SigilloModel.getInstance().getCategoryByName(t.getNewValue()));
		saveFiles();
	    }
	});

	importantCol.setCellFactory(CheckBoxTableCell.forTableColumn(importantCol));
	// importantCol.setCellValueFactory(new PropertyValueFactory<Bookmark,
	// Boolean>("important"));
	importantCol.setEditable(true);

	importantCol
		.setCellValueFactory(new Callback<CellDataFeatures<Bookmark, CheckBox>, ObservableValue<CheckBox>>() {

		    @Override
		    public ObservableValue<CheckBox> call(CellDataFeatures<Bookmark, CheckBox> arg0) {
			Bookmark user = arg0.getValue();
			CheckBox checkBox = new CheckBox();

			checkBox.selectedProperty().setValue(user.isImportant());

			return new SimpleObjectProperty<>(checkBox);
		    }
		});
	tableView.getColumns().addAll(nameCol, categoryCol, importantCol, urlCol);

	export2HTML();

	return tableView;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	launch(args);
    }
}
