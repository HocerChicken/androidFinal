package com.example.finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.UserActivity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText edtFullName;
    EditText edtPhone;
    EditText edtEmail;
    EditText edtAddress;
    EditText edtPassword;
    EditText edtConfirmPassword;
    Button btnRegister;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        initUI();
        initListener();
    }
    private void initUI(){
        edtFullName = findViewById(R.id.edtFullName);
        edtPhone = findViewById(R.id.edtPhone);
        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(this);
    }

    private void initListener(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickSignUp();
//                Intent intentResult = new Intent();
//
//                setResult(RESULT_OK);
//                finish();
            }
        });
    }
    private void onclickSignUp() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String confirmPassword = edtConfirmPassword.getText().toString().trim();
        String fullname = edtFullName.getText().toString().trim();
        String phoneNumber = edtPhone.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // email is invalid
            Toast.makeText(RegisterActivity.this, "Vui long kiem tra lai email",
                    Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            // check null password
            Toast.makeText(RegisterActivity.this, "Mat khau khong duoc de trong",
                    Toast.LENGTH_SHORT).show();
        }
        else if (password.length() < 6) {
            // check length password
            Toast.makeText(RegisterActivity.this, "Mat khau phai lon hon bang 6 ky tu",
                    Toast.LENGTH_SHORT).show();
        }
        else if (!confirmPassword.equals(password)) {
            // check length password
            Toast.makeText(RegisterActivity.this, "Mat khau xac nhan khong chinh xac",
                    Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(fullname)) {
            // check null password
            Toast.makeText(RegisterActivity.this, "ho ten khong duoc de trong",
                    Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phoneNumber)) {
            // check null password
            Toast.makeText(RegisterActivity.this, "so dien thoai khong duoc de trong",
                    Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(address)) {
            // check null password
            Toast.makeText(RegisterActivity.this, "Dia chi khong duoc de trong",
                    Toast.LENGTH_SHORT).show();
        } else {
            // user information is valid
            progressDialog.show();
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterActivity.this, "Email da ton tai.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}