package com.bhavik.services.covid19.api.model.getdata.request;

public class Covid19DataRequest {

    private Covid19DataSelect select;
    private Covid19DataWhere where;

    public Covid19DataSelect getSelect() {
        return select;
    }

    public void setSelect(Covid19DataSelect select) {
        this.select = select;
    }

    public Covid19DataWhere getWhere() {
        return where;
    }

    public void setWhere(Covid19DataWhere where) {
        this.where = where;
    }
}
