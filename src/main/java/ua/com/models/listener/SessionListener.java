package ua.com.models.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ����� ��������� ������ ��������� HttpSessionListener ��� ��������� �����������
 * �� ���������� ������� ���������� ����� HttpSession.
 */
public class SessionListener implements HttpSessionListener {

    /**
     * �������� �������.
     */
    private static final int INTERVAL = 30 * 24 * 60 * 60;

    /**
     * �������� ����������� � ���, ��� ��� ������ �����.
     * ������������ �������� ���������� 1 ����.
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        sessionEvent.getSession().setMaxInactiveInterval(INTERVAL);
    }

    /**
     * �������� ����������� � ���, ��� ������ ������ ����� �������� ����������������.
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        sessionEvent.getSession().invalidate();
    }
}