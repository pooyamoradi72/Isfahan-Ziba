package ir.pooyamoradi.isfahan_ziba;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginShowInfo extends AppCompatActivity {
    public TextView outText;
    TextView Matn;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_show_info);
        outText = (TextView) findViewById(R.id.tvShowInfo);
        Matn = (TextView) findViewById(R.id.tvMessageSuc);
        Typeface tf = Typeface.createFromAsset(getAssets(), "Vazirmatn-Medium.ttf");
        back = findViewById(R.id.btnBackInfo);
        back.setTypeface(tf);
        outText.setTypeface(tf);
        Matn.setTypeface(tf);
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String name = "";
            String phone = "";
            String email = "";
            String message = "";
            if (extra.containsKey("name:")) {
                name = extra.getString("name:");
            }
            if (extra.containsKey("phone:")) {
                phone = extra.getString("phone:");
            }
            if (extra.containsKey("email:")) {
                email = extra.getString("email:");
            }
            if (extra.containsKey("message:")) {
                message = extra.getString("message:");
            }
            outText.setText("نام: " + name + "\n");
            outText.append("شماره تماس: " + phone + "\n");
            outText.append("ایمیل: " + email + "\n");
            outText.append("متن پیام: " + message + "\n");
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginShowInfo.this, MainActivity.class);
                LoginShowInfo.this.startActivity(myIntent);
            }
        });
    }

}

