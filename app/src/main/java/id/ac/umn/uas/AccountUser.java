package id.ac.umn.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountUser extends AppCompatActivity {

    HomeActivity homeActivity;
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
        homeActivity = new HomeActivity();
        DB = new DBHelper(this);
        Intent intent = getIntent();

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = newPass.getText().toString();
                String username = intent.getStringExtra("username");
                if (!newPassword.equals("")) {
                    if(newPassword.length() >= 6) {
                        boolean passChange = DB.updatePassword(username, newPassword);
                        if (passChange) {
                            Toast.makeText(AccountUser.this, "Password change successfully", Toast.LENGTH_SHORT).show();
                            Intent logout = new Intent(getApplicationContext(), MainActivity.class);
                            logout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(logout);
                            finish();
                        }
                    }
                    else{
                        Toast.makeText(AccountUser.this, "Please input minimum 6 letter", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(AccountUser.this, "Please input new password", Toast.LENGTH_SHORT).show();
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
                    logout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(logout);
                    finish();
                }
            }
        });
    }
}