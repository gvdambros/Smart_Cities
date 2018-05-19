package br.com.app.challenge.service;

import com.google.firebase.appindexing.builders.PostalAddressBuilder;

import br.com.app.challenge.model.CommonUser;
import br.com.app.challenge.storage.commonUser.GET_CommonUser;
import br.com.app.challenge.storage.commonUser.POST_CommonUser;

public class CommonUserService {

    GET_CommonUser get_commonUser;
    POST_CommonUser post_commonUser;

    public CommonUserService(){
        get_commonUser = new GET_CommonUser();
        post_commonUser = new POST_CommonUser();
    }

    public CommonUser get(String id){
        CommonUser commonUser = null;

        get_commonUser.execute(id);


        return commonUser;
    }

    public Boolean post(){

        post_commonUser.execute("1");

        return true;
    }

}
