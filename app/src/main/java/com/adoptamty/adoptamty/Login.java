package com.adoptamty.adoptamty;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button registrar;
    private Button acceso;

    EditText etpassword, etemail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginn);

        etemail = (EditText) findViewById(R.id.email);
        etpassword = (EditText) findViewById(R.id.password);

        registrar = (Button) findViewById(R.id.email_register_in_button);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg();
            }
        });
        acceso = (Button) findViewById(R.id.email_sign_in_button);
        acceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etemail.getText().toString();
                final String password = etpassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String email = jsonResponse.getString("email");

                                Log.e("Registro", "Entra Try");
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                intent.putExtra("email", email);
                                intent.putExtra("password", password);
                                Login.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage("Error. Probablemente estas introduciendo una contrasena erronea.")
                                        .setNegativeButton("Retry", null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(loginRequest);

            }
        });
    }

    public void reg() {
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
        Login.this.finish();
    }

    @Override
    public void onClick(View v) {

    }
}