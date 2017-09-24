/*
 */
package di;

/**
 *
 * @author adam-bien.com
 */
public class ObjectFactory {

    private final static ObjectFactory INSTANCE = new ObjectFactory();

    private Object product;

    private ObjectFactory() {
        try {
            this.product = Class.forName("di.SystemPropertyConfiguration").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            throw new IllegalStateException("Product not found", ex);
        }
    }

    public static final ObjectFactory getInstance() {
        return INSTANCE;
    }

    public Object create() {
        return this.product;
    }

}
