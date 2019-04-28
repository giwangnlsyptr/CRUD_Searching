package com.example.crud.presenter;

public interface MainInterface {
    void getAllItems();
    void getItems(String id);
    void updateItems(String id, String name, String description);
    void deleteItems(String id);
    void createItems(String name, String description);
}
