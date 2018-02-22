package com.example.douyinapp.bean;

import java.util.List;


public class ShowBean {

    private ExtraBean extra;
    private int status_code;
    private List<BannerBean> banner;

    public ExtraBean getExtra() {
        return extra;
    }

    public void setExtra(ExtraBean extra) {
        this.extra = extra;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public static class ExtraBean {
        /**
         * fatal_item_ids : []
         * logid : 20180112185034010010057237882284
         * now : 1515754234899
         */

        private String logid;
        private long now;
        private List<?> fatal_item_ids;

        public String getLogid() {
            return logid;
        }

        public void setLogid(String logid) {
            this.logid = logid;
        }

        public long getNow() {
            return now;
        }

        public void setNow(long now) {
            this.now = now;
        }

        public List<?> getFatal_item_ids() {
            return fatal_item_ids;
        }

        public void setFatal_item_ids(List<?> fatal_item_ids) {
            this.fatal_item_ids = fatal_item_ids;
        }
    }

    public static class BannerBean {
        /**
         * banner_url : {"uri":"573b00027992d9665a44","url_list":["https://p1.pstatp.com/obj/573b00027992d9665a44","https://pb3.pstatp.com/obj/573b00027992d9665a44","https://pb3.pstatp.com/obj/573b00027992d9665a44"]}
         * bid : 1028
         * height : 518
         * schema : https://www.amemv.com/aweme/in_app/activity/pic/?img=douyinshequgongyue%202_0ac11e17495f02e83772623c19f7e07e
         * title : 抖音社区公约
         * width : 1080
         */

        private BannerUrlBean banner_url;
        private String bid;
        private int height;
        private String schema;
        private String title;
        private int width;

        public BannerUrlBean getBanner_url() {
            return banner_url;
        }

        public void setBanner_url(BannerUrlBean banner_url) {
            this.banner_url = banner_url;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public static class BannerUrlBean {
            /**
             * uri : 573b00027992d9665a44
             * url_list : ["https://p1.pstatp.com/obj/573b00027992d9665a44","https://pb3.pstatp.com/obj/573b00027992d9665a44","https://pb3.pstatp.com/obj/573b00027992d9665a44"]
             */

            private String uri;
            private List<String> url_list;

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public List<String> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<String> url_list) {
                this.url_list = url_list;
            }
        }
    }
}
