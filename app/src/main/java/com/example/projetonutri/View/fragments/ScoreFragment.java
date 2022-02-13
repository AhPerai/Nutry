package com.example.projetonutri.View.fragments;

import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.ContextCompat.startForegroundService;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.projetonutri.R;
import com.example.projetonutri.Service.Notificacao;
import com.example.projetonutri.Service.NotificacaoAgua;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreFragment extends Fragment {

    Switch lembreteRefeicao, lembreteAgua;

    public ScoreFragment() {
        // Required empty public constructor
    }
    
    public static ScoreFragment newInstance(String param1, String param2) {
        ScoreFragment fragment = new ScoreFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNotificationChannel();
    }



    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "LemubitReminderChannel";
            String descricao = "Channel para o reminder";
            int imporance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLemubit", name, imporance);
            channel.setDescription(descricao);

            NotificationManager notificationManager = getSystemService(getContext(),NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        lembreteRefeicao = view.findViewById(R.id.switch1);
        lembreteAgua = view.findViewById(R.id.switchAgua);
        lembreteRefeicao.setText("Desabilitado");
        lembreteAgua.setText("Desabilitado");
        createNotificationChannel();
        lembreteAgua.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (lembreteAgua.isChecked()) {
                    lembreteAgua.setText("Habilitado");
                    Intent intent = new Intent(getContext(), NotificacaoAgua.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);
                    AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

                    long tenSec = 1000 * 10;
                    alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.currentThreadTimeMillis() + tenSec, pendingIntent);
                } else {
                    lembreteAgua.setText("Desabilitado");
                }
            }
        });
        lembreteRefeicao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(getContext(), Notificacao.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

                if (lembreteRefeicao.isChecked()) {
                    lembreteRefeicao.setText("Habilitado");
                    long tenSec = 1000 * 10;
                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.currentThreadTimeMillis(), tenSec, pendingIntent);

                } else {
                    lembreteRefeicao.setText("Desabilitado");
                    alarmManager.cancel(pendingIntent);
                    }
                }

        });
        return view;
    }
}