package popkovanton.simplearcanoid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import popkovanton.simplearcanoid.logic.GameManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }
}
