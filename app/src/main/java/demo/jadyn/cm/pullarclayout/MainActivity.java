package demo.jadyn.cm.pullarclayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a520wcf.yllistview.YLListView;

public class MainActivity extends AppCompatActivity {

    private YLListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (YLListView) findViewById(R.id.listView);
        View topView=View.inflate(this,R.layout.top,null);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 550);
        topView.setLayoutParams(params);
        listView.addHeaderView(topView);
        listView.setAdapter(new DemoAdapter());
    }


    class DemoAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 20;
        }
        @Override
        public Object getItem(int position) {
            return position;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            if(convertView!=null&&convertView instanceof TextView){
                tv= (TextView) convertView;
            }else{
                tv=new TextView(getApplicationContext());
                tv.setTextColor(Color.BLACK);
                tv.setBackgroundColor(Color.WHITE);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
            }
            tv.setText(String.format("位置%d", position));
            return tv;
        }

    }
}
