package com.example.crud.presenter;


import com.example.crud.model.GetAll.GetResponse;
import com.example.crud.model.GetItem.GetItemResponse;

public interface MainView {
    void getSuccess(GetResponse list);

    void getSuccess2(GetItemResponse itemList);

    void setToast(String message);

    void onError(String errorMessage);

    void onFailure(String failureMessage);

}
