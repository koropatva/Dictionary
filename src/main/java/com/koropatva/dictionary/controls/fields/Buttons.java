package com.koropatva.dictionary.controls.fields;

import com.koropatva.dictionary.controls.Stages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Buttons {

	private static Buttons buttons;

	private Button showMainStageButton;

	private Button closeMainStageButton;
	
	private Buttons() {
	}

	public static Buttons getInstance() {
		if (buttons == null) {
			buttons = new Buttons();
			buttons.initShowMainStageButton();
			buttons.initCloseMainStageButton();
		}
		return buttons;
	}

	private void initCloseMainStageButton() {
		closeMainStageButton = new Button("Close me");
		closeMainStageButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// in case we would like to close whole demo
				// javafx.application.Platform.exit();

				// however we want to close only this instance of stage
				Stages.getInstance().getMainDialogStage().close();
			}
		});
	}

	private void initShowMainStageButton() {
		showMainStageButton = new Button("Create a Stage");
		showMainStageButton.setStyle("-fx-font-size: 24;");
		showMainStageButton.setDefaultButton(true);
		showMainStageButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stages.getInstance().showMainDialogStage();
			}
		});
	}

	public Button getShowMainStageButton() {
		return showMainStageButton;
	}

	public Button getCloseMainStageButton() {
		return closeMainStageButton;
	}

}