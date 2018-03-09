package hamano.masashi.health_check;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        myListView = findViewById( R.id.myListView );

        //②データを装備(今回はArrayリストにUserを入れる)
        ArrayList<User> users = new ArrayList<>(  );

        int[] icons ={R.drawable.bmi, R.drawable.rohrer, R.drawable.kaup, R.drawable.tall, R.drawable.blood, R.drawable.bmr};
//        String[]names ={"大人の肥満度","学童の肥満度","乳幼児の発育状態","子供の身長予測","血液型の確率","基礎代謝量"};
//        String[]exp = {"BMI(16歳以上〜)","ローレル指数(6歳〜12歳)","カウプ指数(3ヶ月～5歳)","両親の身長から予測","両親の血液型から測定","BMRを計算"};

        String[]names ={"The degree of obesity of an adult","The degree of obesity of schoolchildren","Infant development","Child's height estimation","Probability of blood type","Basal metabolic rate"};
        String[]exp = {"BMI(over 16 years old)","Rohrer index (6 to 12 years old)","Kaup index (3 months to 5 years old)","Forecast from parents' height","Measured from parents' blood type","Calculate BMR"};



        //for文で1度回す
        for (int i = 0; i < icons.length; i++){
            //userをインスタンス化
            User user = new User();
            //BitmapFactoryで画像を縮小してsetで読み込む
            user.setIcon( BitmapFactory.decodeResource( getResources(),icons[i] ));
            user.setName(names[i]);
            user.setExp(exp[i]);
            users.add( user );
        }

        //③Adapterを用意、データが複雑のためArrayAdapterを継承して、UserAdapterを作る
        UserAdapter adapter = new UserAdapter(this,0,users);

        //⑦ListViewに(adapterを)表示
        myListView.setAdapter( adapter );

        //⑧画面遷移
        myListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
              AdapterView<?>adapterView, View view, int position, long id) {



                //リストビューの場合、idではなくpositionを設定する
                switch (position)
                {
                    case 0:
                        Intent intent1 = new Intent( getApplicationContext(),bmiActivity.class );
                        intent1.putExtra( "bmi",position );
                        startActivity( intent1 );
                        break;

                    case 1:
                        Intent intent2 = new Intent( getApplicationContext(),RohrerActivity.class );
                        intent2.putExtra( "roh",position );
                        startActivity( intent2 );
                        break;

                    case 2:
                        Intent intent3 = new Intent( getApplicationContext(),KaupActivity.class );
                        intent3.putExtra( "kaup",position );
                        startActivity( intent3 );
                        break;

                    case 3:
                        Intent intent4 = new Intent( getApplicationContext(),TallActivity.class );
                        intent4.putExtra( "tall",position );
                        startActivity( intent4 );
                        break;

                    case 4:
                        Intent intent5 = new Intent( getApplicationContext(),BloodActivity.class );
                        intent5.putExtra( "blood",position );
                        startActivity( intent5 );
                        break;

                    case 5:
                        Intent intent6 = new Intent( getApplicationContext(),BmrActivity.class );
                        intent6.putExtra( "bmr",position );
                        startActivity( intent6 );
                        break;

                }
            }
        } );
    }


    //④UserAdapterを作る
    public class UserAdapter extends ArrayAdapter<User> {
        //LayoutInflater→動的にLayout.xmlファイルをセットすることができる。
        private LayoutInflater layoutInflater;//メンバ変数を宣言

        //コンストラクタを作る
        public UserAdapter(Context c, int id, ArrayList<User> users) {
            //親クラスのコンストラクタを呼ぶ
            super( c, id, users );
            this.layoutInflater = (LayoutInflater) c.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        }

        //⑤getViewをoverrideする
        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {
            //再利用できるviewがあるかどうかを判断
            if (convertView == null) {
                //nullだった場合には layoutInflatorでViewを作る
                convertView = layoutInflater.inflate(
                        //作ったものをconvertView に入れる
                        R.layout.list_item, parent, false
                );
            }
          //⑥convertViewにUserのデータをsetして、返す
            User user = (User) getItem( pos );//getItemはadapterが持つメソッドでviewが呼ばれたアイテムを取得する
            ((ImageView) convertView.findViewById( R.id.icon )).setImageBitmap( user.getIcon() );
            ((TextView) convertView.findViewById( R.id.name )).setText( user.getName() );
            ((TextView) convertView.findViewById( R.id.exp )).setText( user.getExp() );
            return convertView;
        }
    }

    //①Userクラスを作る(構造が複雑のため)
    public class User {
        //メンバ変数を宣言
        private Bitmap icon;
        private String name;
        private String exp;

        //↑のメンバ変数にアクセスするためのgetterとsetterが必要
        public Bitmap getIcon() {
            return icon;
        }
        public void setIcon(Bitmap icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getExp() {
            return exp;
        }
        public void setExp(String exp) {
            this.exp = exp;
        }

    }

}


//list item　に日本語を入力して試す。

//I want to display up to the second decimal places.
//I want to localize the list view array.

//少数代第2まで
//配列の多言語化(リストビュー)

//血液型ロジック
//BMR

