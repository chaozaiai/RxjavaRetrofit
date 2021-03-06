package com.techidea.domain.interactor;

import com.techidea.domain.entity.CityInfo;
import com.techidea.domain.entity.CityItem;
import com.techidea.domain.respository.DataRepositoryDomain;

import java.util.List;

import rx.Observable;

/**
 * Created by zchao on 2016/7/19.
 */
public class GetCityList extends RxBaseCase<List<CityItem>> {

    private String cityname;
    private DataRepositoryDomain mDataRepositoryDomain;

    public GetCityList(DataRepositoryDomain dataRepositoryDomain) {
        this.mDataRepositoryDomain = dataRepositoryDomain;
    }

    @Override
    public RxBaseCase initParams(String... paras) {
        this.cityname = paras[0];
        return this;
    }

    @Override
    public Observable<List<CityItem>> execute() {
        return mDataRepositoryDomain.getCityList(cityname);
    }
}
