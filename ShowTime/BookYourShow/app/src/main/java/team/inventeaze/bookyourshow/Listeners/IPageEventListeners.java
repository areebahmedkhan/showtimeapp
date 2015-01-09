package team.inventeaze.bookyourshow.Listeners;

/**
 * Created by AbdulMueed on 1/9/2015.
 */
public interface IPageEventListeners {
    public void EventInPage(int viewId, String eventName, Object object);
    public void ViewPageDone(int viewId);
    public void ViewPageFinish(int viewId);
}
