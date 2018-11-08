package com.ironman.mvparm.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.ironman.mvparm.model.event.EventModel;
import com.ironman.mvparm.utils.RxBus;
import com.ironman.mvparm.utils.SystemBarHelper;
import com.jude.swipbackhelper.SwipeBackHelper;

import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

	private static final String TAG = BaseActivity.class.getSimpleName();

	protected ProgressDialog pg = null;

	private CompositeDisposable mCompositeDisposable;

	protected InputMethodManager manager;

	private Unbinder mUnBinder;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SystemBarHelper.setStatusBarDarkMode(this,true);
		initExitEvent();
		manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		SwipeBackHelper.onCreate(this);
		SwipeBackHelper.getCurrentPage(this)//get current instance
				.setSwipeBackEnable(true)//on-off
				.setSwipeEdge(200)//set the touch area。200 mean only the left 200px of screen can touch to begin swipe.
				.setSwipeEdgePercent(0.2f)//0.2 mean left 20% of screen can touch to begin swipe.
				.setSwipeSensitivity(0.5f)//sensitiveness of the gesture。0:slow  1:sensitive
				.setClosePercent(0.8f)//close activity when swipe over this
				.setSwipeRelateEnable(false)//if should move together with the following Activity
				.setSwipeRelateOffset(500);//the Offset of following Activity when setSwipeRelateEnable(true)
	}

	/**
	 * 退出应用
	 */
	private void initExitEvent() {
		Disposable disposable = RxBus.getInstance()
				.register(EventModel.class, eventModel -> {
					if (TextUtils.equals(eventModel.getEvent(), EventModel.EVENT_EXIT_APP)) {
						BaseActivity.this.finish();
					}
				});
		addSubscription(disposable);
	}

	public void setUnBinder(Unbinder unBinder) {
		mUnBinder = unBinder;
	}


	public void sendBroadcast(String action) {
		Intent intent = new Intent(action);
		sendBroadcast(intent);
	}

	public void initToolBar(Toolbar toolbar, boolean isShowBackIcon) {
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(isShowBackIcon);
	}
	
	protected void initTopBar(){
		initTopBar(null);
	}
	
	protected void initTopBar(View topBar) {
		SystemBarHelper.setTranslucentForImageViewInFragment(this, 0, topBar);
	}

	public ProgressDialog getProgressDialog() {
		if (pg == null) {
			pg = new ProgressDialog(this);
		}
		return pg;
	}

	/**
	 * 关闭软键盘
	 */
	public void closeInput() {
		if (manager != null && this.getCurrentFocus() != null) {
			manager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager
					.HIDE_NOT_ALWAYS);
		}
	}

	/**
	 * 打开软键盘
	 */
	public void openInput(final EditText editText) {
		if (manager != null) {
			manager.hideSoftInputFromWindow(editText.getWindowToken(), 0); //有效 如果显示就隐藏，如果隐藏就显示
			manager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}


	public void addSubscription(Disposable s) {
		if (this.mCompositeDisposable == null) {
			this.mCompositeDisposable = new CompositeDisposable();
		}
		this.mCompositeDisposable.add(s);
	}


	public void unsubscribe(){
		if (this.mCompositeDisposable != null) {
			this.mCompositeDisposable.dispose();
		}
	}

	@Override
	protected void onDestroy() {
		if (mUnBinder != null) {
			mUnBinder.unbind();
		}
		super.onDestroy();
		unsubscribe();
		if (pg != null) {
			pg.dismiss();
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * 实现点击空白处，软键盘消失事件
	 *
	 * @param ev
	 * @return
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {
			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
			View v = getCurrentFocus();
			if (isShouldHideInput(v, ev)) {
				hideSoftInput(v.getWindowToken());
			}
		}
		return super.dispatchTouchEvent(ev);
	}

	/**
	 * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
	 *
	 * @param v
	 * @param event
	 * @return
	 */
	private boolean isShouldHideInput(View v, MotionEvent event) {
		if (v != null && (v instanceof EditText)) {
			int[] l = {0, 0};
			v.getLocationInWindow(l);
			int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
					+ v.getWidth();
			if (event.getX() > left && event.getX() < right
					&& event.getY() > top && event.getY() < bottom) {
				// 点击EditText的事件，忽略它。
				return false;
			} else {
				return true;
			}
		}
		// 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
		return false;
	}

	/**
	 * 多种隐藏软件盘方法的其中一种
	 *
	 * @param token
	 */
	private void hideSoftInput(IBinder token) {
		if (token != null) {
			InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(token,
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
