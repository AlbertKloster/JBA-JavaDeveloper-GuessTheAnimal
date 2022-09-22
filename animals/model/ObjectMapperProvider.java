package animals.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class ObjectMapperProvider {
    public static ObjectMapper getObjectMapper(String type) {
        switch (type) {
            case "xml": return new XmlMapper();
            case "yaml": return new YAMLMapper();
            case "json":
            default: return new JsonMapper();
        }
    }
}
