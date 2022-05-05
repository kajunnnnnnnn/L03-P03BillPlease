package sg.edu.rp.c346.id20026955.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText editAmount;
    EditText editPax;
    ToggleButton SVS;
    ToggleButton GST;
    EditText editDiscount;
    RadioGroup rgPayment;
    Button btnSplit;
    Button btnReset;
    TextView tvTotal;
    TextView tvEachPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAmount = findViewById(R.id.editAmount);
        editPax = findViewById(R.id.editPax);
        SVS = findViewById(R.id.tgbtnSVS);
        GST = findViewById(R.id.tgbtnGST);
        editDiscount = findViewById(R.id.editDiscount);
        rgPayment = findViewById(R.id.rgPaymentMethod);
        btnSplit = findViewById(R.id.buttonSplit);
        btnReset = findViewById(R.id.buttonReset);
        tvTotal = findViewById(R.id.tvTotal);
        tvEachPay = findViewById(R.id.tvEachPays);



        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amt = editAmount.getText().toString();
                double price=Double.parseDouble(amt);
                String pax = editPax.getText().toString();
                int NoOfPax = Integer.parseInt(pax);
                String discount = editDiscount.getText().toString();
                int dis = Integer.parseInt(discount);
                int selectedID = rgPayment.getCheckedRadioButtonId();

                if (SVS.isChecked() == true && GST.isChecked() == false) {
                    double newprice1 = price*(dis/100.0);
                    double newprice2 = price - newprice1;
                    double newprice3 = newprice2*1.1;
                    double newprice4 = newprice3/NoOfPax;

                    if (selectedID == R.id.rbtnCash) {
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice3));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " in cash.", newprice4));
                    }
                    else{
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice3));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " via Paynow to 91234567.",newprice3));
                    }
                }
                if (SVS.isChecked() == false && GST.isChecked() == true){
                    double newprice5 = price*(dis/100.0);
                    double newprice6 = price - newprice5;
                    double newprice7 = newprice6*1.07;
                    double newprice8 = newprice7/NoOfPax;

                    if (selectedID == R.id.rbtnCash) {
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice7));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " in cash.", newprice8));
                    }
                    else{
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice7));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " via Paynow to 91234567.", newprice8));
                    }
                }

                if (SVS.isChecked() == true && GST.isChecked() == true){
                    double newprice9 = price*(dis/100.0);
                    double newprice10 = price - newprice9;
                    double newprice11 = newprice10*1.1;
                    double newprice12 = newprice11*1.07;
                    double newprice13 = newprice12/NoOfPax;

                    if (selectedID == R.id.rbtnCash) {
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice12));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " in cash.", newprice13));
                    }
                    else{
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice12));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " via Paynow to 91234567.", newprice13));
                    }
                }
                if (SVS.isChecked() == false && GST.isChecked() == false){
                    double newprice14 = price*(dis/100.0);
                    double newprice15 = price - newprice14;
                    double newprice16 = newprice15/NoOfPax;

                    if (selectedID == R.id.rbtnCash) {
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice15));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " in cash.", newprice16));
                    }
                    else{
                        tvTotal.setText(String.format("Total Bill: $%.2f" , newprice15));
                        tvEachPay.setText(String.format("Each Pays: $%.2f" + " via Paynow to 91234567.", newprice16));
                    }
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAmount.setText("");
                editPax.setText("");
                editDiscount.setText("");
                tvTotal.setText("");
                tvEachPay.setText("");
            }
        });
    }
}