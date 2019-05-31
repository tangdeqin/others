package com.example.tdq.as.myapplication;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private ProgressDialog progressDialog;
    int progressValue = 0;
    private int mhour,mmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btn_one);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(android.R.drawable.btn_star);
                builder.setTitle("标题");
                builder.setMessage("我的消息的内容");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"按下了确定",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        button2 = findViewById(R.id.btn_two);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(android.R.drawable.btn_star);
                builder.setTitle("标题");
                builder.setMessage("我的消息的内容");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"按下了确定",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"按下了取消",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        button3 = findViewById(R.id.btn_three);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(android.R.drawable.btn_star);
                builder.setTitle("标题");

                final String[] name = new String[]{"我是1", "我是2", "我是3"};
                builder.setItems(name, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,name[i],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        button4 = findViewById(R.id.btn_four);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View Layout = MainActivity.this.getLayoutInflater().inflate(R.layout.layout,null);
                final EditText Uesrname = Layout.findViewById(R.id.et_name);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(android.R.drawable.btn_star);
                builder.setTitle("标题");
                builder.setView(Layout);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,Uesrname.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });

                builder.create().show();
            }
        });

        button5 = findViewById(R.id.btn_five);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(android.R.drawable.btn_star);
                builder.setTitle("标题");
                final String[] name = new String[]{"我是1", "我是2", "我是3"};
                final Boolean[] booleans = new Boolean[]{true,false,false};
                builder.setSingleChoiceItems(name,0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int j=0 ; j < booleans.length;j++){
                            booleans[j] = false;
                            if (j==i){
                                booleans[j] = true;
                            }
                        }
                    }
                });
                builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int j=0 ; j < booleans.length;j++){
                            if(booleans[j] == true){
                                Toast.makeText(MainActivity.this,name[j],Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                builder.create().show();
            }
        });

        button6 = findViewById(R.id.btn_six);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(android.R.drawable.btn_star);
                builder.setTitle("标题");
                final String[] name = new String[]{"我是1", "我是2", "我是3"};
                final Boolean[] booleans = new Boolean[]{false,false,false};
                builder.setMultiChoiceItems(name,null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        booleans[i]=b;
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nametemp = "";
                        for(int j=0 ; j<booleans.length ; j++){
                            if(booleans[j]==true){
                                nametemp+=name[j];
                            }
                        }
                        Toast.makeText(MainActivity.this,nametemp,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        button7 = findViewById(R.id.btn_seven);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressValue = 0;
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("进度");
                progressDialog.setMessage("0%");
                progressDialog.show();

                Thread thread = new Thread(){
                    public void run(){
                        try {
                            while (progressValue < 101){
                                progressValue+=20;

                                Bundle bundle = new Bundle();
                                bundle.putString("progressValue",progressValue+"");
                                Message message = new Message();
                                message.setData(bundle);

                                Thread.sleep(1000);
                                handler.sendMessage(message);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });

        button8 = findViewById(R.id.btn_eight);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressValue = 0;
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("进度");
                progressDialog.setMessage("0%");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();

                Thread thread = new Thread(){
                    public void run(){
                        try {
                            while (progressValue < 101){
                                progressValue+=20;

                                Bundle bundle = new Bundle();
                                bundle.putString("progressValue",progressValue+"");
                                Message message = new Message();
                                message.setData(bundle);

                                Thread.sleep(1000);
                                handler.sendMessage(message);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });

        button9 = findViewById(R.id.btn_night);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                final DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String time = datePicker.getYear()+"";
                        time+= datePicker.getMonth()+"";
                        time+=datePicker.getDayOfMonth()+"";

                        Toast.makeText(MainActivity.this,time,Toast.LENGTH_SHORT).show();
                    }
                },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));
                datePicker.show();
            }
        });

        button10 = findViewById(R.id.btn_ten);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                final TimePickerDialog  timeicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        mhour = timePicker.getHour();
                        mmin = timePicker.getMinute();
                        String time = mhour+"h     "+mmin+"m";
                        Toast.makeText(MainActivity.this, time, Toast.LENGTH_SHORT).show();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
                timeicker.show();
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(Integer.parseInt(msg.getData().getString("progressValue").toString())>100){
                progressDialog.dismiss();
            }else {
                progressDialog.setProgress(Integer.parseInt(msg.getData().getString("progressValue").toString()));
                progressDialog.setMessage(msg.getData().getString("progressValue").toString());
            }
        }
    };


}
