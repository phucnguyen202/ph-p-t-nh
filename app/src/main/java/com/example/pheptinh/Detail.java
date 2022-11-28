package com.example.pheptinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
        int thuchien;
        CardView btnTinh;
        EditText so1,so2,kqua;
        int s1,s2;
        long kq,kq2;
        float kq1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnTinh=(CardView)findViewById(R.id.btnTinh);
        so1=(EditText)findViewById(R.id.soThuNhat);
        so2=(EditText)findViewById(R.id.soThuHai);
        kqua=(EditText)findViewById(R.id.ketqua);


        thuchien=getIntent().getIntExtra("thuchien",0);
        if (thuchien!=4){
            btnTinh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (so1.getText().toString().isEmpty() || so2.getText().toString().isEmpty()){
                        Toast.makeText(Detail.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    }else{
                        s1= Integer.parseInt(so1.getText().toString());
                        s2= Integer.parseInt(so2.getText().toString());
                        switch (thuchien){
                            case 0:
                                kq=s1+s2;
                                kqua.setText("Kết quả phép tính: "+s1+" + "+s2+"= "+kq);
                                break;
                            case 1:
                                kq=s1-s2;
                                kqua.setText("Kết quả phép tính: "+s1+" - "+s2+"= "+kq);
                                break;
                            case 2:
                                kq=s1*s2;
                                kqua.setText("Kết quả phép tính: "+s1+" x "+s2+"= "+kq);
                                break;
                            case 3:
                                kq=s1 / s2;
                                kq2= s1 - s2*kq;
                                kqua.setText("Kết quả phép tính: "+s1+" / "+s2+"= "+kq+" dư "+kq2);
                                break;
                            case 4:
                                break;
                            case 5:
                                kq= (long) Math.pow(s1,s2);
                                kqua.setText("Kết quả phép tính: "+s1+" mũ "+s2+"= "+kq);
                                break;
                            default: break;

                        }
                    }
                }
            });
        }else{
            so2.setVisibility(View.GONE);
            btnTinh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (so1.getText().toString().isEmpty()){
                        Toast.makeText(Detail.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    }else{
                        if (thuchien==4){
                            s1= Integer.parseInt(so1.getText().toString());
                            System.out.println(s1);
                            kq1= (float) Math.log(s1);
                            kqua.setText("Kết quả phép tính: Log("+s1+") = "+kq1);
                        }else{
                            s1= Integer.parseInt(so1.getText().toString());
                            System.out.println(s1);
                            kq1= (float) Math.sqrt(s1);
                            kqua.setText("Kết quả phép tính căn bậc 2 của: "+s1+" = "+kq1);
                        }

                    }

                }
            });


        }


    }
}