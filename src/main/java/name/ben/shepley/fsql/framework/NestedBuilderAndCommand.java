package name.ben.shepley.fsql.framework;

public interface NestedBuilderAndCommand<C, P> {
    /* Child */
    public abstract C getCommand();

    /* Parent */
    public abstract NestedBuilderAndCommand<C, P> setParent(P p);
    public abstract P done();
}