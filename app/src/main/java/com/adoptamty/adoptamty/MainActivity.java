package com.adoptamty.adoptamty;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.github.snowdream.android.widget.SmartImageView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;
    private ListView listView;
    private BottomNavigationView bottomNavigationView;

    ArrayList thenombre = new ArrayList();
    ArrayList thedescripcion = new ArrayList();
    ArrayList theimagen = new ArrayList();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        infoTextView = (TextView) findViewById(R.id.activity_main_cachorros);
        listView = (ListView) findViewById(R.id.listView);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.gatos) {
                    removeAllFragments( getSupportFragmentManager() );
                    resetActivity();
                    descargarGatos();
            } else if (item.getItemId() == R.id.Perros) {
                    removeAllFragments( getSupportFragmentManager() );
                    resetActivity();
                    descargarPerros();
            } else if (item.getItemId() == R.id.Reportes) {
                    removeAllFragments( getSupportFragmentManager() );
                    resetActivity();
                    addFragment(new Formulario(),true,"form");
                }
                else if (item.getItemId() == R.id.Contact1) {
                    removeAllFragments( getSupportFragmentManager() );
                    resetActivity();
                    addFragment2(new Contacto(),true,"form");
                }
                return true;
            }
        });
    }
    public void descargarPerros(){
        thenombre.clear();
        thedescripcion.clear();
        theimagen.clear();

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Cargando Datos...");
        progressDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://adopta-mty.000webhostapp.com/listado.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200) {
                    progressDialog.dismiss();
                    try {


                        JSONArray jsonArray = new JSONArray(new String(responseBody));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            thenombre.add(jsonArray.getJSONObject(i).getString("nombre"));
                            thedescripcion.add(jsonArray.getJSONObject(i).getString("descripcion"));
                            theimagen.add(jsonArray.getJSONObject(i).getString("imagen"));
                        }
                        listView.setAdapter(new ImagenAdapter(getApplicationContext()));
                } catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
private class ImagenAdapter extends BaseAdapter{
    Context ctx;
    LayoutInflater layoutInflater;
    SmartImageView smartImageView;
    TextView tvnombre, tvdescripcion;

    public ImagenAdapter(Context applicationContext){
        this.ctx = applicationContext;
        layoutInflater= (LayoutInflater)ctx.getSystemService(LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return theimagen.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewGroup viewGroup = (ViewGroup)layoutInflater.inflate(R.layout.activity_main_cachorros,null);


        smartImageView = (SmartImageView)viewGroup.findViewById(R.id.imagenP);
        tvnombre = (TextView)viewGroup.findViewById(R.id.tvnombre);
        tvdescripcion = (TextView)viewGroup.findViewById(R.id.tvdescripcion);

        String urlfinal = "https://adopta-mty.000webhostapp.com/Adopta un perro/"+theimagen.get(position).toString();
        Rect rect = new Rect(smartImageView.getLeft(), smartImageView.getTop(), smartImageView.getRight(), smartImageView.getBottom());
                smartImageView.setImageUrl(urlfinal, rect);
                tvnombre.setText(thenombre.get(position).toString());
                tvdescripcion.setText(thedescripcion.get(position).toString());
        return viewGroup;
    }
}
public void resetActivity(){
    ViewGroup myView = (ViewGroup) findViewById(R.id.activity_main_cachorros);
    if (myView != null) {
        ViewGroup parent = (ViewGroup) myView.getParent();
        parent.removeAllViewsInLayout();
        }
}

    public void descargarGatos(){
        thenombre.clear();
        thedescripcion.clear();
        theimagen.clear();

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Cargando Datos...");
        progressDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://adopta-mty.000webhostapp.com/listado2.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200) {
                    progressDialog.dismiss();
                    try {
                        JSONArray jsonArray = new JSONArray(new String(responseBody));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            thenombre.add(jsonArray.getJSONObject(i).getString("nombre"));
                            thedescripcion.add(jsonArray.getJSONObject(i).getString("descripcion"));
                            theimagen.add(jsonArray.getJSONObject(i).getString("imagen"));
                        }
                        listView.setAdapter(new ImagenAdapter(getApplicationContext()));
                    } catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    private class formul extends BaseAdapter{
        LayoutInflater layoutInflater;
        SmartImageView smartImageView;

        @Override
        public int getCount() {
            return theimagen.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewGroup viewGroup = (ViewGroup)layoutInflater.inflate(R.layout.activity_formulario,null);

            return viewGroup;
        }
    }
    public void addFragment(Formulario fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.vistform, fragment, tag);
        ft.commitAllowingStateLoss();
    }
    private static void removeAllFragments(FragmentManager fragmentManager) {
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

        public void addFragment2(Contacto fragment, boolean addToBackStack, String tag) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();

            if (addToBackStack) {
                ft.addToBackStack(tag);
            }
            ft.replace(R.id.vistform, fragment, tag);
            ft.commitAllowingStateLoss();
        }
        private static void removeAllFragments1(FragmentManager fragmentManager) {
            while (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStackImmediate();
            }
        }
}


