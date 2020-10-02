package widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class LoginButton extends androidx.appcompat.widget.AppCompatButton {


    public LoginButton(Context context) {
        super(context);
    }

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
