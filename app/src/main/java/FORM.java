import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import ir.pooyamoradi.isfahan_ziba.R;

/**
 * Created by Pooya on 1/21/2024.
 */

public class FORM {
    private Activity activity;
    private LinearLayout layoutFormExample;

    EditText editName, editPhone, editEmail, editMessage;
    CheckBox cbSharePhone;
    Button btnSubmit, btnBack;

    public FORM(Activity activity, int Id) {
        this.activity = activity;
        layoutFormExample = activity.findViewById(Id);
        initial();
    }

    public void initial() {
        if (layoutFormExample == null) {
            return;
        }
        editName = activity.findViewById(R.id.editName);
        editPhone = activity.findViewById(R.id.editPhone);
        editEmail = activity.findViewById(R.id.editEmail);
        editMessage = activity.findViewById(R.id.editMessage);
        cbSharePhone = activity.findViewById(R.id.cbsharePhone);
        btnSubmit = activity.findViewById(R.id.btnSubmit);
        btnBack = activity.findViewById(R.id.btnBack);
    }


}
