package com.nesp.javafx.sample;

import com.nesp.sdk.javafx.ApplicationContext;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Team: NESP Technology
 * Author: <a href="mailto:1756404649@qq.com">JinZhaolu Email:1756404649@qq.com</a>
 * Time: Created 2021/12/2 上午8:53
 * Description:
 **/
public class App extends ApplicationContext {

    private static final String TAG = "Main";

    @Override
    public void start(final Stage primaryStage) throws Exception {
        MainStage.showWindow();
        primaryStage.hide();
    }

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }
}
