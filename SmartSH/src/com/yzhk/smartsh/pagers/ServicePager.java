package com.yzhk.smartsh.pagers;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;

import com.yzhk.smartsh.R;
import com.yzhk.smartsh.Utils.CacheUtil;
import com.yzhk.smartsh.Utils.NetAccessUtil;
import com.yzhk.smartsh.global.GlobalConstant;

public class ServicePager extends BasePager {

	public ServicePager(Activity context) {
		super(context);

	}

	@Override
	public void initViewData() {
		tv_viewpager_title.setText("生活");
		ib_title_btn.setVisibility(View.VISIBLE);
		View view = View.inflate(context, R.layout.view_service, null);
		fl_view_content.addView(view);

		//向服务器求求数据
		String cache = CacheUtil.getCache(context, GlobalConstant.CATEGORY_URL);
		if (!TextUtils.isEmpty(cache)) {
			NetAccessUtil.parseDataAndSetSilding(context,cache);
		}
		NetAccessUtil.getDataFromServer(context);
	
	}

}
