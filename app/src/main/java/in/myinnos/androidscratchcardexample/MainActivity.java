package in.myinnos.androidscratchcardexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import in.myinnos.androidscratchcard.ScratchCard;

public class MainActivity extends AppCompatActivity {

    private TextView textView, txReload;
    private ScratchCard mScratchCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        txReload = (TextView) findViewById(R.id.txReload);
        loadRandomNumber();

        mScratchCard = (ScratchCard) findViewById(R.id.scratchCard);
        mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                if (visiblePercent > 0.3) {
                    mScratchCard.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Content Visible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRandomNumber();
            }
        });
    }

    private void loadRandomNumber(){
        Random rand = new Random();
        String randomNum = String.valueOf(20 + rand.nextInt((100 - 20) + 1));
        textView.setText(randomNum);
    }
}
