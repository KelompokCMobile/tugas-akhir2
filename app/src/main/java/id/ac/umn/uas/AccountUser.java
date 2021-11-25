package id.ac.umn.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountUser extends AppCompatActivity {

    EditText newPass;
    Button changePass, delAcc;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_user);
        newPass = (EditText)findViewById(R.id.newpassword);
        changePass = (Button)findViewById(R.id.btnChangePassword);
        delAcc = (Button)findViewById(R.id.deleteAccount);
        DB = new DBHelper(this);
        Intent intent = getIntent();

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = newPass.getText().toString();
                String username = intent.getStringExtra("username");
                boolean passChange = DB.updatePassword(username, newPassword);
                if(passChange){
                    Toast.makeText(AccountUser.this, "Password change successfully", Toast.LENGTH_SHORT).show();
                    Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(logout);
                }
            }
        });

        delAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = intent.getStringExtra("username");
                boolean deleteAcc = DB.deleteData(username);
                if(deleteAcc){
                    Toast.makeText(AccountUser.this, "Account has been deleted", Toast.LENGTH_SHORT).show();
                    Intent logout = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(logout);
                }
            }
        });
    }
}