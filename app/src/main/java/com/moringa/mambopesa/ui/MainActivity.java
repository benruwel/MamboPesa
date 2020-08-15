package com.moringa.mambopesa.ui;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.moringa.mambopesa.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.profileImage)
    ImageView mProfileImage;

    private FirebaseAuth firebaseAuth;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mButtonLogin.setOnClickListener(this);
        mProfileImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if(view == mButtonLogin) {
//            String username = mUsernameText.getText().toString();
//            String currencySymbol = mCurrencySymbol.getText().toString();
//            Intent intent = new Intent(MainActivity.this, RelatedCurrenciesListActivity.class);
//            intent.putExtra("username", username);
//            intent.putExtra("currencySymbol", currencySymbol);
//            startActivity(intent);
//        }

        if(view == mProfileImage) {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, mProfileImage);
            //inflating the popup using xml
            popupMenu.getMenuInflater().inflate(R.menu.menu_logout, popupMenu.getMenu());

            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    //we use a switch statement to handle the diff events of the various menu items
                    switch (menuItem.getItemId()) {
                        case R.id.action_logout:
                            logOutUser();
                            return true;
                        case R.id.action_profile:
                            Toast.makeText(MainActivity.this, R.string.great_things, Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                }
            });
        }
    }
    //method to logout user current session
    private void logOutUser() {
        FirebaseAuth.getInstance().signOut();
        //TODO change this to login activity after debugging
        Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}