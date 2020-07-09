package com.lgt.nimbus.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lgt.nimbus.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityRegistration extends AppCompatActivity {
    EditText etReferralId, etSponsorName, etFullName, etCountryCode, etMobileNumber, etEmailAddress, etPassword, etReEnterPassword;
    Spinner spPosition, spCountryName;
    Button btn_user_registration;
    CheckBox chkCondition;
    // spinner list
    List<String> position = new ArrayList<>();
    String[] country;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //init
        chkCondition = findViewById(R.id.chkCondition);
        etReferralId = findViewById(R.id.etReferralId);
        etSponsorName = findViewById(R.id.etSponsorName);
        etFullName = findViewById(R.id.etFullName);
        etCountryCode = findViewById(R.id.etCountryCode);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        etEmailAddress = findViewById(R.id.etEmailAddress);
        etPassword = findViewById(R.id.etPassword);
        etReEnterPassword = findViewById(R.id.etReEnterPassword);
        spPosition = findViewById(R.id.spPosition);
        spCountryName = findViewById(R.id.spCountryName);
        btn_user_registration = findViewById(R.id.btn_user_registration);
        // add position
        position.add("-Select Position-");
        position.add("Left");
        position.add("Right");
        // add country
        country = new String[]{"-Select Country-", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Anguilla", "Antigua &amp; Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia &amp; Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Cape Verde", "Cayman Islands", "Chad", "Chile", "China", "Colombia", "Congo", "Cook Islands", "Costa Rica", "Cote D Ivoire", "Croatia", "Cruise Ship", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Estonia", "Ethiopia", "Falkland Islands", "Faroe Islands", "Fiji", "Finland", "France", "French Polynesia", "French West Indies", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kuwait", "Kyrgyz Republic", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Mauritania", "Mauritius", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Namibia", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Pierre &amp; Miquelon", "Samoa", "San Marino", "Satellite", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "South Africa", "South Korea", "Spain", "Sri Lanka", "St Kitts &amp; Nevis", "St Lucia", "St Vincent", "St. Lucia", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor L'Este", "Togo", "Tonga", "Trinidad &amp; Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks &amp; Caicos", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Venezuela", "Vietnam", "Virgin Islands (US)", "Yemen", "Zambia", "Zimbabwe"};
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, position);
        ArrayAdapter<String> CountryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, country);
        // Drop down layout style
        spPosition.setPrompt("Select Position");
        spPosition.setAdapter(dataAdapter);
        // add country
        spCountryName.setPrompt("Select Country");
        spCountryName.setAdapter(CountryAdapter);
        // set Color in text
        spCountryName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    if (i == 0) {
                        TextView tv = (TextView) adapterView.getChildAt(0);
                        tv.setTextColor(Color.parseColor("#959595"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    if (i == 0) {
                        TextView tv = (TextView) adapterView.getChildAt(0);
                        tv.setTextColor(Color.parseColor("#959595"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // new registration
        btn_user_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validate form filed
                if (checkValidation()) {
                    // api code here
                    submitRegistration();
                } else {
                    // alert
                }
            }
        });
    }

    private void submitRegistration() {
        startActivity(new Intent(ActivityRegistration.this,MainActivity.class));
        finishAffinity();
    }

    private boolean checkValidation() {

        if (etReferralId.getText().toString().isEmpty()) {
            if (etReferralId.getText().toString().trim().length() < 12) {
                etReferralId.setError("Enter Valid Referral ID");
                etReferralId.requestFocus();
                return false;
            }
        }

        if (etSponsorName.getText().toString().trim().isEmpty()) {
            etSponsorName.setError("Enter Sponsor Name");
            etSponsorName.requestFocus();
            return false;
        }

        if (spPosition.getSelectedItem().toString().trim().equals("-Select Position-")) {
            Toast.makeText(this, "Select Position", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etFullName.getText().toString().trim().isEmpty()) {
            etFullName.setError("Enter Name");
            etFullName.requestFocus();
            return false;
        }

        if (etCountryCode.getText().toString().isEmpty()) {
            etCountryCode.setError("Enter Valid Code");
            etCountryCode.requestFocus();
            return false;
        }

        if (spCountryName.getSelectedItem().toString().trim().equals("-Select Country-")) {
            Toast.makeText(this, "Select Country", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!etMobileNumber.getText().toString().trim().isEmpty()) {
            if (etMobileNumber.getText().toString().trim().length() != 10) {
                etMobileNumber.setError("Enter Valid Number");
                etMobileNumber.requestFocus();
                return false;
            }
            return false;
        }

        if (!etEmailAddress.getText().toString().trim().isEmpty()) {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(etEmailAddress.getText().toString().trim()).matches()) {
                etEmailAddress.setError("Enter Valid Email");
                etEmailAddress.requestFocus();
            }
        }

        if (!etPassword.getText().toString().trim().isEmpty()) {
            if (!etReEnterPassword.getText().toString().trim().isEmpty()) {
                if (!etPassword.getText().toString().trim().equals(etReEnterPassword.getText().toString().trim())) {
                    Toast.makeText(this, "Password Not Match!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                etReEnterPassword.setError("Renter Password");
                etReEnterPassword.requestFocus();
                return false;
            }
        } else {
            etPassword.setError("Enter Password");
            etPassword.requestFocus();
            return false;
        }

        if (chkCondition.isChecked() == false) {
            Toast.makeText(this, "Please Check Term & Condition!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ActivityRegistration.this, LoginActivity.class));
        finishAffinity();
    }
}