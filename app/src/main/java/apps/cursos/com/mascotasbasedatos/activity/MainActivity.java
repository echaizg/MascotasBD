package apps.cursos.com.mascotasbasedatos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.R;
import apps.cursos.com.mascotasbasedatos.adapter.PageAdapter;
import apps.cursos.com.mascotasbasedatos.vistafragment.MascotasRecyclerviewFragment;
import apps.cursos.com.mascotasbasedatos.vistafragment.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar ;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            toolbar.setTitle(R.string.my_activitymain_label);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // irMascotasFavoritasActivity();

            }
        });

        setUpViewPager();


    }
    private ArrayList<Fragment> agregarFragmnets(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add( new MascotasRecyclerviewFragment());
        fragments.add( new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragmnets()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tab_doghouse);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_dogface);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_contacto) {
            Intent intent = new Intent(this,ContactoActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_acercade) {
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_favoritos) {
            Intent intent = new Intent(this,MascotasFavoritasActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
