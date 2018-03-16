package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Callable;

public class DetailViewActivity extends Activity {

    MyApplicationData context;
    Business receivedBusinessInfo;
    private EditText numberField, nameField, primaryBusinessField, addressField, provinceOrTerritoryField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = (MyApplicationData) getApplicationContext();

        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business) getIntent().getSerializableExtra("Business");

        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceOrTerritoryField = (EditText) findViewById(R.id.provinceOrTerritory);

        if (receivedBusinessInfo != null) {
            numberField.setText(receivedBusinessInfo.number);
            nameField.setText(receivedBusinessInfo.name);
            primaryBusinessField.setText(receivedBusinessInfo.primaryBusiness);
            addressField.setText(receivedBusinessInfo.address);
            provinceOrTerritoryField.setText(receivedBusinessInfo.provinceOrTerritory);
        }
    }

    /**
     * Retrieve data from the form fields shown and use it to update the record
     * in the database.
     */
    public void updateBusiness(View v) {
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String provinceOrTerritory = provinceOrTerritoryField.getText().toString();

        Business biz = new Business(
                number,
                name,
                primaryBusiness,
                address,
                provinceOrTerritory
        );
        context.firebaseReference.child(receivedBusinessInfo.key).setValue(biz);
        finish();
    }

    /**
     * Delete the show record.
     */
    public void eraseBusiness(View v) {
        context.firebaseReference.child(receivedBusinessInfo.key).removeValue();
        finish();
    }
}
