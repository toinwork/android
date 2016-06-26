package com.toin.work.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.toin.work.R;


public class ConfirmDialog extends Dialog{

	private Context context;
	private OnBtnClickListener listener;
	private String msg = "";

	public interface OnBtnClickListener{
		public void ok();
		public void cancel();
	}

	public ConfirmDialog(Context context, String msg) {
		super(context, R.style.CustomerDialogTheme);
		this.context = context;
		this.msg = msg;
	}
	
    public void setClickListener(OnBtnClickListener listener) {
		this.listener = listener;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}
	
	private void init(){
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.dialog_confirm_layout, null);
		setContentView(layout);
		View btnOk = layout.findViewById(R.id.btn_ok);
		View btnCancel = layout.findViewById(R.id.btn_cancel);

		TextView tvMsg = (TextView) layout.findViewById(R.id.tv_msg);
		tvMsg.setText(msg);

        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.ok();
                }
                dismiss();
			}
		});

        btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
                if (listener != null) {
                    listener.cancel();
                }
                dismiss();
			}
		});
	}
	
}
