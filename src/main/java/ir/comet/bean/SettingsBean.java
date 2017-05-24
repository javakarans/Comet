package ir.comet.bean;

import ir.comet.model.Settings;
import ir.comet.model.SettingsData;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by amir on 5/24/2017.
 */
@ManagedBean
@ViewScoped
public class SettingsBean {

    private SettingsData settingsData;
    private Settings settings;
    private String currentPassWord;
    private String firstNewPassWord;
    private String secondNewPassWord;


    @PostConstruct
    public void init()
    {
        settingsData = SettingsData.getInstance();
        settings = settingsData.getSettings();
    }

    public void changePassword()
    {
        if (currentPassWord.equals(settings.getAdminPassword()))
        {
            if (firstNewPassWord.equals(secondNewPassWord))
            {
                settings.setAdminPassword(firstNewPassWord);
                settingsData.updateSettings(settings);
            }
        }
    }

    public void changeUserName()
    {
        settingsData.updateSettings(settings);
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getCurrentPassWord() {
        return currentPassWord;
    }

    public void setCurrentPassWord(String currentPassWord) {
        this.currentPassWord = currentPassWord;
    }

    public String getFirstNewPassWord() {
        return firstNewPassWord;
    }

    public void setFirstNewPassWord(String firstNewPassWord) {
        this.firstNewPassWord = firstNewPassWord;
    }

    public String getSecondNewPassWord() {
        return secondNewPassWord;
    }

    public void setSecondNewPassWord(String secondNewPassWord) {
        this.secondNewPassWord = secondNewPassWord;
    }
}
