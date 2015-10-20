package com.example.artests.lesson1817keyboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long mButtonExitPressTime;
    private Button mButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        pressLongClickButton();
        findViewById(R.id.editText2).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    Toast.makeText(getApplicationContext(),R.string.focusMessage,Toast.LENGTH_SHORT).show();
                    ((EditText)findViewById(R.id.editText2)).setInputType(InputType.TYPE_CLASS_PHONE);
                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //openQuitDialog();
        doublePressButtonExit();
    }

    private void openQuitDialog(){
        AlertDialog.Builder quitDialog=new AlertDialog.Builder(MainActivity.this);
        quitDialog.setTitle(getString(R.string.titleDialogBack));

        quitDialog.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        quitDialog.show();
    }

    private void doublePressButtonExit(){
        if (mButtonExitPressTime+2000>System.currentTimeMillis()){
            finish();
            //super.onBackPressed();
        }
        else{
            Toast.makeText(this,getString(R.string.doubleExit),Toast.LENGTH_SHORT).show();

        }
        mButtonExitPressTime=System.currentTimeMillis();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this,getString(R.string.menuPressButton),Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_SEARCH:
                Toast.makeText(this,getString(R.string.searchPressButton),Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                event.startTracking();
                //Toast.makeText(this,getString(R.string.volumeUpPressButton),Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this,getString(R.string.volumeDownPressButton),Toast.LENGTH_SHORT).show();
                return false;

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this,getString(R.string.menuPressButtonLong),Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_SEARCH:
                Toast.makeText(this,getString(R.string.searchPressButtonLong),Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Toast.makeText(this,getString(R.string.volumeUpPressButtonLong),Toast.LENGTH_SHORT).show();
                return false;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this,getString(R.string.volumeDownPressButtonLong),Toast.LENGTH_SHORT).show();
                return false;

        }
        return super.onKeyLongPress(keyCode, event);
    }

    public void onClickButton1(View view) {
        InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        findViewById(R.id.editText2).clearFocus();
    }

    public void onClick(View view) {
        Toast.makeText(this, getString(R.string.simpleButtonPress), Toast.LENGTH_SHORT).show();
    }

    private void pressLongClickButton() {
        findViewById(R.id.button).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), getString(R.string.simpleButtonLongPress), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
