package com.pison.intentserviceexample;

import android.app.IntentService;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pisonsoft on 2016/7/22.
 */
public class MyService extends IntentService {
    public static final String RESULT = "result";
    public static final String NOTIFICATION = "com.mycompany.serviceexample";
    public int compute=0;
    public MyService() {
        super("MyService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Timer timer = new Timer(true);
        timer.schedule(task,2000, 2000); //延时2000ms后执行，2000ms执行一次
    }
    TimerTask task = new TimerTask(){
        public void run() {
            compute++;
            publishResult();
        }
    };
    private void publishResult(){
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(RESULT,compute);
        sendBroadcast(intent);
    }
}
