package com.isso.test;


import java.util.List;

public class QueryResultInfo {
    private int error_code;
    private String reason;
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result {

        private String content;
        private String hashId;
        private int unixtime;
        private String updatetime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Result [content=" + content + ", hashId=" + hashId + ", unixtime=" + unixtime + ", updatetime=" + updatetime+",error_code="+error_code+",reason="+reason+"]";
        }

    }

    @Override
    public String toString() {
        return "QueryResultInfo [ result=" + result.toString() + "]";
    }

}



