package com.zhchenai.eg.example;

import java.util.List;

/**
 *  数据来源：http://wthrcdn.etouch.cn （不能访问）
 *  参考博客：https://blog.csdn.net/weixin_40877388/article/details/86526154
 */
public class ExampleEntity {

    private DataBean data;
    private int status;
    private String desc;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class DataBean {
        /**
         * yesterday : {"date":"16日星期三","high":"高温 -1℃","fx":"西南风","low":"低温 -16℃","fl":"<![CDATA[3-4级]]>","type":"晴"}
         * city : 沈阳
         * forecast : [{"date":"17日星期四","high":"高温 -3℃","fengli":"<![CDATA[<3级]]>","low":"低温 -17℃","fengxiang":"东北风","type":"晴"},{"date":"18日星期五","high":"高温 1℃","fengli":"<![CDATA[<3级]]>","low":"低温 -14℃","fengxiang":"西南风","type":"晴"},{"date":"19日星期六","high":"高温 -2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -14℃","fengxiang":"西北风","type":"晴"},{"date":"20日星期天","high":"高温 -2℃","fengli":"<![CDATA[<3级]]>","low":"低温 -12℃","fengxiang":"西北风","type":"晴"},{"date":"21日星期一","high":"高温 3℃","fengli":"<![CDATA[<3级]]>","low":"低温 -10℃","fengxiang":"西南风","type":"晴"}]
         * ganmao : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
         * wendu : -2
         */

        private YesterdayBean yesterday;
        private String city;
        private String ganmao;
        private String wendu;
        private List<ForecastBean> forecast;

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 16日星期三
             * high : 高温 -1℃
             * fx : 西南风
             * low : 低温 -16℃
             * fl : <![CDATA[3-4级]]>
             * type : 晴
             */

            private String date;
            private String high;
            private String fx;
            private String low;
            private String fl;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class ForecastBean {
            /**
             * date : 17日星期四
             * high : 高温 -3℃
             * fengli : <![CDATA[<3级]]>
             * low : 低温 -17℃
             * fengxiang : 东北风
             * type : 晴
             */

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
