package adneom.poc_admob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button interstitial;
    private Button reaward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interstitial = (Button)findViewById(R.id.btn_interstitial);
        reaward = (Button)findViewById(R.id.btn_reward);
        interstitial.setOnClickListener(this);
        reaward.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_interstitial:
                Intent intentInterstitial = new Intent(MainActivity.this,InterstitialActivity.class);
                startActivity(intentInterstitial);
                break;
            case R.id.btn_reward:
                Intent intentReward = new Intent(MainActivity.this,RewardActivity.class);
                startActivity(intentReward);
                break;
        }
    }
}
