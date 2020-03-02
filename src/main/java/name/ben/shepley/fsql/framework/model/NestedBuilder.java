package name.ben.shepley.fsql.framework.model;

public abstract class NestedBuilder<P> {
    private P p;

    public NestedBuilder(P p) {
        this.p = p;
    }

    public P done() {
        return p;
    }
}