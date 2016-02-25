package com.example.hellomoon;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	
	private Button mPlayButton;
	private Button mStopButton;
	private AudioPlayer mPlayer=new AudioPlayer();
	private SurfaceView mSurfaceView;
	
    void updateButtons() {
        boolean isEnabled = !mPlayer.isPlaying();
        mPlayButton.setEnabled(isEnabled);
    }
	
/*	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_moon);
	}*/
	
	public View onCreateView(LayoutInflater inflater,ViewGroup parent,
			Bundle savedInstanceState){
		View v=inflater.inflate(R.layout.fragment_hello_moon, parent,false);
		
		mPlayButton=(Button)v.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
				//mPlayer.play(getActivity());
				if(mPlayer.isPlaying()==true){
					mPlayer.pause();
					mPlayButton.setText(R.string.hellomoon_pause);
				}else {
					mPlayer.play(getActivity());
					mPlayButton.setText(R.string.hellomoon_play);
				}
				updateButtons();
			}
		});
		mStopButton=(Button)v.findViewById(R.id.hellomoon_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				mPlayer.stop();
				updateButtons();
			}
		});
		
		mSurfaceView=(SurfaceView)v.findViewById(R.id.hellomoon_surfaceView);
		mPlayer.setSurfaceHolder(mSurfaceView.getHolder());
		
		return v;
	}
	
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		mPlayer.stop();
	}
}
