package com.example.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

public class AudioPlayer {
	
	private MediaPlayer mPlayer;
	
	private boolean isPause;
	
	public  SurfaceHolder mSurfaceHolder;
	
	public void stop(){
		if(mPlayer!=null){
			mPlayer.release();
			mPlayer=null;
			isPause=false;
		}
	}
	

	
	public void play(Context c){
		if(isPause==true){
			mPlayer.start();
		}else{
			stop();
			//mPlayer=MediaPlayer.create(c,R.raw.one_small_step);
			mPlayer=MediaPlayer.create(c,R.raw.apollo_17_stroll);
			mPlayer.setDisplay(mSurfaceHolder);
			
			mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
						
				public void onCompletion(MediaPlayer MP) {
					// TODO 自动生成的方法存根
					MP.start();
				}
			}) ;
		
			mPlayer.start();
		}
		isPause=false;
	}
	
	
	public void setSurfaceHolder(SurfaceHolder surfaceHolder){
		mSurfaceHolder=surfaceHolder;
	}
	
	public void pause(){
		if(mPlayer!=null){
			mPlayer.pause();
		}
		isPause=true;
	}
	
	public boolean isPlaying(){
		if(mPlayer!=null)
			return mPlayer.isPlaying();
			else 
				return false;
			
	}
}


