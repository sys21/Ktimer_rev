package com.ktimer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity {
	private MyCountDownTimer myCountDownTimer;
	private long settime;
	private ToneGenerator toneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, 100);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView textView = (TextView) findViewById(R.id.label_dialog_text);
		final Button btn_set = (Button) findViewById(R.id.btn_set);
		final Button btn_start = (Button) findViewById(R.id.btn_start);
		final Button btn_stop = (Button) findViewById(R.id.btn_stop);
		final NumberPicker np1 = (NumberPicker) findViewById(R.id.np1);
		final NumberPicker np2 = (NumberPicker) findViewById(R.id.np2);
		final NumberPicker np3 = (NumberPicker) findViewById(R.id.np3);
		btn_start.setEnabled(false);
		btn_stop.setEnabled(false);
		initViews(np1, 99);
		initViews(np2, 59);
		initViews(np3, 59);
		// 時間設定
		btn_set.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				final int hour = np1.getValue();
				final int minute = np2.getValue();
				final int second = np3.getValue();
				textView.setText(String.format("%02d : %02d : %02d", hour, minute, second));
				settime = ((hour * 60 + minute) * 60 + second) * 1000;
				btn_start.setEnabled(true);
				btn_stop.setEnabled(false);
			}
		});
		// 開始ボタン
		btn_start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				// カウントダウンView
				myCountDownTimer = new MyCountDownTimer(settime, 500l);
				myCountDownTimer.start();
				btn_set.setEnabled(false);
				btn_start.setEnabled(false);
				btn_stop.setEnabled(true);
				np1.setEnabled(false);
				np2.setEnabled(false);
				np3.setEnabled(false);
			}
		});
		// 停止ボタン
		btn_stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				myCountDownTimer.cancel();
				settime = 0;
				btn_set.setEnabled(true);
				np1.setEnabled(true);
				np2.setEnabled(true);
				np3.setEnabled(true);
				textView.setText(getResources().getString(R.string.dialog_setting_label));
				toneGenerator.stopTone();
			}
		});
	}

	private void initViews(NumberPicker numPicker, int intMax) {
		numPicker.setMaxValue(intMax);
		numPicker.setMinValue(00);
	}

	/**
	 * カウントダウンタイマー
	 */
	private class MyCountDownTimer extends CountDownTimer {
		MyCountDownTimer(final long millisInFuture, final long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		final TextView textView = (TextView) findViewById(R.id.label_dialog_text);

		@Override
		public void onTick(long millisUntilFinished) {
			textView.setText(String.format("%02d : %02d : %02d", (millisUntilFinished / 1000 / 3600), ((millisUntilFinished / 1000 % 3600) / 60),
					((millisUntilFinished / 1000 % 3600) % 60)));
		}

		@Override
		public void onFinish() {
			textView.setText(getResources().getString(R.string.time_up));
			toneGenerator.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD);
		}
	}
}
