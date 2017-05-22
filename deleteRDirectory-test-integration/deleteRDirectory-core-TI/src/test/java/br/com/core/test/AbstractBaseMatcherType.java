package br.com.core.test;

import org.hamcrest.BaseMatcher;

public abstract class AbstractBaseMatcherType<T>
    extends
    BaseMatcher<T> {

    @Override
    public boolean matches(
        final Object o) {
        return execute((T) o);
    }

    protected abstract boolean execute(
        T o);
}
