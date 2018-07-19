package com.example.attention.myapp19;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDilog(View view) {

        View layout =getLayoutInflater().inflate(R.layout.customlayout,null);
        final EditText editTextUsername=layout.findViewById(R.id.User_name);
        final EditText editTextPassword =layout.findViewById(R.id.Text_password);
        CheckBox  checkBox=layout.findViewById(R.id.checkbox1);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked){
                    editTextPassword.setTransformationMethod(null);

                }
                else
                {
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        AlertDialog.Builder alert=new AlertDialog.Builder(this);

        alert.setTitle("Sign up");
        alert.setView(layout);
        alert.setCancelable(false);

        alert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String name =editTextUsername.getText().toString();
                String password =editTextPassword.getText().toString();

                Toast.makeText(MainActivity. this,"Name :" + name+ "Password:" +password ,Toast.LENGTH_SHORT).show();

            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You have pressed cancle",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog =alert.create();
        dialog.show();
    }
}
