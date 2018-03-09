package animais.com.gabrielcouto.animais;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView cao;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;
    private MediaPlayer som;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciaObj();
        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);

    }

    public void instanciaObj(){
        cao = findViewById(R.id.imgCaoId);
        gato  = findViewById( R.id.imgGatoId);
        leao = findViewById(R.id.imgLeaoId);
        macaco = findViewById(R.id.imgMacacoId);
        ovelha = findViewById(R.id.imgOvelhaId);
        vaca = findViewById(R.id.imgVacaId);


    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.imgCaoId :
               som = MediaPlayer.create(MainActivity.this,R.raw.cao);
               tocarMusica();
               break;
           case R.id.imgGatoId:
               som = MediaPlayer.create(MainActivity.this,R.raw.gato);
               tocarMusica();
               break;
           case R.id.imgLeaoId:
               som = MediaPlayer.create(MainActivity.this,R.raw.leao);
               tocarMusica();
               break;
           case R.id.imgMacacoId:
               som = MediaPlayer.create(MainActivity.this,R.raw.macaco);
               tocarMusica();
               break;
           case R.id.imgOvelhaId:
               som = MediaPlayer.create(MainActivity.this,R.raw.ovelha);
               tocarMusica();
               break;
           case R.id.imgVacaId:
               som = MediaPlayer.create(MainActivity.this,R.raw.vaca);
               tocarMusica();
               break;
           default:
               break;

       }
    }
    private void tocarMusica(){
        if(som!=null){
            som.start();
            som.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    som.release();
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(som!= null){
            som.stop();
            som.release();
            som = null;
        }

    }
}
