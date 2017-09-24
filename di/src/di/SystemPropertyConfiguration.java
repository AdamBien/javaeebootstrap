/*
 */
package di;

/**
 *
 * @author adam-bien.com
 */
public class SystemPropertyConfiguration implements Configuration {

    @Override
    public String getConfig(String key) {
        return System.getProperty(key);
    }

}
