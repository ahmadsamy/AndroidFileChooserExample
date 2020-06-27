package ahmad.egypt.androidfilechooserexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ahmad.egypt.myfilechooser.FileChooserActivity;
import ahmad.egypt.myfilechooser.model.FileInfo;

public class MainActivity extends AppCompatActivity {

    TextView infoTV;
    int REQ_CODE=0x0001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTV=findViewById(R.id.info);

    }

    public void onBrowse(View v){
        startActivityForResult(new Intent(this, FileChooserActivity.class),REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_CODE){
            if(resultCode==RESULT_OK){
                FileInfo fileInfo=FileChooserActivity.getFileInfo(data);
                infoTV.setText(String.format("=>File name: %s\n=>File path: %s\n=>Dir path:%s",
                        fileInfo.getName(),fileInfo.getFullPath(),fileInfo.getDirPath()));
            }
        }
    }
}