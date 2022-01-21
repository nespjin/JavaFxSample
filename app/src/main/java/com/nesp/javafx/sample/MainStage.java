package com.nesp.javafx.sample;

import com.nesp.sdk.java.lang.SingletonFactory;
import com.nesp.sdk.javafx.BaseStage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

/**
 * Team: NESP Technology
 * Author: <a href="mailto:1756404649@qq.com">JinZhaolu Email:1756404649@qq.com</a>
 * Time: Created 2021/12/2 上午9:06
 * Description:
 **/
public class MainStage extends BaseStage {

    private static final String TAG = "MainStage";

    private MainStage() {
        //no instance
    }

    private MainStageViewBinding mBinding;

    private static boolean isShown = false;

    public static void showWindow() {
        if (isShown) return;
        var shared =
                SingletonFactory.getWeakInstance(MainStage.class, MainStage::new);
        shared.show();
        isShown = true;
    }

    @Override
    public void onCreate(final @NotNull Stage stage) {
        super.onCreate(stage);
        initializeViews();
    }

    private void initializeViews() {
        mBinding = MainStageViewBinding.inflate(R.layout.main_stage);
        setContent(mBinding.getRoot());
        final String title = getResource().getString(R.string.app_name);
        setTitle(title);

        StringProperty buttonText = new SimpleStringProperty("Click Me");

        IntegerProperty clickCount = new SimpleIntegerProperty() {
            @Override
            protected void invalidated() {
                super.invalidated();
                buttonText.setValue("Clicked " + get());
            }
        };

        try {
            mBinding.btn_click.setOnMouseClicked(event -> clickCount.set(clickCount.get() + 1));
            mBinding.btn_click.textProperty().bind(buttonText);

            mBinding.btn_switch_lang.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(final MouseEvent event) {
                    if (Objects.equals(Locale.getDefault().getLanguage(), "zh")) {
                        Locale.setDefault(Locale.ENGLISH);
                        mBinding.btn_switch_lang.setText("中文");
                    } else {
                        Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
                        mBinding.btn_switch_lang.setText("English");
                    }

                    recreate();
                }
            });

            if (!Objects.equals(Locale.getDefault().getLanguage(), "zh")) {
                mBinding.btn_switch_lang.setText("中文");
            } else {
                mBinding.btn_switch_lang.setText("English");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
