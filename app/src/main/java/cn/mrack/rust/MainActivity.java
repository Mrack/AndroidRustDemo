package cn.mrack.rust;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cn.mrack.rust.databinding.ActivityMainBinding;

/**
 * @author Mrack
 * @date 2022/2/14
 */
public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("rustdemo");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    public native String stringFromJNI();

}