package com.adoptamty.adoptamty;


import android.annotation.SuppressLint;

import android.os.Bundle;
import android.os.StrictMode;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


@SuppressLint("ValidFragment")
public class Formulario extends Fragment implements View.OnClickListener{
    private Button button;

    EditText d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d22, d27, d28, d31, d32, d33;

    CheckBox d191, d192, d193, d194, d201, d202, d211, d212, d231,d232, d241, d242, d243, d244, d251, d252, d261, d262, d291, d292, d293, d294, d295, d296, d301, d302;

    public Formulario() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_formulario, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        button = (Button)view.findViewById(R.id.button);

        d1 = (EditText)view.findViewById(R.id.d1);
        d2 = (EditText)view.findViewById(R.id.d2);
        d3 = (EditText)view.findViewById(R.id.d3);
        d4 = (EditText)view.findViewById(R.id.d4);
        d5 = (EditText)view.findViewById(R.id.d5);
        d6 = (EditText)view.findViewById(R.id.d6);
        d7 = (EditText)view.findViewById(R.id.d7);
        d8 = (EditText)view.findViewById(R.id.d8);
        d9 = (EditText)view.findViewById(R.id.d9);
        d10 = (EditText)view.findViewById(R.id.d10);
        d11 = (EditText) view.findViewById(R.id.d11);
        d12 = (EditText) view.findViewById(R.id.d12);
        d13 = (EditText) view.findViewById(R.id.d13);
        d14 = (EditText) view.findViewById(R.id.d14);
        d15 = (EditText) view.findViewById(R.id.d15);
        d16 = (EditText) view.findViewById(R.id.d16);
        d17 = (EditText) view.findViewById(R.id.d17);
        d18 = (EditText) view.findViewById(R.id.d18);
        d22 = (EditText) view.findViewById(R.id.d22);
        d27 = (EditText) view.findViewById(R.id.d27);
        d28 = (EditText) view.findViewById(R.id.d28);
        d31 = (EditText) view.findViewById(R.id.d31);
        d32 = (EditText) view.findViewById(R.id.d32);
        d33 = (EditText) view.findViewById(R.id.d33);

        d191 = (CheckBox) view.findViewById(R.id.d19_1);
        d192 = (CheckBox) view.findViewById(R.id.d19_2);
        d193 = (CheckBox) view.findViewById(R.id.d19_3);
        d194 = (CheckBox) view.findViewById(R.id.d19_4);

        d201 = (CheckBox) view.findViewById(R.id.d20_1);
        d202 = (CheckBox) view.findViewById(R.id.d20_2);

        d211 = (CheckBox) view.findViewById(R.id.d21_1);
        d212 = (CheckBox) view.findViewById(R.id.d21_2);

        d231 = (CheckBox) view.findViewById(R.id.d23_1);
        d232 = (CheckBox) view.findViewById(R.id.d23_2);

        d241 = (CheckBox) view.findViewById(R.id.d24_1);
        d242 = (CheckBox) view.findViewById(R.id.d24_2);
        d243 = (CheckBox) view.findViewById(R.id.d24_3);
        d244 = (CheckBox) view.findViewById(R.id.d24_4);

        d251 = (CheckBox) view.findViewById(R.id.d25_1);
        d252 = (CheckBox) view.findViewById(R.id.d25_2);

        d261 = (CheckBox) view.findViewById(R.id.d26_1);
        d262 = (CheckBox) view.findViewById(R.id.d26_2);

        d291 = (CheckBox) view.findViewById(R.id.d29_1);
        d292 = (CheckBox) view.findViewById(R.id.d29_2);
        d293 = (CheckBox) view.findViewById(R.id.d29_3);
        d294 = (CheckBox) view.findViewById(R.id.d29_4);
        d295 = (CheckBox) view.findViewById(R.id.d29_5);
        d296 = (CheckBox) view.findViewById(R.id.d29_6);

        d301 = (CheckBox) view.findViewById(R.id.d30_1);
        d302 = (CheckBox) view.findViewById(R.id.d30_2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String dato1 = d1.getText().toString();
                final String dato2 = d2.getText().toString();
                final String dato3 = d3.getText().toString();
                final String dato4 = d4.getText().toString();
                final String dato5 = d5.getText().toString();
                final String dato6 = d6.getText().toString();
                final String dato7 = d7.getText().toString();
                final String dato8 = d8.getText().toString();
                final String dato9 = d9.getText().toString();
                final String dato10 = d10.getText().toString();
                final String dato11 = d11.getText().toString();
                final String dato12 = d12.getText().toString();
                final String dato13 = d13.getText().toString();
                final String dato14 = d14.getText().toString();
                final String dato15 = d15.getText().toString();
                final String dato16 = d16.getText().toString();
                final String dato17 = d17.getText().toString();
                final String dato18 = d18.getText().toString();
                final String dato22 = d22.getText().toString();
                final String dato27 = d27.getText().toString();
                final String dato28 = d28.getText().toString();
                final String dato31 = d31.getText().toString();
                final String dato32 = d32.getText().toString();
                final String dato33 = d33.getText().toString();


                final String dato191 = Boolean.toString(d191.isChecked());
                final String dato192 = Boolean.toString(d192.isChecked());
                final String dato193 = Boolean.toString(d193.isChecked());
                final String dato194 = Boolean.toString(d194.isChecked());

                final String dato201 = Boolean.toString(d201.isChecked());
                final String dato202= Boolean.toString(d202.isChecked());

                final String dato211 = Boolean.toString(d211.isChecked());
                final String dato212 = Boolean.toString(d212.isChecked());

                final String dato231 = Boolean.toString(d231.isChecked());
                final String dato232 = Boolean.toString(d232.isChecked());

                final String dato241 = Boolean.toString(d241.isChecked());
                final String dato242 = Boolean.toString(d242.isChecked());
                final String dato243 = Boolean.toString(d243.isChecked());
                final String dato244 = Boolean.toString(d244.isChecked());

                final String dato251 = Boolean.toString(d251.isChecked());
                final String dato252 = Boolean.toString(d252.isChecked());

                final String dato261 = Boolean.toString(d261.isChecked());
                final String dato262 = Boolean.toString(d262.isChecked());

                final String dato291 = Boolean.toString(d291.isChecked());
                final String dato292 = Boolean.toString(d292.isChecked());
                final String dato293 = Boolean.toString(d293.isChecked());
                final String dato294 = Boolean.toString(d294.isChecked());
                final String dato295 = Boolean.toString(d295.isChecked());
                final String dato296 = Boolean.toString(d296.isChecked());

                final String dato301 = Boolean.toString(d301.isChecked());
                final String dato302 = Boolean.toString(d302.isChecked());

                new Thread(new Runnable() {
                    public void run() {

                        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                        String url = "https://adopta-mty.000webhostapp.com/generar.php";
                        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>()
                                {
                                    @Override
                                    public void onResponse(String response) {
                                        // response
                                        Log.d("Response", response);
                                        Toast.makeText(getActivity(),"Peticion generada correctamente",Toast.LENGTH_SHORT).show();
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        // error
                                        Log.d("Error.Response", error.toString());
                                    }
                                }
                        ) {
                            @Override
                            protected Map<String, String> getParams()
                            {
                                Map<String, String>  params = new HashMap<String, String>();
                                params.put("d1", dato1);
                                params.put("d2", dato2);
                                params.put("d3", dato3);
                                params.put("d4", dato4);
                                params.put("d5", dato5);
                                params.put("d6", dato6);
                                params.put("d7", dato7);
                                params.put("d8", dato8);
                                params.put("d9", dato9);
                                params.put("d10", dato10);
                                params.put("d11", dato11);
                                params.put("d12", dato12);
                                params.put("d13", dato13);
                                params.put("d14", dato14);
                                params.put("d15", dato15);
                                params.put("d16", dato16);
                                params.put("d17", dato17);
                                params.put("d18", dato18);
                                params.put("d22", dato22);
                                params.put("d27", dato27);
                                params.put("d28", dato28);
                                params.put("d31", dato31);
                                params.put("d32", dato32);
                                params.put("d33", dato33);
                                params.put("d191", dato191);
                                params.put("d192", dato192);
                                params.put("d193", dato193);
                                params.put("d194", dato194);
                                params.put("d201", dato201);
                                params.put("d202", dato202);
                                params.put("d211", dato211);
                                params.put("d212", dato212);
                                params.put("d231", dato231);
                                params.put("d232", dato232);
                                params.put("d241", dato241);
                                params.put("d242", dato242);
                                params.put("d243", dato243);
                                params.put("d244", dato244);
                                params.put("d251", dato251);
                                params.put("d252", dato252);
                                params.put("d261", dato261);
                                params.put("d262", dato262);
                                params.put("d291", dato291);
                                params.put("d292", dato292);
                                params.put("d293", dato293);
                                params.put("d294", dato294);
                                params.put("d295", dato295);
                                params.put("d296", dato296);
                                params.put("d301", dato301);
                                params.put("d302", dato302);
                                return params;
                            }
                        };
                        queue.add(postRequest);
                    }}).start();
            }
        });
        return view;

    }
    @Override
    public void onClick(View v) {

    }
}