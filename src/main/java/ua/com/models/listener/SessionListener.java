package ua.com.models.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *  ласс реализует методы интерфейс HttpSessionListener дл€ получени€ уведомлени€
 * об изменени€х событий жизненного цикла HttpSession.
 */
public class SessionListener implements HttpSessionListener {

    /**
     * »нтервал времени.
     */
    private static final int INTERVAL = 30 * 24 * 60 * 60;

    /**
     * ѕолучает уведомление о том, что был создан сеанс.
     * ћаксимальный интервал активности 1 день.
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        sessionEvent.getSession().setMaxInactiveInterval(INTERVAL);
    }

    /**
     * ѕолучает уведомление о том, что сесси€ вскоре будет признана недействительной.
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        sessionEvent.getSession().invalidate();
    }
}
