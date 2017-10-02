package adneom.poc_admob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;


public class RewardActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private final String ID = "0D72F2849A868A90C6B1FC02D5479592";

    private final String ADMOB_APP_ID = "ca-app-pub-3940256099942544/5224354917";

    private RewardedVideoAd mAd;
    private AdRequest request;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use an activity context to get the rewarded video instance.
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);

        //To test ask device ID
        request = new AdRequest.Builder().addTestDevice(ID).build();

        loadRewardedVideoAd();
    }

    private void loadRewardedVideoAd() {
        //mAd.loadAd(ID, new AdRequest.Builder().build());
        mAd.loadAd(ADMOB_APP_ID, request);
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Log.i("Ads","on Rewaarded");
        Toast.makeText(this,getString(R.string.reaward),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Log.i("Ads","onRewardedVideoAdLoaded");
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Log.i("Ads","on RewardVideoAdOpened");
    }

    @Override
    public void onRewardedVideoStarted() {
        Log.i("Ads","on RewardVideoStarted");
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Log.i("Ads","on RewardVideoAdClosed");
    }


    @Override
    public void onRewardedVideoAdLeftApplication() {
        Log.i("Ads","on RewardVideoAdLeftApplication");
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Log.i("Ads","on RewardVideoAdFailedToLoad");
    }
}
