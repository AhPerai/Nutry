package com.example.projetonutri.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.projetonutri.View.fragments.HomeActivicy;

public class Notificacao extends Service {

    private HandlerThread handlerThread;
    private Handler handler;

    //Define o tempo entre notificações, altere como quiser
    private final int TEMPO_ENTRE_NOTIFICAÇOES_SEGUNDOS = 1;

    @Override
    public void onCreate() {
        Log.d("NotifyService","onCreate");

        handlerThread = new HandlerThread("HandlerThread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("NotifyService","onStart");

        //Previne que seja executado em subsequentes chamadas a onStartCommand
        if(!handlerThread.isAlive()) {
            Log.d("NotifyService","Notificações iniciadas");
            handlerThread.start();
            handler = new Handler(handlerThread.getLooper());

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    sendNotification();
                    handler.postDelayed(this, 1000 * TEMPO_ENTRE_NOTIFICAÇOES_SEGUNDOS);
                }
            };
            handler.post(runnable);
        }
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("NotifyService","Notificações terminadas");
        handlerThread.quit();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void sendNotification(){
        Intent intent = new Intent (this ,
                HomeActivicy.class);
        PendingIntent pendingIntent = PendingIntent.getActivity
                (this, 0, intent, 0);
        Notification notification = new Notification.Builder (this)
                .setContentTitle("Lembrete para comer!")
                .setContentText("Opte por uma comida mais saudável e se alimente bem!")
                .setContentIntent(pendingIntent)
                .build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager =
                (NotificationManager) getSystemService (NOTIFICATION_SERVICE);
        notificationManager.notify (0, notification);
        Log.d("NotifyService", "notificação enviada");
    }
}
