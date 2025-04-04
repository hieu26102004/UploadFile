package com.example.uploadfile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

public class InfoActivity extends AppCompatActivity {

    ImageView imageViewProfile;
    TextView textViewUsername;
    String avatarUrl, username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        textViewUsername = findViewById(R.id.usernameLabel);
        imageViewProfile = findViewById(R.id.profileImage);
        Glide.with(this).load(R.drawable.pro_img).into(imageViewProfile);
        imageViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewProfile.setBackgroundColor(ContextCompat.getColor(InfoActivity.this, android.R.color.white));
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                intent.putExtra("avatarUrl", avatarUrl);
                startActivity(intent);
            }
        });
        avatarUrl = getIntent().getStringExtra("avatarUrl");
        username = getIntent().getStringExtra("username");

        if (username != null) {
            textViewUsername.setText("Tên đăng nhập: " + username);
        }
        if (avatarUrl != null) {
            Glide.with(this).load(avatarUrl).into(imageViewProfile);
        } else {
            imageViewProfile.setImageResource(R.drawable.pro_img); // ảnh mặc định
        }
    }
}
