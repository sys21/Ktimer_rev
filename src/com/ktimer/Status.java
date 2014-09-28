package com.ktimer;

import android.widget.Button;

public enum Status {
	NOT_SET {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			setBtn.setEnabled(true);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(false);
		}
	}, // �ݒ�O
	SET {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			setBtn.setEnabled(true);
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
	}, // �ݒ�
	START {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			setBtn.setEnabled(false);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(true);
		}
	}, // �J�n
	STOP {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			setBtn.setEnabled(true);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(false);
		}
	}, // ��~
	END {
		@Override
		public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			setBtn.setEnabled(true);
			startBtn.setEnabled(false);
			stopBtn.setEnabled(false);
		}
	}, // �I��
	;
	private Status() {
	}

	abstract public void changeStatus(final Button setBtn, final Button startBtn, final Button stopBtn);
}
