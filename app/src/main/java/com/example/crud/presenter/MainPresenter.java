package com.example.crud.presenter;


import com.example.crud.model.Create.PostResponse;
import com.example.crud.model.GetAll.GetResponse;
import com.example.crud.model.GetItem.GetItemResponse;
import com.example.crud.remote.BaseApp;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface{
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }


    public void getAllItems() {
        BaseApp.apiService.getAllItems().enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                if (response.isSuccessful())
                    mainView.getSuccess(response.body());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    public void getItems(String id) {
        BaseApp.apiService.getItems(id).enqueue(new Callback<GetItemResponse>() {
            @Override
            public void onResponse(Call<GetItemResponse> call, Response<GetItemResponse> response) {
                if (response.isSuccessful())
                    mainView.getSuccess2(response.body());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<GetItemResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    public void updateItems(String id, String name, String description) {
        BaseApp.apiService.updateDataItems(id, name, description).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject>
                    response) {
                if (response.isSuccessful())
                    mainView.setToast(response.message());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }


    public void deleteItems(String id) {
        BaseApp.apiService.deleteDataItems(id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject>
                    response) {
                if (response.isSuccessful())
                    mainView.setToast(response.message());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    public void createItems(String name, String description) {
        BaseApp.apiService.createItems(name, description).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call,
                                   Response<PostResponse> response) {
                if (response.isSuccessful())
                    mainView.setToast(response.message());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}
