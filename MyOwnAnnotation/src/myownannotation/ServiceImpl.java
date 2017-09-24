/*
 */
package myownannotation;

/**
 *
 * @author adam-bien.com
 */
public class ServiceImpl implements Service {

    @Override
    public void serve() {
        System.out.println("Served from impl!");
    }

}
