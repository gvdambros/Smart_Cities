package br.com.app.challenge.storage.commonUser;

import br.com.commons.storage.POST;

public class POST_CommonUser extends POST {



    @Override
    public String getURL() {
        return "http://192.168.0.11/commonUsers/post.php";
    }

    @Override
    public Integer getSuccessfulResponse() {
        return 201;
    }

}