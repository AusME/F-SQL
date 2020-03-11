package name.ben.shepley.fsql._framework.wrapper;

public abstract class NestedBuilder<P> {
    private P p;

    public NestedBuilder(P p) {
        this.p = p;
    }

    public P done() {
        return p;
    }
}