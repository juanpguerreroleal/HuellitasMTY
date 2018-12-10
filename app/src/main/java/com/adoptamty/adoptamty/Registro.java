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

import java.sql.SQLOutput;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText etemail, etpassword, etpassword2;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etemail = (EditText)findViewById(R.id.Correo);
        etpassword = (EditText)findViewById(R.id.Contraseña);
        etpassword2 = (EditText)findViewById(R.id.CC2);

        registrar = (Button)findViewById(R.id.Registrarse);
        registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String email = etemail.getText().toString();
        final String password = etpassword.getText().toString();
        final String password2 = etpassword2.getText().toString();

        Log.e("Registro", "Entra Onclick");

        if(password.equals(password2)){
            if( password.length() > 7){
            Response.Listener<String> respoListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("Registro",response);
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                        if (success) {
                            Intent intent = new Intent(Registro.this, Login.class);
                            Registro.this.startActivity(intent);
                            Log.e("Registro", "Entra Try");
                            Registro.this.finish();

                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                            builder.setMessage("Error")
                                    .setNegativeButton("Retry", null)
                                    .create().show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            RegisterRequest registerRequest = new RegisterRequest(email, password, respoListener);

            RequestQueue queue = Volley.newRequestQueue(Registro.this);
            queue.add(registerRequest);
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                builder.setMessage("La contraseña no es segura, define una contraseña de mas de 7 caracteres.")
                        .setNegativeButton("Entendido",null)
                        .create().show();
            }
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
            builder.setMessage("Las contraseñas no son iguales, debes de escribir en ambos campos la misma contraseña.")
                    .setNegativeButton("Entendido",null)
                    .create().show();
        }

    }
}