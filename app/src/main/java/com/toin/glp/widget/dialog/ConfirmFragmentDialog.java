package com.toin.glp.widget.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.toin.glp.R;


/**
 * Created by Administrator on 2016/1/3.
 */
public class ConfirmFragmentDialog extends DialogFragment {
    private OnBtnClickListener listener;
    private String msg = "";

    public interface OnBtnClickListener{
        public void ok();
        public void cancel();
    }


    public ConfirmFragmentDialog() {
        setStyle(STYLE_NO_TITLE, R.style.CustomerDialogTheme);
    }

    public void setMessage(String msg){
        this.msg = msg;
    }

    public void setClickListener(OnBtnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.dialog_confirm_layout, null);
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

        return layout;
    }


}
