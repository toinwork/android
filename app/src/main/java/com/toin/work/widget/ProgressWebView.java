package com.toin.work.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.ProgressBar;

/**
 * 带进度条的WebView
 */
@SuppressWarnings("deprecation")
public class ProgressWebView extends WebView {

	private ProgressBar progressbar;

	public ProgressWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		progressbar = new ProgressBar(context, null,
				android.R.attr.progressBarStyleHorizontal);
		progressbar.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				3, 0, 0));
		addView(progressbar);
		setWebChromeClient(new WebChromeClient());
	}

	public class WebChromeClient extends android.webkit.WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			setProgress(newProgress);
			super.onProgressChanged(view, newProgress);
		}
	}

	/**
	 * 设置进度
	 * @param progress
	 */
	public void setProgress(int progress) {
		if (progress == 100) {
			progressbar.setVisibility(GONE);
		} else {
			if (progressbar.getVisibility() == GONE)
				progressbar.setVisibility(VISIBLE);
			progressbar.setProgress(progress);
		}
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		LayoutParams lp = (LayoutParams) progressbar.getLayoutParams();
		lp.x = l;
		lp.y = t;
		progressbar.setLayoutParams(lp);
		super.onScrollChanged(l, t, oldl, oldt);
	}
}
