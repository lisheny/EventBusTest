package com.lishent.eventbusstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void initView(){
        button = (Button)findViewById(R.id.btn_send);
        textView = (TextView)findViewById(R.id.tv_show);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageEvent messageEvent = new MessageEvent();
                messageEvent.setName("lisheny");
                messageEvent.setSex("boy");
                EventBus.getDefault().post(messageEvent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageEvent(final MessageEvent event){
        textView.setText(event.getName()+","+event.getSex());
    }
}
