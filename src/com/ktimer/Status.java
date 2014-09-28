package com.ktimer;

import android.widget.Button;

public enum Status {
	NOT_SET {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO 自動生成されたメソッド・スタブ
			setBtn.setEnabled(true);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(false);
		}
	}, // 設定前
	SET {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO 自動生成されたメソッド・スタブ
			setBtn.setEnabled(true);
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
	}, // 設定
	START {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO 自動生成されたメソッド・スタブ
			setBtn.setEnabled(false);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(true);
		}
	}, // 開始
	STOP {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO 自動生成されたメソッド・スタブ
			setBtn.setEnabled(true);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(false);
		}
	}, // 停止
	END {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO 自動生成されたメソッド・スタブ
			setBtn.setEnabled(true);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(false);
		}
	}, // 終了
	;
	private Status() {
	}

	abstract public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn);
}
