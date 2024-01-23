package ir.pooyamoradi.isfahan_ziba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        webView = findViewById(R.id.webView);

        String siteUrl = "https://moradi20.ir";
        webView.loadUrl(siteUrl);

    }
}
