package com.example.customalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    Button btshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btshow=findViewById(R.id.bt_show);

        btshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }
    private void showAlertDialog(){
        Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.alert_dialog);

        CheckBox checkBox=dialog.findViewById(R.id.check_box);
        Button btcancel=dialog.findViewById(R.id.bt_cancel);
        Button btok=dialog.findViewById(R.id.bt_ok);

        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    btok.setEnabled(true);
                    btok.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                }else{
                    btok.setEnabled(false);
                    btok.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }
            }
        });
        dialog.show();

    }
}