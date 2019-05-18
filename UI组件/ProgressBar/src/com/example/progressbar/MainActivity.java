package com.example.progressbar;


import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.widget.ProgressBar;
import android.os.Handler;

public class MainActivity extends Activity {
	private ProgressBar progressBar1;
	private int status;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UIinit();
	}
	
	public void UIinit(){
		progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
		//����һ��������½��������ȵ�handler
		final Handler mhandler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				if(msg.what == 0x111){
					progressBar1.incrementProgressBy(1);
				}
				
			}
		};
		//�����̣߳�ִ�к�ʱ����0.1����ȼ�1
		new Thread(){
			public void run(){
				while(status < 100){
					status++;
					try {
						Thread.sleep(100);
					} 
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Message m = new Message();
					m.what = 0x111;
					mhandler.sendMessage(m);
				}
			
			}
		}.start();;
	}
}
