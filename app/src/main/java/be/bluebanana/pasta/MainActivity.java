package be.bluebanana.pasta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if ((intent != null) && intent.hasExtra(Intent.EXTRA_TEXT)) {
            ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("EXTRA_TEXT",
                intent.getStringExtra(Intent.EXTRA_TEXT));
            clipboard.setPrimaryClip(clip);

            Toast.makeText(this, getString(R.string.confirmation), Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}