package com.example.test.bean;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public DataBean(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public DataBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public static List<DataBean> getTestData3() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("https://img-blog.csdnimg.cn/20200524220705330.png", null, 1));
        list.add(new DataBean("https://img-blog.csdnimg.cn/20200524220705336.png", null, 1));
        list.add(new DataBean("https://img.zcool.cn/community/01f8735e27a174a8012165188aa959.jpg", null, 1));
        list.add(new DataBean("https://img-blog.csdnimg.cn/20200524220705336.png", null, 1));
        return list;
    }

}
