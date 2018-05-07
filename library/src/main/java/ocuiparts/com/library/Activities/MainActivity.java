package ocuiparts.com.library.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ocuiparts.com.library.Adapters.TimelineAdapter;
import ocuiparts.com.library.Base.BaseActivity;
import ocuiparts.com.library.Entity.TimelineEntity;
import ocuiparts.com.library.Interface.ClickInterface;
import ocuiparts.com.library.Interface.LoadMoreInterface;
import ocuiparts.com.library.Interface.OnTabBarItemClickListener;
import ocuiparts.com.library.R;
import ocuiparts.com.library.Utils.CorrectSizeUtil;
import ocuiparts.com.library.customView.OCUITabBar;

public class MainActivity extends BaseActivity implements OnTabBarItemClickListener {

    private OCUITabBar tabBar = null;
    private RecyclerView rcl_timeline;
    private TimelineAdapter mAdapter = null;
    private ArrayList<TimelineEntity> mArrTimeline = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabBar = (OCUITabBar) findViewById(R.id.tabBar);
        tabBar.setOnTabBarItemClickListener(this);

        rcl_timeline = (RecyclerView) findViewById(R.id.rcl_timeline);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rcl_timeline.setLayoutManager(lm);
        mArrTimeline = new ArrayList<TimelineEntity>();
        TimelineEntity entity = new TimelineEntity();
        TimelineEntity entity1 = new TimelineEntity();
        TimelineEntity entity2 = new TimelineEntity();
        mArrTimeline.add(entity);
        mArrTimeline.add(entity1);
        mArrTimeline.add(entity2);

        mAdapter = new TimelineAdapter(this, mArrTimeline, mLoadMore, mClickItem);
        rcl_timeline.setAdapter(mAdapter);
        CorrectSizeUtil.getInstance(this).correctSize(findViewById(R.id.rlt_root));

    }

    private ClickInterface mClickItem = new ClickInterface() {
        @Override
        public void onItemClick(int position) {
            Log.e("Click TimeLine ", position + "");
        }
    };


    @Override
    public void onHomeItemClick() {
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onChatItemClick() {
        Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCenterChatItemClick() {
        Toast.makeText(this, "CenterChat", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAlertItemClick() {
        Toast.makeText(this, "Alert", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onMyPageItemClick() {
        Toast.makeText(this, "MyPage", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onJobConsultationItemClik() {
        Toast.makeText(this, "Job Consultancy", Toast.LENGTH_SHORT).show();
        tabBar.toggleArcMenu();

    }

    @Override
    public void onHouseChatItemClick() {
        Toast.makeText(this, "House chat", Toast.LENGTH_SHORT).show();
        tabBar.toggleArcMenu();
    }

    @Override
    public void onBackPressed() {
        if (tabBar.isArcMenuOpened()) {
            tabBar.toggleArcMenu();
        } else {
            super.onBackPressed();
        }
    }

    private LoadMoreInterface mLoadMore = new LoadMoreInterface() {
        @Override
        public void onLoad() {
            getTimeLineData(false);
        }
    };

    private void getTimeLineData(boolean b) {

    }

}


