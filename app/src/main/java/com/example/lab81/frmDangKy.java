package com.example.lab81;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class frmDangKy extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    Button btndn;
    EditText edtemail,edtpass,edtname,edtpass2;

   // private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_dang_ky);
      //  mAuth = FirebaseAuth.getInstance();
        Find();
        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtname.getText().toString().trim();
                String email=edtemail.getText().toString().trim();
                String pass=edtpass.getText().toString().trim();
                String pass2=edtpass2.getText().toString().trim();
                int normal=0;
                int happy=0;
                int unhappy=0;
                User user=new User(name,email,pass,pass2,normal,happy,unhappy);
               AddUser(user);

            }
        });
    }

    private void AddUser(User user){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference mRef=database.getReference("ListUser");
        String  pathObject=String.valueOf(user.getEmail());
        mRef.child(pathObject).setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(frmDangKy.this, "DK thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Find(){
        btndn=findViewById(R.id.btnDangNhap3);
        edtemail=findViewById(R.id.editemaildk);
        edtpass=findViewById(R.id.editpassdk);
        edtpass2=findViewById(R.id.editpass2dk);
        edtname=findViewById(R.id.edittendk);
    }
   /* private  void SignIn()
    {

        final Intent intentface=new Intent(this,frmFace.class);
        String Email=edtemail.getText().toString();
        String Pass=edtpass.getText().toString();
        String Name=edtname.getText().toString();
        mAuth.createUserWithEmailAndPassword(Email, Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(frmDangKy.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }*/
}