package com.shen.myminiheadline.entity;

import java.util.List;

/**
 * Created by shgl1hz1 on 2017/6/29.
 */

public class CommonData {



    private boolean status;
    private int count;
    private DataBean data;
    private ExtBean ext;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ExtBean getExt() {
        return ext;
    }

    public void setExt(ExtBean ext) {
        this.ext = ext;
    }

    public static class DataBean {

        private int pageno;

        private String currsign;
        private int prevtime;
        private String prevsign;
        private int nexttime;
        private String nextsign;
        private List<ListBean> list;

        public int getPageno() {
            return pageno;
        }

        public void setPageno(int pageno) {
            this.pageno = pageno;
        }



        public String getCurrsign() {
            return currsign;
        }

        public void setCurrsign(String currsign) {
            this.currsign = currsign;
        }

        public int getPrevtime() {
            return prevtime;
        }

        public void setPrevtime(int prevtime) {
            this.prevtime = prevtime;
        }

        public String getPrevsign() {
            return prevsign;
        }

        public void setPrevsign(String prevsign) {
            this.prevsign = prevsign;
        }

        public int getNexttime() {
            return nexttime;
        }

        public void setNexttime(int nexttime) {
            this.nexttime = nexttime;
        }

        public String getNextsign() {
            return nextsign;
        }

        public void setNextsign(String nextsign) {
            this.nextsign = nextsign;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * Id : 163552
             * cate_id : 4
             * ncate_id : 0
             * src_id : 0
             * title : 孙俪邓超：婚姻中，“舒服”到底有多重要？
             * img_src : http://img3.lerays.com/stream/2017/02/23/91aa53d83438fbc0b25a3623179c718a.jpg!theme
             * has_attr : 1
             * img_position : null
             * summary :
             * src_link : null
             * is_rec : 0
             * pubtime : 1498226533
             * ack_code : pusbQjdv
             * visit_num : 4478
             * comment_num : 6
             * src_title :
             * cate_title : 她刊
             * is_hot : false
             * display : {"type":"visit_num","value":4478}
             * action : {"target":"_self","type":"inter","value":null}
             * has_image : true
             * has_video : false
             * is_promote : false
             * is_original : false
             * has_quiz : false
             * has_inter : false
             * is_trending : false
             * query_string : acm=none-54-163552-pusbQjdv&stream_id=163552&_ack=pusbQjdv
             */

            private String Id;
            private String cate_id;
            private String ncate_id;
            private String src_id;
            private String title;
            private String img_src;
            private String has_attr;
            private Object img_position;
            private String summary;
            private Object src_link;
            private String is_rec;
            private String pubtime;
            private String ack_code;
            private int visit_num;
            private String comment_num;
            private String src_title;
            private String cate_title;
            private boolean is_hot;
            private DisplayBean display;
            private ActionBean action;
            private boolean has_image;
            private boolean has_video;
            private boolean is_promote;
            private boolean is_original;
            private boolean has_quiz;
            private boolean has_inter;
            private boolean is_trending;
            private String query_string;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getCate_id() {
                return cate_id;
            }

            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }

            public String getNcate_id() {
                return ncate_id;
            }

            public void setNcate_id(String ncate_id) {
                this.ncate_id = ncate_id;
            }

            public String getSrc_id() {
                return src_id;
            }

            public void setSrc_id(String src_id) {
                this.src_id = src_id;
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

            public String getHas_attr() {
                return has_attr;
            }

            public void setHas_attr(String has_attr) {
                this.has_attr = has_attr;
            }

            public Object getImg_position() {
                return img_position;
            }

            public void setImg_position(Object img_position) {
                this.img_position = img_position;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public Object getSrc_link() {
                return src_link;
            }

            public void setSrc_link(Object src_link) {
                this.src_link = src_link;
            }

            public String getIs_rec() {
                return is_rec;
            }

            public void setIs_rec(String is_rec) {
                this.is_rec = is_rec;
            }

            public String getPubtime() {
                return pubtime;
            }

            public void setPubtime(String pubtime) {
                this.pubtime = pubtime;
            }

            public String getAck_code() {
                return ack_code;
            }

            public void setAck_code(String ack_code) {
                this.ack_code = ack_code;
            }

            public int getVisit_num() {
                return visit_num;
            }

            public void setVisit_num(int visit_num) {
                this.visit_num = visit_num;
            }

            public String getComment_num() {
                return comment_num;
            }

            public void setComment_num(String comment_num) {
                this.comment_num = comment_num;
            }

            public String getSrc_title() {
                return src_title;
            }

            public void setSrc_title(String src_title) {
                this.src_title = src_title;
            }

            public String getCate_title() {
                return cate_title;
            }

            public void setCate_title(String cate_title) {
                this.cate_title = cate_title;
            }

            public boolean isIs_hot() {
                return is_hot;
            }

            public void setIs_hot(boolean is_hot) {
                this.is_hot = is_hot;
            }

            public DisplayBean getDisplay() {
                return display;
            }

            public void setDisplay(DisplayBean display) {
                this.display = display;
            }

            public ActionBean getAction() {
                return action;
            }

            public void setAction(ActionBean action) {
                this.action = action;
            }

            public boolean isHas_image() {
                return has_image;
            }

            public void setHas_image(boolean has_image) {
                this.has_image = has_image;
            }

            public boolean isHas_video() {
                return has_video;
            }

            public void setHas_video(boolean has_video) {
                this.has_video = has_video;
            }

            public boolean isIs_promote() {
                return is_promote;
            }

            public void setIs_promote(boolean is_promote) {
                this.is_promote = is_promote;
            }

            public boolean isIs_original() {
                return is_original;
            }

            public void setIs_original(boolean is_original) {
                this.is_original = is_original;
            }

            public boolean isHas_quiz() {
                return has_quiz;
            }

            public void setHas_quiz(boolean has_quiz) {
                this.has_quiz = has_quiz;
            }

            public boolean isHas_inter() {
                return has_inter;
            }

            public void setHas_inter(boolean has_inter) {
                this.has_inter = has_inter;
            }

            public boolean isIs_trending() {
                return is_trending;
            }

            public void setIs_trending(boolean is_trending) {
                this.is_trending = is_trending;
            }

            public String getQuery_string() {
                return query_string;
            }

            public void setQuery_string(String query_string) {
                this.query_string = query_string;
            }

            public static class DisplayBean {
                /**
                 * type : visit_num
                 * value : 4478
                 */

                private String type;
                private int value;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class ActionBean {
                /**
                 * target : _self
                 * type : inter
                 * value : null
                 */

                private String target;
                private String type;
                private Object value;

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

                public Object getValue() {
                    return value;
                }

                public void setValue(Object value) {
                    this.value = value;
                }
            }
        }
    }

    public static class ExtBean {
        /**
         * c_time : 1498723201
         * trending_border : 6000
         * inter_url : http://app.lerays.com/stream/app/view?stream_id={stream_id}&_ack={ack_code}&from=wtt-app
         */

        private int c_time;
        private int trending_border;
        private String inter_url;

        public int getC_time() {
            return c_time;
        }

        public void setC_time(int c_time) {
            this.c_time = c_time;
        }

        public int getTrending_border() {
            return trending_border;
        }

        public void setTrending_border(int trending_border) {
            this.trending_border = trending_border;
        }

        public String getInter_url() {
            return inter_url;
        }

        public void setInter_url(String inter_url) {
            this.inter_url = inter_url;
        }
    }
}
