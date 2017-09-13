package ie.eric.sean;

/**
 * Created by smcgrath on 13/09/2017.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
