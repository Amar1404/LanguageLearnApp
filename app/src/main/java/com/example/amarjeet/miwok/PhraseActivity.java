package com.example.amarjeet.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {
    private  MediaPlayer mediaPlayer;
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
                words.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
             words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
               words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
              words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
              words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
//        //For Linear View
////        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView) ;
//        TextView wordView = new TextView(this);
//        for(int i=0;i<words.size();i++){
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        //For List View With Array Adapter
        WordAdapter adapter = new WordAdapter(this,words,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word word =words.get(i);
                 mediaPlayer = MediaPlayer.create(PhraseActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
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

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
