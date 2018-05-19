package br.com.app.challenge.service;

import com.google.firebase.appindexing.builders.PostalAddressBuilder;

import java.util.Map;

import br.com.app.challenge.model.CommonUser;
import br.com.app.challenge.storage.commonUser.GET_CommonUser;
import br.com.app.challenge.storage.commonUser.POST_CommonUser;
import br.com.app.challenge.storage.commonUser.POST_Login;

public class CommonUserService {

    GET_CommonUser get_commonUser;
    POST_CommonUser post_commonUser;
    POST_Login post_login;

    public CommonUserService(){
        get_commonUser = new GET_CommonUser();
        post_commonUser = new POST_CommonUser();
        post_login = new POST_Login();
    }

    public CommonUser get(String id){
        CommonUser commonUser = null;
        get_commonUser.execute(id);
        return commonUser;
    }

    public Boolean post(Map<String, String> postEntity){
        post_commonUser.setPostEntity(postEntity);
        post_commonUser.execute("");
        return true;
    }

    public Boolean login(Map<String, String> postEntity){
        post_login.setPostEntity(postEntity);
        post_login.execute("");
        return true;
    }

}
