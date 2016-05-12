package com.example.jason.myapplearn.view;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jason.myapplearn.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DownloadmanagerActivity extends AppCompatActivity {

    static final String TAG = "DownloadmanagerActivity";
    private ImageView imgViewPic;
    private Button btnDownload;
    Context mContext;
    DownloadCompleteReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloadmanager);

        initView();
        mContext=this;
        final DownloadManager manager ;
        DownloadCompleteReceiver receiver;
        //获取下载服务
        manager =(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        receiver = new DownloadCompleteReceiver();
        registerReceiver(receiver, filter);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建下载请求
                DownloadManager.Request down=new DownloadManager.Request (Uri.parse("http://img1.3lian.com/2015/w2/60/d/41.jpg"));
                //下载图片
                down.setTitle("Downlaod Image");
                //设置允许使用的网络类型，这里是移动网络和wifi都可以
                down.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE|DownloadManager.Request.NETWORK_WIFI);
                //禁止发出通知，既后台下载
                down.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                //不显示下载界面
                down.setVisibleInDownloadsUi(false);
                //设置下载后文件存放的位置
                //down.setDestinationInExternalFilesDir(mContext, null, "pic.jpg");
                down.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "pic.jpg");
                //表示设置下载地址为sd卡的Trinea文件夹，文件名为MeiLiShuo.apk。
                down.setDestinationInExternalPublicDir("FILMS","pic.jpg");

                //equest.allowScanningByMediaScanner();表示允许MediaScanner扫描到这个文件，默认不允许。
                //request.setTitle(“MeiLiShuo”);设置下载中通知栏提示的标题
                //request.setDescription(“MeiLiShuo desc”);设置下载中通知栏提示的介绍
                //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                //表示下载进行中和下载完成的通知栏是否显示。默认只显示下载中通知。VISIBILITY_VISIBLE_NOTIFY_COMPLETED表示下载完成后显示通知栏提示。VISIBILITY_HIDDEN表示不显示任何通知栏提示，这个需要在AndroidMainfest中添加权限android.permission.DOWNLOAD_WITHOUT_NOTIFICATION.
                //request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                //表示下载允许的网络类型，默认在任何网络下都允许下载。有NETWORK_MOBILE、NETWORK_WIFI、NETWORK_BLUETOOTH三种及其组合可供选择。如果只允许wifi下载，而当前网络为3g，则下载会等待。
                //request.setAllowedOverRoaming(boolean allow)移动网络情况下是否允许漫游。
                //request.setMimeType(“application/com.trinea.download.file”);
                //设置下载文件的mineType。因为下载管理Ui中点击某个已下载完成文件及下载完成点击通知栏提示都会根据mimeType去打开文件，所以我们可以利用这个属性。比如上面设置了mimeType为application/com.trinea.download.file，我们可以同时设置某个Activity的intent-filter为application/com.trinea.download.file，用于响应点击的打开文件。
                //添加请求下载的网络链接的http头，比如User-Agent，gzip压缩等

                //将下载请求放入队列
                manager.enqueue(down);
            }
        });

    }

    private void initView(){
        imgViewPic=(ImageView)findViewById(R.id.imgViewPic);
        btnDownload=(Button)findViewById(R.id.btnDownload);
    }

    //接受下载完成后的intent
    class DownloadCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)){
                long downId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                //Log.v(TAG," download complete! id : "+downId);
                //Toast.makeText(context, intent.getAction()+"id : "+downId, Toast.LENGTH_SHORT).show();
                String imgPath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/download/pic.jpg";
                String path=Environment.getExternalStorageDirectory().getPath();
                Log.v(TAG," 内置存储内部卡路径1： "+ path);
                List extPaths = getExtSDCardPath();
                int num=extPaths.size();
                String spath="";
                for (int i=0;i<num;i++) {
                    spath=extPaths.get(i).toString();
                    Log.v(TAG," 外置存储内部卡路径1： "+ spath);
                }
                Toast.makeText(context, imgPath, Toast.LENGTH_LONG).show();
                spath=spath+"/FILMS/IMG20160406211225.jpg";
                //spath=getExternalSDCardDirectory().getAbsolutePath()+"/FILMS/IMG20160406211225.jpg";
                Log.v(TAG," 外置存储内部卡路径2： "+ spath);
                imgViewPic.setImageBitmap(getDiskBitmap(imgPath));
            }
        }
    }

    @Override
    protected void onResume() {
        registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if(receiver != null)unregisterReceiver(receiver);
        super.onDestroy();
    }

    private Bitmap getDiskBitmap(String pathString)
    {
        Bitmap bitmap = null;
        try
        {
            File file = new File(pathString);
            if(file.exists())
            {
                bitmap = BitmapFactory.decodeFile(pathString);
            }
        } catch (Exception e)
        {
            // TODO: handle exception
        }
        return bitmap;
    }


    public List getExtSDCardPath()
    {
        List lResult = new ArrayList();
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("mount");
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("extSdCard"))
                {
                    String [] arr = line.split(" ");
                    String path = arr[1];
                    File file = new File(path);
                    if (file.isDirectory())
                    {
                        lResult.add(path);
                    }
                }
            }
            isr.close();
        } catch (Exception e) {
        }
        return lResult;
    }

    public File getExternalSDCardDirectory()
    {
        File innerDir = Environment.getExternalStorageDirectory();
        File rootDir = innerDir.getParentFile();
        File firstExtSdCard = innerDir ;
        File[] files = rootDir.listFiles();
        for (File file : files) {
            if (file.compareTo(innerDir) != 0) {
                firstExtSdCard = file;
                break;
            }
        }
        //Log.i("2", firstExtSdCard.getAbsolutePath().toString());
        return firstExtSdCard;
    }


}
