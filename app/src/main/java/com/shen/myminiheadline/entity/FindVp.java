package com.shen.myminiheadline.entity;

import java.util.List;

/**
 * Created by shgl1hz1 on 2017/6/30.
 */

public class FindVp {

    /**
     * status : true
     * count : 1
     * data : [{"Id":1,"title":"今日热榜","img_src":"http://imgcdn.lerays.com/donotdel/2016/12/12/c85597900de0a274b81e368dff20687f.png!theme","action":{"target":"_self","type":"inner","value":"","url":"http://app.lerays.com/?wtt_target_value=app&wtt_ios_activity=RankListVC&wtt_android_activity=RankActivity&wtt_app_args=type:day:s&wtt_display_title=今日热榜&wtt_need_auth=false"}},{"Id":2,"title":"本周热榜","img_src":"http://imgcdn.lerays.com/donotdel/2016/12/12/81cbf148cce758c9464d4c58fabf5e8d.png!theme","action":{"target":"_self","type":"inner","value":"","url":"http://app.lerays.com/?wtt_target_value=app&wtt_ios_activity=RankListVC&wtt_android_activity=RankActivity&wtt_app_args=type:week:s&wtt_display_title=本周热榜&wtt_need_auth=false"}},{"Id":1,"title":"本月热榜","img_src":"http://imgcdn.lerays.com/donotdel/2016/12/12/b0a95244d86b6f73242a6c6ceb3b3dcb.png!theme","action":{"target":"_self","type":"inner","value":"","url":"http://app.lerays.com/?wtt_target_value=app&wtt_ios_activity=RankListVC&wtt_android_activity=RankActivity&wtt_app_args=type:month:s&wtt_display_title=本月热榜&wtt_need_auth=false"}}]
     * ext : {"logo_title":"热榜推荐"}
     */

    private boolean status;
    private int count;
    private ExtBean ext;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ExtBean getExt() {
        return ext;
    }

    public void setExt(ExtBean ext) {
        this.ext = ext;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class ExtBean {
        /**
         * logo_title : 热榜推荐
         */

        private String logo_title;

        public String getLogo_title() {
            return logo_title;
        }

        public void setLogo_title(String logo_title) {
            this.logo_title = logo_title;
        }
    }

    public static class DataBean {
        /**
         * Id : 1
         * title : 今日热榜
         * img_src : http://imgcdn.lerays.com/donotdel/2016/12/12/c85597900de0a274b81e368dff20687f.png!theme
         * action : {"target":"_self","type":"inner","value":"","url":"http://app.lerays.com/?wtt_target_value=app&wtt_ios_activity=RankListVC&wtt_android_activity=RankActivity&wtt_app_args=type:day:s&wtt_display_title=今日热榜&wtt_need_auth=false"}
         */

        private int Id;
        private String title;
        private String img_src;
        private ActionBean action;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg_src() {
            return img_src;
        }

        public void setImg_src(String img_src) {
            this.img_src = img_src;
        }

        public ActionBean getAction() {
            return action;
        }

        public void setAction(ActionBean action) {
            this.action = action;
        }

        public static class ActionBean {
            /**
             * target : _self
             * type : inner
             * value :
             * url : http://app.lerays.com/?wtt_target_value=app&wtt_ios_activity=RankListVC&wtt_android_activity=RankActivity&wtt_app_args=type:day:s&wtt_display_title=今日热榜&wtt_need_auth=false
             */

            private String target;
            private String type;
            private String value;
            private String url;

            public String getTarget() {
                return target;
            }

            public void setTarget(String target) {
                this.target = target;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
