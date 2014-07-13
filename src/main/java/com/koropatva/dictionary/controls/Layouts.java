package com.koropatva.dictionary.controls;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import com.koropatva.dictionary.controls.fields.Buttons;
import com.koropatva.dictionary.controls.fields.Labels;
import com.koropatva.dictionary.controls.fields.Texts;

public class Layouts {

	private static Layouts layouts;

	private GridPane mainGrid;
	private Group root;

	private Layouts() {
	}

	public static Layouts getInstance() {
		if (layouts == null) {
			layouts = new Layouts();
			layouts.initMainGrid();
			layouts.initRoot();
		}
		return layouts;
	}

	private void initRoot() {
		root = new Group();
		root.getChildren().addAll(mainGrid);
	}

	private void initMainGrid() {
		if (mainGrid == null) {
			Labels labels = Labels.getInstance();
			Texts texts = Texts.getInstance();
			Buttons buttons = Buttons.getInstance();

			mainGrid = new GridPane();
			mainGrid.setHgap(2);
			mainGrid.setVgap(4);
			mainGrid.setPadding(new Insets(18, 18, 18, 18));

			ObservableList<Node> mainGridContent = mainGrid.getChildren();

			GridPane.setConstraints(labels.getLabelUnknowWord(), 0, 0);
			mainGridContent.add(labels.getLabelUnknowWord());

			GridPane.setConstraints(labels.getLabelTranslateWord(), 0, 1);
			mainGridContent.add(labels.getLabelTranslateWord());

			GridPane.setConstraints(texts.getTextUnknowWord(), 1, 0);
			mainGridContent.add(texts.getTextUnknowWord());

			GridPane.setConstraints(texts.getTextTranslateWord(), 1, 1);
			mainGridContent.add(texts.getTextTranslateWord());

			GridPane.setConstraints(buttons.getShowMainStageButton(), 0, 2);
			mainGridContent.add(buttons.getShowMainStageButton());
		}
	}

	public GridPane getMainGrid() {
		return mainGrid;
	}

	public Group getRoot() {
		return root;
	}

}
