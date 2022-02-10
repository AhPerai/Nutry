package com.example.projetonutri.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.projetonutri.R;
import com.example.projetonutri.View.fragments.HomeActivicy;

public class NotificacaoAgua extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyLemubit")
                .setSmallIcon(R.drawable.icone)
                .setContentTitle("Lembrete de água!")
                .setContentText("Hora da hidratação!")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100, builder.build());
    }
}
