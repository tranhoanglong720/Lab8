package com.example.lab81;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class frmFace extends AppCompatActivity {
    private int normal;
    private int happy;
    private int unhappy;
    private ImageView imgnormal;
    private ImageView imghappy;
    private ImageView imgunhappy;
    private TextView txtName;
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_face);
        FindTT();
        final DatabaseReference ref1 = database.getReference("ListUser").
                child(FirebaseAuth.getInstance().getCurrentUser().getUid());
      //  txtName.setText("Employer: " +FirebaseAuth.getInstance().getCurrentUser().getUid().toString());
        ref1.child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                txtName.setText("Employer: " + name);
              //  Toast.makeText(frmFace.this, dataSnapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

       imghappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(frmFace.this, "Thank you!", Toast.LENGTH_SHORT).show();
                final DatabaseReference ref = database.getReference("ListUser").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("happy");

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            happy = Integer.parseInt(snapshot.getValue().toString());
                            happy++;
                            ref.setValue(happy);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        imgnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(frmFace.this, "Thank you!", Toast.LENGTH_SHORT).show();
                final DatabaseReference ref = database.getReference("ListUser").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("normal");

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            normal = Integer.parseInt(snapshot.getValue().toString());
                            normal++;
                            ref.setValue(normal);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        imgunhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(frmFace.this, "Thank you!", Toast.LENGTH_SHORT).show();
                final DatabaseReference ref = database.getReference("ListUser").
                        child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("unhappy");

                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            unhappy = Integer.parseInt(snapshot.getValue().toString());
                            unhappy++;
                            ref.setValue(unhappy);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    private void FindTT(){
        imgnormal=(ImageView) findViewById(R.id.imgnormal);
        imghappy=(ImageView) findViewById(R.id.imghappy);
        imgunhappy=(ImageView) findViewById(R.id.imgunhappy);
        txtName=(TextView) findViewById(R.id.txtNameUserFc);
    }
}