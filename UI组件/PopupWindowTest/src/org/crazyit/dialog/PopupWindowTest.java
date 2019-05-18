package org.crazyit.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;


public class PopupWindowTest extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// װ��R.layout.popup��Ӧ�Ľ��沼��
		View root = this.getLayoutInflater().inflate(R.layout.popup, null);
		// ����PopupWindow����
		final PopupWindow popup = new PopupWindow(root, 280, 360);
		Button button = (Button) findViewById(R.id.bn);
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// ��������ʽ��ʾ��
     			popup.showAsDropDown(v);
				//��PopupWindow��ʾ��ָ��λ��
				//popup.showAtLocation(findViewById(R.id.bn), Gravity.CENTER, 20,
					//20);
			}
		});
		// ��ȡPopup�����еĹرհ�ť��
		root.findViewById(R.id.close).setOnClickListener(
			new View.OnClickListener()
			{
				public void onClick(View v)
				{
					// �ر�Popup����
					popup.dismiss();
				}
			});
	}
}