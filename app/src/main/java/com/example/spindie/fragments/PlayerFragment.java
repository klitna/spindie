package com.example.spindie;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spindie.IOnBackPressed;
import com.example.spindie.R;


public class PlayerFragment extends Fragment{
    private TextView textCurrentTime;
    private TextView textTotalDuration;
    private ImageButton playPause;
    private ImageButton next;
    private ImageButton previous;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private SeekBar seekBar;

    public PlayerFragment() {

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewPlayer = inflater.inflate(R.layout.fragment_player, container, false);

        playPause= viewPlayer.findViewById(R.id.imageButtonPlay);
        textCurrentTime = viewPlayer.findViewById(R.id.textViewCurrentTime);
        textTotalDuration = viewPlayer.findViewById(R.id.textViewTotalDuration);
        next =  viewPlayer.findViewById(R.id.imageButtonNext);
        previous = viewPlayer.findViewById(R.id.imageButtonPrevious);
        seekBar = viewPlayer.findViewById(R.id.seekBar);
        seekBar.setMax(100);

        playPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    playPause.setImageResource(R.drawable.play);
                }else{
                    mediaPlayer.start();
                    playPause.setImageResource(R.drawable.pause);
                    updateSeekBar();
                }
            }
        });

        prepareMediaPlayer();

        seekBar.setOnTouchListener((view, event) -> {
            SeekBar seekBar = (SeekBar) view;
            int playPosition = (mediaPlayer.getDuration() / 100) * seekBar.getProgress();
            mediaPlayer.seekTo(playPosition);
            textCurrentTime.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));
            return false;
        });

        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                seekBar.setSecondaryProgress(percent);
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                seekBar.setProgress(0);
                playPause.setImageResource(R.drawable.play);
                textCurrentTime.setText(R.string.zero);
                textTotalDuration.setText(R.string.zero);
                mediaPlayer.reset();
                prepareMediaPlayer();
            }
        });

//        FragmentManager menuManager = getFragmentManager();
//        FragmentTransaction menuTransaction = menuManager.beginTransaction();
//
//        menuTransaction.replace(R.id.nav_host_fragment, new MusicFragment()).addToBackStack(null).commit();
//
//        viewPlayer.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                Log.i("send help", "keyCode: " + keyCode);
//                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
//                    Log.i("aiuda", "onKey Back listener is working!!!");
//                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                    mediaPlayer.stop();
//                    return true;
//                }
//                return false;
//            }
//        });


        return viewPlayer;
    }

    private void prepareMediaPlayer(){
        try{
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/spindie.appspot.com/o/audio%2FTheSmiths-ThereIsALightThatNeverGoesOut.mp3?alt=media&token=db3ea371-2d88-44da-8567-887ce3ba785e");
            mediaPlayer.prepare();

            textTotalDuration.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        }catch(Exception exception){
            Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private Runnable updater = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
            long currentDuration = mediaPlayer.getCurrentPosition();
            textCurrentTime.setText(milliSecondsToTimer(currentDuration));
        }
    };

    private void updateSeekBar(){
        if(mediaPlayer.isPlaying()){
            seekBar.setProgress((int)(((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
            handler.postDelayed(updater, 1000);
        }
    }

    private String milliSecondsToTimer(long milliseconds){
        String timerString = "";
        String secondString;

        int hours = (int)(milliseconds / (1000 * 60 * 60));
        int minutes = (int)(milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int)(milliseconds % (1000 * 60 * 60)) % (1000 * 60) /1000;

        if(hours >0){
            timerString = hours + ":";
        }

        if(seconds<10){
            secondString = "0" + seconds;
        }else{
            secondString =  "" + seconds;
        }

        timerString = timerString + minutes + ":" + secondString;
        return timerString;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                mediaPlayer.stop();
            }
        }
    }


}