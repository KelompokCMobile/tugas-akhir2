package id.ac.umn.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        Toast.makeText(this, "Welcome "+ username, Toast.LENGTH_SHORT).show();
    }

    public void accountSetting(View v){
        Intent intent = new Intent(getApplicationContext(), AccountUser.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public void searchHotel(View v){
        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        startActivity(intent);
    }
}