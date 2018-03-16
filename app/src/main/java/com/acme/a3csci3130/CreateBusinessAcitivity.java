package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateBusinessAcitivity extends Activity {

    private Button submitButton;
    private EditText numberField, nameField, primaryBusinessField, addressField, provinceOrTerritoryField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_acitivity);
        appState = ((MyApplicationData) getApplicationContext());

        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceOrTerritoryField = (EditText) findViewById(R.id.provinceOrTerritory);
    }

    /** Submits the data and creates the record  */
    public void submitInfoButton(View v) {
        String businessID = appState.firebaseReference.push().getKey();

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

        appState.firebaseReference.child(businessID).setValue(biz);
        finish();
    }
}
