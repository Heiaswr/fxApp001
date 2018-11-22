package be.technifutur.mobile.util;

import java.util.ArrayList;

public class NavigationMessenger {

    // region Singleton

    private static NavigationMessenger instance;

    public static NavigationMessenger getInstance() {

        if (instance == null) {
            instance = new NavigationMessenger();
        }

        return instance;
    }

    private NavigationMessenger() {
    }

    // endregion

    private ArrayList<Listener> listeners = new ArrayList<>();

    public void navigateTo(Page page) {
        navigateTo(page, null);
    }

    public void navigateTo(Page page, Object data) {

        for (int i = 0; i < listeners.size(); i++)
        {
            Listener listener = listeners.get(i);
            listener.onNavigateTo(page, data);
        }
    }

    public void register(Listener listener) {
        this.listeners.add(listener);
    }

    public interface Listener {

        void onNavigateTo(Page page, Object data);
    }
}
