package com.koropatva.dictionary.controls.fields;

import javafx.scene.control.TextField;

public class Texts {

	private static Texts texts;

	private TextField textUnknowWord;

	private TextField textTranslateWord;

	private Texts() {
	}

	public static Texts getInstance() {
		if (texts == null) {
			texts = new Texts();
			texts.initTextUnknowWord();
			texts.initTextTranslateWord();
		}
		return texts;
	}


	private void initTextUnknowWord() {
		textUnknowWord = new TextField();
	}

	private void initTextTranslateWord() {
		textTranslateWord = new TextField();
	}

	public TextField getTextUnknowWord() {
		return textUnknowWord;
	}

	public TextField getTextTranslateWord() {
		return textTranslateWord;
	}

}
