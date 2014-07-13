package com.koropatva.dictionary.controls.fields;

import javafx.scene.control.Label;

public class Labels {

	private Label labelUnknowWord;

	private Label labelTranslateWord;

	private static Labels labels;

	private Labels() {
	}

	public static Labels getInstance() {
		if (labels == null) {
			labels = new Labels();
			labels.initLabelUnknowWord();
			labels.initLabelTranslateWord();
		}
		return labels;
	}


	private void initLabelUnknowWord() {
		labelUnknowWord = new Label("Unknow word:");
	}

	private void initLabelTranslateWord() {
		labelTranslateWord = new Label("Translate word:");
	}

	public Label getLabelUnknowWord() {
		return labelUnknowWord;
	}

	public Label getLabelTranslateWord() {
		return labelTranslateWord;
	}

}
