package com.nontech.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCAdditionalInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization;
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType;
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz;
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener;

public class MainActivity2 extends AppCompatActivity implements SSLCTransactionResponseListener {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText= findViewById(R.id.edittext);
        button= findViewById(R.id.button1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount=editText.getText().toString();

                if (!amount.isEmpty()){

                    SSLCommerzInitialization initialization=new SSLCommerzInitialization(

                            "byteg66650a67207ba",
                            "byteg66650a67207ba@ssl",
                            Double.valueOf(amount),
                            SSLCCurrencyType.BDT,
                            String.valueOf(amount),
                            "fdefnv",
                            SSLCSdkType.TESTBOX


                    );

                    SSLCAdditionalInitializer additionalInitializer=new SSLCAdditionalInitializer();
                    additionalInitializer.setValueA("Value Option 1");
                    additionalInitializer.setValueB("Value Option 2");
                    additionalInitializer.setValueC("Value Option 3");
                    additionalInitializer.setValueD("Value Option 4");

                    IntegrateSSLCommerz.getInstance(MainActivity2.this)
                            .addAdditionalInitializer(additionalInitializer)
                            .addSSLCommerzInitialization(initialization)
                            .buildApiCall(MainActivity2.this);



                }else {
                    editText.setError("Error");
                }


            }
        });

    }

    @Override
    public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void transactionFail(String s) {
        Toast.makeText(this, s.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closed(String s) {
        Toast.makeText(this, s.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}