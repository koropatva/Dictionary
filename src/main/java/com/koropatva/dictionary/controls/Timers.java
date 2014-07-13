package com.koropatva.dictionary.controls;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Timers {
	private static Timers timers;

	private Timeline timeline;

	private boolean isShow;

	private Timers() {
	}

	public static Timers getInstance() {
		if (timers == null) {
			timers = new Timers();
			timers.initTimeline();
		}

		return timers;
	}

	private void initTimeline() {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);

		Duration duration = Duration.seconds(2);

		EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (isShow) {
					Stages.getInstance().showMainDialogStage();
				} else {
					Stages.getInstance().closeMainDialogStage();
				}
				isShow = !isShow;
			}
		};

		KeyFrame keyFrame = new KeyFrame(duration, onFinished);

		timeline.getKeyFrames().add(keyFrame);
	}

	public void startShowDialog() {
		timeline.play();
	}

	public void stopShowDialog() {
		timeline.stop();
	}

	public static Timers getTimers() {
		return timers;
	}
}
