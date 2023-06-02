package com.example.pokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Permissions;
import java.text.SimpleDateFormat;
import java.util.Date;


public class KameraActivity extends AppCompatActivity {
    private static final String[] PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static final int REQUEST_CODE = 1;
    private Camera mCamera = null;
    private static Preview preview;
    private FrameLayout frameLayoutpreview;
    private ImageButton tombolgambar;
    private Camera.PictureCallback mPicture;
    private static String previewState =  "PREVIEW";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        frameLayoutpreview = findViewById(R.id.FrameLayout_preview);
        tombolgambar = findViewById(R.id.tombolgambar);

    }

    private boolean cekIzinDitolak() {
        for (int i = 0; i < PERMISSIONS.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(PERMISSIONS[i]) != PackageManager.PERMISSION_GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && cekIzinDitolak()) {
            requestPermissions(PERMISSIONS, REQUEST_CODE);
            return;
        }
        mCamera = getCamera();
        preview = new Preview(this, mCamera);
        frameLayoutpreview.addView(preview);

        mPicture = new Camera.PictureCallback(){
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                File pictureFile = getOutputMediaFile();
                if (pictureFile == null) {
                    Toast.makeText(KameraActivity.this, "Error creating media file, check storage permissions", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    FileOutputStream fos = new FileOutputStream(pictureFile);
                    fos.write(data);
                    fos.close();
                } catch (FileNotFoundException e) {
                    Toast.makeText(KameraActivity.this, "File not Found: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(KameraActivity.this, "Error Accesing File: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        };
        tombolgambar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch(previewState){
                    case "BUSY":
                        mCamera.startPreview();
                        previewState = "PREVIEW";
                        break;
                    case "PREVIEW":
                        mCamera.takePicture(null,null, mPicture);
                        previewState = "BUSY";
                        break;
                }
            }
        });

    }

    public Camera getCamera() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (Exception e) {
            Toast.makeText(this, "Kamera Tidak tersedia", Toast.LENGTH_SHORT).show();
        }
        return c;
    }

    private class Preview extends SurfaceView implements SurfaceHolder.Callback {
        SurfaceHolder mHolder;
        private Camera PrevCamera;

        public Preview(Context context, Camera camera) {
            super(context);
            PrevCamera = camera;
            mHolder = getHolder();
            mHolder.addCallback(this);
            mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder holder) {
            try {
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();
                mCamera.setDisplayOrientation(90);
            } catch (Exception e) {
                Toast.makeText(KameraActivity.this, "Faied to Open Camera" + e, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {


        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
            if (mCamera != null) {
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }
        }
    }
    private File getOutputMediaFile() {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/Aplikasi Kamera";
        File mediaStorageDir = new File(path);

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Toast.makeText(this, "failed to create directory", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");

        return mediaFile;

    }


}