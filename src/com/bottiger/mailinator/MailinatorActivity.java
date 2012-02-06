package com.bottiger.mailinator;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MailinatorActivity extends Activity {
	
	private static String mailSufix = "@mailinator.com";
	private static int mailPrefixLength = 4;
	
	private Button copyButton;
	private Button newMailButton;
	private TextView mailTextView;
	
	private String currentMail;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.copyButton = (Button)this.findViewById(R.id.copyButton);
        this.newMailButton = (Button)this.findViewById(R.id.newMailButton);
        this.mailTextView = (TextView)this.findViewById(R.id.currentmail);
        
        generateMail();
        
        this.newMailButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	generateMail();
            }
          });
        
        this.copyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	ClipboardManager clipboard = 
            	      (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 

            	clipboard.setText(mailTextView.getText());
            	
            	String toastText = mailTextView.getText() + " copied to clipboard";
            	Toast toast = Toast.makeText(getApplicationContext(), 
            						toastText, 
            						Toast.LENGTH_SHORT);
            	toast.show();
            }
          });
    }
    
    private void generateMail() {
    	generateMail(mailPrefixLength);
    }
    
    private void generateMail(int length) {
    	StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append((char) (97 + rand.nextInt(122 - 97)));
        }
        this.currentMail = sb.toString().toLowerCase() + mailSufix;
        mailTextView.setText(this.currentMail);
    }
}