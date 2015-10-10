package document.igt.com.androidnewrecycler;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;

import document.igt.com.androidnewrecycler.Constants.ApiConstants;
import document.igt.com.androidnewrecycler.R;

public class RechargeAllActivity extends AppCompatActivity {

    
    private TextView mRechargeType;
    private RadioGroup mRadioType;
    private Spinner mOperator;
    private EditText mUniqueNumber;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_all);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar_recharge);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mRechargeType = (TextView) findViewById(R.id.txv_rechargeType);
        mRadioType = (RadioGroup) findViewById(R.id.rechargeType);
        mOperator = (Spinner) findViewById(R.id.spnOperator);
        mUniqueNumber = (EditText) findViewById(R.id.edtNumber);
        Bundle type = getIntent().getExtras();
        int rechargetype = type.getInt(ApiConstants.RECHARGE_TYPE);

        setValuesToControls(rechargetype);
    }

    public void setValuesToControls(int rechargeType) {
        switch (rechargeType) {
            case 0:
                mRechargeType.setText(getResources().getString(R.string.txv_recharge_dth));
                mUniqueNumber.setHint("Subscriber ID");
                String listOperators[] = {"Airtel Digital TV", "Dish TV", "Reliance Digital TV", "Sun Direct", "Tata Sky", "Videocon d2h"};
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOperators);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mOperator.setAdapter(adapter);
                mRadioType.setVisibility(View.INVISIBLE);
                break;
            case 1:
                mRechargeType.setText(getResources().getString(R.string.txv_recharge_bills));
                mUniqueNumber.setHint("Enter Data Card Number");
                String list[] = {"Airtel", "BSNL", "MTNL", "MTS MBlaze", "Reliance NetConnect+", "Tata Photon Plus", "Tata Photon whiz"};
                ArrayAdapter<String> adapterBroadband = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
                adapterBroadband.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mOperator.setAdapter(adapterBroadband);
                break;
            case 2:
                mRechargeType.setText(getResources().getString(R.string.txv_recharge_landline_broadband));
                mUniqueNumber.setHint("STD Code & Landline Number");
                String listOfLandlineOperator[] = {"Airtel Landline", "Tata Teleservices"};
                ArrayAdapter<String> adapterLandlineOperator = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOfLandlineOperator);
                adapterLandlineOperator.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mOperator.setAdapter(adapterLandlineOperator);
                mRadioType.setVisibility(View.INVISIBLE);
                break;
            case 3:
                mRechargeType.setText(getResources().getString(R.string.txv_recharge_electricity));
                mUniqueNumber.setHint("Enter Consumer Account (CA) no");
                String listOfLandlineOperatorElectricity[] = {"BESE Rajdhani - Delhi"};
                ArrayAdapter<String> adapterLandlineOperatorElectricity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOfLandlineOperatorElectricity);
                adapterLandlineOperatorElectricity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mOperator.setAdapter(adapterLandlineOperatorElectricity);
                mRadioType.setVisibility(View.INVISIBLE);
                break;
            case 4:
                mRechargeType.setText(getResources().getString(R.string.txv_recharge_gas));
                mUniqueNumber.setHint("Enter Customer Account (CA) Number");
                String listOfLandlineOperatorGas[] = {"Mahanagar gas -  Mumbai", "Siti Energy Ltd."};
                ArrayAdapter<String> adapterLandlineOperatorGas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listOfLandlineOperatorGas);
                adapterLandlineOperatorGas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mOperator.setAdapter(adapterLandlineOperatorGas);
                mRadioType.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recharge_all, menu);
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
        else if(id==android.R.id.home)
        {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }

        return super.onOptionsItemSelected(item);
    }
}
