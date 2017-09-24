/*
 */
package myownannotation;

/**
 *
 * @author adam-bien.com
 */
public class Facade {

    @MyInject(MyInject.DayTime.MORNING)
    private Service service;

    String somethingElse;

    public void invokeService() {
        service.serve();;
    }

    @Override
    public String toString() {
        service.serve();
        return "Facade{" + "service=" + service + ", somethingElse=" + somethingElse + '}';
    }

}
