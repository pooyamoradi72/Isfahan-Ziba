package ir.pooyamoradi.isfahan_ziba;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import ir.pooyamoradi.isfahan_ziba.LoginShowInfo;

/**
 * Created by Pooya on 1/21/2024.
 */

public class FormLogin implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Activity activity;
    private LinearLayout layoutFormExample;

    EditText editName, editPhone, editEmail, editMessage;
    CheckBox cbSharePhone;
    Button btnSubmit;

    public FormLogin(Activity activity, int Id) {
        this.activity = activity;
        layoutFormExample = activity.findViewById(Id);
        initial();
    }

    private void initial() {
        if (layoutFormExample == null) {
            return;
        }
        editName = activity.findViewById(R.id.editName);
        editPhone = activity.findViewById(R.id.editPhone);
        editEmail = activity.findViewById(R.id.editEmail);
        editMessage = activity.findViewById(R.id.editMessage);
        cbSharePhone = activity.findViewById(R.id.cbsharePhone);
        btnSubmit = activity.findViewById(R.id.btnSubmit);
        //////////////////////////
        btnSubmit.setOnClickListener(this);
        cbSharePhone.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnSubmit.getId()) {
            String name = editName.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String message = editMessage.getText().toString().trim();

            if (ValidInput(name, phone, email, message)) {
                // Toast.makeText(activity, "Thank's, your information is Valid.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, LoginShowInfo.class);
                intent.putExtra("name:", name);
                if (cbSharePhone.isChecked()) {
                    intent.putExtra("phone:", phone);
                }
                intent.putExtra("email:", email);
                intent.putExtra("message:", message);
                activity.startActivity(intent);

            }
        }
    }

    boolean ValidInput(String name, String phone, String email, String message) {
        if (name.length() < 3) {
            Toast.makeText(activity, "نام حداقل باید 3 کاراکتر باشد!", Toast.LENGTH_SHORT).show();
            editName.requestFocus();
            return false;
        }
        if (!phone.isEmpty() && (phone.length() != 11 || !phone.startsWith("09"))) {
            Toast.makeText(activity, "شماره تلفن معتبر نیست!", Toast.LENGTH_SHORT).show();
            editPhone.requestFocus();
            return false;
        }
        if (!email.contains("@") || (!email.contains(".")) || (email.lastIndexOf(".") < (email.lastIndexOf("@")))) {
            Toast.makeText(activity, "ایمیل معتبر نیست", Toast.LENGTH_SHORT).show();
            editEmail.requestFocus();
            return false;
        }
        return true;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == cbSharePhone.getId()) {
            editPhone.setEnabled(isChecked);
        }
    }
}
