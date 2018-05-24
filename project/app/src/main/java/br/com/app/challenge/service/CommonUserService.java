package br.com.app.challenge.service;

import br.com.app.challenge.model.CommonUser;
import br.com.app.challenge.storage.CommonUserStorage;

public class CommonUserService {

    CommonUserStorage commonUserStorage;

    public CommonUserService(){
        commonUserStorage = new CommonUserStorage();
    }

    public CommonUser get(String id){
        CommonUser commonUser = null;
        commonUserStorage.get();
        return commonUser;
    }

}
