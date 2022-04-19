package com.example.lab81;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class frmDangNhap extends AppCompatActivity {
    private static final String TAG="LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    Button btndn;
    EditText edtemail,edtpass;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_dang_nhap);
        mAuth = FirebaseAuth.getInstance();
        Find();
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(edtemail.getText().length()==0)
                {
                    edtemail.setError("Please enter your email!");
                }
                else
                    if(edtpass.getText().length()==0)
                    {
                        edtpass.setError("Please enter your password!");
                    }
                else{
                        SignIn();
                    }

            }
        });
    }
    private void Find(){
        btndn=findViewById(R.id.btnDangNhap2);
        edtemail=findViewById(R.id.editemail);
        edtpass=findViewById(R.id.editpass);
    }
    private  void SignIn()
    {

       final Intent intentface=new Intent(this,frmFace.class);
        String Email=edtemail.getText().toString();
        String Pass=edtpass.getText().toString();
        mAuth.signInWithEmailAndPassword(Email, Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            startActivity(intentface);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(frmDangNhap.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}