package com.example.amarjeet.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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
               words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother,
                                R.raw.family_older_brother));
               words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,
                                R.raw.family_younger_brother));
                words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,
                                R.raw.family_older_sister));
                words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,
                                R.raw.family_younger_sister));
                words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother,
                                R.raw.family_grandmother));
                words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,
                                R.raw.family_grandfather));
//        //For Linear View
////        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView) ;
//        TextView wordView = new TextView(this);
//        for(int i=0;i<words.size();i++){
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        //For List View With Array Adapter
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word word =words.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}
