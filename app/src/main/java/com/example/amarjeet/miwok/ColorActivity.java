package com.example.amarjeet.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
        private MediaPlayer mediaPlayer;
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
    private MediaPlayer.OnCompletionListener mCompletionListner= new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<Word>();
                words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
                               R.raw.color_mustard_yellow));
                words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
                                R.raw.color_dusty_yellow));
                words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
          //For Linear View
////        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView) ;
//        TextView wordView = new TextView(this);
//        for(int i=0;i<words.size();i++){
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        //For List View With Array Adapter
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word word =words.get(i);
                mediaPlayer = MediaPlayer.create(ColorActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}
