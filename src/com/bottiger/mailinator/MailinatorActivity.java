package com.bottiger.mailinator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MailinatorActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView t = (TextView)findViewById(R.id.currentmail);
        t.setText("test@mail.com");
    }
}