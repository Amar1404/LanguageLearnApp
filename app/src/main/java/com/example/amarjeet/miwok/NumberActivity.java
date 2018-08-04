package com.example.amarjeet.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.media.MediaPlayer.OnCompletionListener;
import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
        private MediaPlayer mediaPlayer;
        //declaring a global variable so that it can use many times
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
        words.add(new Word("One", "luti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "otiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "toolokosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "oyisso", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "massoko", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
//        //For Linear View
////        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView) ;
//        TextView wordView = new TextView(this);
//        for(int i=0;i<words.size();i++){
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        //For List View With Array Adapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Release the media player if it currently exists because we are about to
                              // play a different sound file
                        releaseMediaPlayer();
                Word word = words.get(i);
                mediaPlayer = MediaPlayer.create(NumberActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListner);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
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

}

