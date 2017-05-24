package ir.comet.database;

import ir.comet.model.Settings;

import java.util.List;


public class SettingsDaoImp implements SettingsDao {

    private SQLService sqlService;

    public SettingsDaoImp()
    {
        sqlService = new SQLService();
    }

    @Override
    public Settings getSettings(long adminId) {
        List result = sqlService.getObjectsBySpecialColumn(new Settings(),"adminId",adminId);
        if (result.isEmpty())
            return null;
        else
            return (Settings) result.get(0);
    }

    @Override
    public boolean updateSettings(Settings settings) {
        return sqlService.update(settings);
    }
}
