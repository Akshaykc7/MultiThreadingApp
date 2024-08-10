package com.example.multithreading;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2, tv3;
    private Button btnStart;
    private boolean boolbtn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning Layout elements
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        btnStart = findViewById(R.id.btnStart);

        // Button onClick action
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle Button (True/False)
                boolbtn = !boolbtn;

                if (!boolbtn) {
                    // Stopped state
                    tv1.setText("Stopped1");
                    tv2.setText("Stopped2");
                    tv3.setText("Stopped3");
                    btnStart.setText("Start");
                } else {
                    // Running state
                    btnStart.setText("Stop");

                    // Thread 1
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (boolbtn) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv1.setText("Started1");
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv1.setText("Activity1");
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();

                    // Thread 2
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (boolbtn) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv2.setText("Started2");
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv2.setText("Activity2");
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();

                    // Thread 3
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (boolbtn) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv3.setText("Started3");
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv3.setText("Activity3");
                                    }
                                });
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
                }
            }
        });
    }
}
