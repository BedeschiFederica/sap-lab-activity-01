package mvc;

public class ViewLogger implements View {

    @Override
    public void stateChanged(final int state) {
        log("State value: " + state);
    }

    private void log(final String msg) {
        System.out.println("[Output] " + msg);
    }
}
