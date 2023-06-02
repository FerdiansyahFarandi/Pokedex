package com.example.pokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditorActivity extends AppCompatActivity {
    private EditText editName, editEmail;
    private ImageView avatar;
    private Button btnSave;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String id = " ";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        editName = findViewById(R.id.name);
        editEmail = findViewById(R.id.email);
        btnSave = findViewById(R.id.btn_save);

        progressDialog = new ProgressDialog(EditorActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Menyimpan...");


        btnSave.setOnClickListener(view -> {
            if(editName.getText().length()>0 && editEmail.getText().length()>0){
                saveData(editName.getText().toString(),editEmail.getText().toString());
            }else{
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void saveData(String name, String email){
        Map<String, Object> user = new HashMap<>();
        user.put("name",name);
        user.put("email",email);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
    }
    }
