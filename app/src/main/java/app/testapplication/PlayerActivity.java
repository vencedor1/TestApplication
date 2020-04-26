package app.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.net.URI;

/**
 * https://exoplayer.dev/
 */
public class PlayerActivity extends AppCompatActivity
{
	private PlayerView playerView;
	private SimpleExoPlayer player;
	private boolean playWhenReady = true;
	private int currentWindow = 0;
	private long playbackPosition = 0;
	private Player.EventListener playerListener;
	public static int URL = R.string.mp4_video1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		playerView = findViewById(R.id.video_view);
	}

	@Override
	public void onStart() {
		super.onStart();
		if (Util.SDK_INT > 23) {
			initializePlayer();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		hideSystemUi();
		if ((Util.SDK_INT <= 23 || player == null)) {
			initializePlayer();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (Util.SDK_INT <= 23) {
			releasePlayer();
		}
	}

	@Override
	public void onStop() {
		super.onStop();
		if (Util.SDK_INT > 23) {
			releasePlayer();
		}
	}

	@SuppressWarnings("deprecation")
	private void initializePlayer() {
		player = ExoPlayerFactory.newSimpleInstance(this);
		player.addListener(new PlayerEventListener());
		playerView.setPlayer(player);

		Uri uri = Uri.parse(getString(URL));
		MediaSource mediaSource = buildMediaSource(uri);

		player.setPlayWhenReady(playWhenReady);
		player.seekTo(currentWindow, playbackPosition);
		player.prepare(mediaSource, false, false);
	}

	private void releasePlayer() {
		if (player != null) {
			playbackPosition = player.getCurrentPosition();
			currentWindow = player.getCurrentWindowIndex();
			playWhenReady = player.getPlayWhenReady();
			player.release();
			player = null;
		}
	}

	private MediaSource buildMediaSource(Uri uri) {
		// These factories are used to construct two media sources below
		DataSource.Factory dataSourceFactory =
				new DefaultDataSourceFactory(this, "exoplayer-codelab");
		ProgressiveMediaSource.Factory mediaSourceFactory =
				new ProgressiveMediaSource.Factory(dataSourceFactory);

		// Create a media source using the supplied URI
		MediaSource mediaSource1 = mediaSourceFactory.createMediaSource(uri);
/*
		// Create a media source using the supplied URI
		MediaSource mediaSource1 = mediaSourceFactory.createMediaSource(uri);

		// Additionally create a media source using an MP3
		Uri audioUri = Uri.parse(getString(R.string.media_url_mp3));
		MediaSource mediaSource2 = mediaSourceFactory.createMediaSource(audioUri);
*/

		return new ConcatenatingMediaSource(mediaSource1/*, mediaSource2*/);
	}

	@SuppressLint("InlinedApi")
	private void hideSystemUi() {
		playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
				                                 | View.SYSTEM_UI_FLAG_FULLSCREEN
				                                 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				                                 | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				                                 | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				                                 | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
	}

	private class PlayerEventListener implements Player.EventListener
	{
		@Override
		public void onPlayerStateChanged(boolean playWhenReady, @Player.State int playbackState) {
			if (playbackState == Player.STATE_ENDED) {
				Common.isWaiting = false;
				finish();
			}
		}
	}
}