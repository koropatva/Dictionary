package com.koropatva.dictionary.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.koropatva.dictionary.controls.Layouts;
import com.koropatva.dictionary.controls.Timers;
import com.koropatva.dictionary.server.StandaloneLocalServer;

public class Main extends Application {
	private void init(Stage primaryStage) {

		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(Layouts.getInstance().getRoot(), 400,
				400));
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			init(primaryStage);
			Timers.getInstance().startShowDialog();
			StandaloneLocalServer.getInstance().startLocalServer();
			primaryStage.show();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		StandaloneLocalServer.getInstance().stopLocalServer();
		Timers.getInstance().stopShowDialog();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
