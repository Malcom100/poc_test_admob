package adneom.poc_admob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by gtshilombowanticale on 07-08-17.
 */

public class InterstitialActivity extends AppCompatActivity {

    private final String ADMOB_APP_ID = "ca-app-pub-3940256099942544~3347511713";
    private final String UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
    private InterstitialAd mInterstitialAd;

    private AdRequest request;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeAdMobb();
        manageInterstial();
    }

    private void initializeAdMobb(){
        MobileAds.initialize(this,ADMOB_APP_ID);
        //To test ask device ID
        request = new AdRequest.Builder().addTestDevice(ADMOB_APP_ID).build();
    }

    private void manageInterstial(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(UNIT_ID);
        //load :
        //mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.loadAd(request);

        //listener
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
                //show
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("Ads", "onAdClosed");
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
