package com.koropatva.dictionary.controls;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.koropatva.dictionary.controls.fields.Buttons;

public class Stages {

	private Stage mainDialogStage;

	private static Stages stages;

	private double initX;
	private double initY;

	private Stages() {
	}

	public static Stages getInstance() {
		if (stages == null) {
			stages = new Stages();
			stages.initMainDialogStage();
		}
		return stages;
	}

	private void initMainDialogStage() {
		mainDialogStage = new Stage(StageStyle.TRANSPARENT);

		Group rootGroup = new Group();
		Scene scene = new Scene(rootGroup, 200, 200, Color.TRANSPARENT);
		mainDialogStage.setScene(scene);

		Circle dragger = new Circle(100, 100, 100);
		dragger.setFill(new RadialGradient(-0.3, 135, 0.5, 0.5, 1, true,
				CycleMethod.NO_CYCLE, new Stop[] { new Stop(1, Color.DARKGREY),
						new Stop(1, Color.BLACK) }));

		// when mouse button is pressed, save the initial position of screen
		rootGroup.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				initX = me.getScreenX() - mainDialogStage.getX();
				initY = me.getScreenY() - mainDialogStage.getY();
			}
		});

		// when screen is dragged, translate it accordingly
		rootGroup.setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				mainDialogStage.setX(me.getScreenX() - initX);
				mainDialogStage.setY(me.getScreenY() - initY);
			}
		});

		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(60, 0, 0, 20));
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().addAll(
				Buttons.getInstance().getCloseMainStageButton());

		rootGroup.getChildren().addAll(dragger, vBox);
	}

	public void showMainDialogStage() {
		mainDialogStage.centerOnScreen();
		mainDialogStage.show();
	}

	public void closeMainDialogStage() {
		mainDialogStage.close();
	}

	public Stage getMainDialogStage() {
		return mainDialogStage;
	}
}
