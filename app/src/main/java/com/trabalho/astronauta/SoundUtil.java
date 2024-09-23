package com.trabalho.astronauta;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundUtil {
    private MediaPlayer mediaPlayer;

    public void playClickSound(Context context) {
        // Se o mediaPlayer já estiver criado, liberá-lo
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        // Criar novo MediaPlayer
        mediaPlayer = MediaPlayer.create(context, R.raw.click);
        mediaPlayer.start();

        // Liberar o MediaPlayer quando terminar de tocar
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }
}

