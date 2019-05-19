package PropertyFileHandler;

import ChatExceptions.PropertyFileException;

import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandler {
    private static volatile PropertyFileHandler instance;
    private Properties configFile;
    private final static String FILE_PROPERTIES_NAME = "/chatConfig.properties";
    private final static Object monitor = new Object();

    private PropertyFileHandler() throws IOException {
        configFile = new Properties();
        configFile.load(PropertyFileHandler.class.getResourceAsStream(FILE_PROPERTIES_NAME));
    }

    public static PropertyFileHandler getInstance() throws IOException {
        PropertyFileHandler localInstance = instance;
        if (localInstance == null){
            synchronized (monitor){
                localInstance = new PropertyFileHandler();
                instance = localInstance;
            }
        }
        return instance;
    }

    public int getIntegerValue(String propertyName) throws PropertyFileException {
        return Integer.valueOf(getProperty(propertyName));
    }

    public boolean getBooleanValue(String propertyName) throws PropertyFileException {
        return Boolean.valueOf(getProperty(propertyName));
    }

    public String getProperty(String propertyName) throws PropertyFileException{
        if(!configFile.containsKey(propertyName)) {
            throw new PropertyFileException("No such property: " + propertyName);
        }
        return configFile.getProperty(propertyName);
    }
}
